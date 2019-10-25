package exam.backend.offers.service;

import exam.backend.catalog.db.entity.product.Product;
import exam.backend.catalog.db.repository.product.ProductRepository;
import exam.backend.catalog.service.product.DistributorService;
import exam.backend.common.model.MailEvent;
import exam.backend.common.service.BaseEntityService;
import exam.backend.common.service.MailService;
import exam.backend.common.service.ServiceResult;
import exam.backend.common.util.PropertyUtil;
import exam.backend.offers.db.entity.Offer;
import exam.backend.offers.db.mapper.OfferMapper;
import exam.backend.offers.db.repository.OfferHistoryRepository;
import exam.backend.offers.db.repository.OfferQuery;
import exam.backend.offers.db.repository.OfferRepository;
import exam.backend.user.db.entity.user.User;
import exam.backend.user.db.repository.UserRepository;
import exam.backend.user.service.UserService;
import exam.client.catalog.dto.filter.OfferFilterDto;
import exam.client.common.dto.pager.PageDto;
import exam.client.common.dto.pager.PageResource;
import exam.client.common.dto.response.JsonResponse;
import exam.client.offer.dto.request.OfferStatusChangedRequest;
import exam.client.offer.dto.response.OfferResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//import exam.backend.common.config.security.TokenUtils;

@Service
public class OfferService extends BaseEntityService<Offer, OfferRepository> {

    @Resource
    private OfferQuery offerQuery;

    @Resource
    private OfferRepository offerRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private OfferHistoryRepository offerHistoryRepository;

    @Resource
    private UserService userService;

    @Resource
    private MailService mailService;

    @Resource
    private DistributorService distributorService;

    @Resource
    ProductRepository productRepository;

	@Resource
    private OfferMapper offerMapper;

    @Override
    public OfferRepository getRepository() {
        return offerRepository;
    }

	public OfferMapper getMapper() {
		return offerMapper;
	}

    @Override
    public ServiceResult<Offer> save(Offer offer) {

        Optional<Product> oneProduct = productRepository.findById(offer.getProductId());
        if (!oneProduct.isPresent()) {
            return new ServiceResult<>(HttpStatus.NOT_FOUND);
        }

        offer.setProduct(oneProduct.get());

        Optional<User> oneUser = userRepository.findById(offer.getUserId());



        if (!oneUser.isPresent()) {
            return new ServiceResult<>(HttpStatus.NOT_FOUND);
        }
        offer.setUser(oneUser.get());
        offer.setFromCompany(offer.getUser().getCompany());

        ServiceResult<Offer> offerServiceResult = super.save(offer);

        return offerServiceResult;
    }

    public JsonResponse changeStatus(OfferStatusChangedRequest offerStatusChangedRequest) {

        JsonResponse<OfferResponse> jsonResponse = new JsonResponse<>();
//
//        Optional<Offer> offerByIdResponse = getRepository().findById(offerStatusChangedRequest.getOfferId());
//        if (!offerByIdResponse.isPresent()) {
//        	jsonResponse.setStatus(HttpStatus.NOT_FOUND.value());
//			return jsonResponse;
//        }
//
//        Offer offer = offerByIdResponse.get();
//
//        if (offer.getCurrentStatus().equals(OfferStatus.COMPLETED) || offer.getCurrentStatus().equals(OfferStatus.REJECTED)) {
//            jsonResponse.setStatus(HttpStatus.NOT_FOUND.value());
//            jsonResponse.setMessage("Offer state is COMPLETED!");
//            return jsonResponse;
//        }
//
//        OfferStatus nextStatus = null;
//
//        if (BooleanUtils.isTrue(offerStatusChangedRequest.getReject())) {
//            UserResponse loggedUser = TokenUtils.getLoggedUser(request);
//            if (loggedUser.getCompany().getId() == offer.getFromCompany().getId()) {
//                nextStatus = OfferStatus.CANCELLED;
//            }
//            else if (loggedUser.getCompany().getId() == offer.getToCompany().getId()) {
//                nextStatus = OfferStatus.REJECTED;
//            }
//            else {
//                System.out.println("\nThere is a problem!\n");
//            }
//        } else {
//            switch (offer.getCurrentStatus().getId()){
//                case -1: { nextStatus = OfferStatus.RECEIVED; break; }
//                case 0: { nextStatus = OfferStatus.REVIEW; break; }
//                case 1: { nextStatus = OfferStatus.DISTRIBUTOR_CONFIRMED; break; }
//                case 2: { nextStatus = OfferStatus.BIDDER_CONFIRMED; break; }
//                case 3: { nextStatus = OfferStatus.BILLED; break; }
//                case 4: { nextStatus = OfferStatus.COMPLETED; break; }
//                default: { nextStatus = offer.getCurrentStatus(); }
//            }
//        }
//
//        offer.setCurrentStatus(nextStatus);
//        OfferHistory newHistory = new OfferHistory();
//        newHistory.setDescription(offerStatusChangedRequest.getDescription());
//        newHistory.setStatus(nextStatus);
//        newHistory.setDate(ZonedDateTime.now());
//
//        offer.getOfferHistory().add(newHistory);
//
//		ServiceResult<Offer> serviceResult = super.save(offer);
//		if (serviceResult.isSuccess()) {
//			jsonResponse.setResult(getMapper().toResponse(serviceResult.getValue()));
//		} else {
//			jsonResponse.setStatus(serviceResult.getHttpStatus().value());
//		}

		return jsonResponse;
    }


    public PageResource<List<OfferResponse>> filterOffer(PageDto<OfferFilterDto> pageDto) {

//		if (CollectionUtils.isNotEmpty(pageDto.getFilterDto().getCategoryIds())) {
//			//			Long first = pageDto.getFilterDto().getCategoryIds().get(0);
//			//			CategoryResponse categoryResponse = CacheUtility.ALL_CATEGORIES_MAP.get(first);
//			//			List<Long> childsIdList = categoryResponse.getChildsIdList();
//			//			pageDto.getFilterDto().getCategoryIds().addAll(childsIdList);
//		}

        Specification<Offer> specifications = offerQuery.filterOffer(pageDto.getFilterDto());

        ServiceResult<Page<Offer>> pageSR = filter(specifications, pageDto);

        Page<Offer> pageEntity = (Page) pageSR.getValue();
        List<OfferResponse> pList = new ArrayList<>();

        for (Offer offer : pageEntity.getContent()) {
            OfferResponse offerResponse = offerMapper.toSimpleResponse(offer);
            pList.add(offerResponse);
        }

        PageResource<List<OfferResponse>> pageResource = new PageResource(pageDto.getDraw(), pageEntity.getTotalElements(),
                pageEntity.getTotalElements(), pList);

        return pageResource;
    }

    private void sendofferMail(String recipientEmail, String cc, String subject, Map<String, Object> vmMap, String vmName) {
        try {
            MailEvent mailEvent = new MailEvent();
            mailEvent.setVm(vmName);
            mailEvent.setSubject(subject);
            mailEvent.setFrom(PropertyUtil.getStringValue("ecom.offer.mail.from", "TEAM-DCSD-ECOMMERCE@turkcell.entp.tgc"));
            mailEvent.setTo(recipientEmail);
            mailEvent.setCc(cc);
            mailEvent.setDataModel(vmMap);
            mailService.send(mailEvent);
        } catch (Throwable e) {
//            logger.error("an error occured when send mail vm:{0}, recipient:{1}", vmName, recipientEmail);
        }
    }

}
