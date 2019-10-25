package exam.backend.offers.controller;
import exam.backend.common.controller.BaseEntityController;
import exam.backend.offers.db.entity.Offer;
import exam.backend.offers.db.mapper.OfferMapper;
import exam.backend.offers.db.repository.OfferRepository;
import exam.backend.offers.service.OfferService;
import exam.client.catalog.dto.filter.OfferFilterDto;
import exam.client.common.dto.pager.PageDto;
import exam.client.common.dto.pager.PageResource;
import exam.client.common.dto.response.JsonResponse;
import exam.client.offer.dto.request.OfferRequest;
import exam.client.offer.dto.request.OfferStatusChangedRequest;
import exam.client.offer.dto.response.OfferResponse;
import exam.client.offer.enumeration.OfferStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//import exam.backend.common.config.security.TokenUtils;

@RestController
@RequestMapping("/offer")
public class OfferController extends BaseEntityController<OfferRequest, OfferResponse, Offer, OfferRepository, OfferService, OfferMapper> {

	@Resource
	private OfferService offerService;

	@Resource
	private OfferMapper offerMapper;

	@Override
	protected OfferService getService() {
		return offerService;
	}

	@Override
	protected OfferMapper getMapper() {
		return offerMapper;
	}

	@GetMapping("states")
	public JsonResponse<PageResource<OfferStatus[]>> getStates() {
		JsonResponse json = new JsonResponse();
		json.setResult(OfferStatus.values());
		return json;
	}

	@PostMapping("/filter")
	public JsonResponse<PageResource<List<OfferResponse>>> filterOffer(@RequestBody PageDto<OfferFilterDto> pageDto) {
		JsonResponse json = new JsonResponse();
		PageResource<List<OfferResponse>> filter = getService().filterOffer(pageDto);
		json.setResult(filter);
		return json;
	}

	@GetMapping("/basket")
	public JsonResponse<List<OfferResponse>> basket() {
		JsonResponse json = new JsonResponse();

//		UserResponse loggedUser = TokenUtils.getLoggedUser(request);

		PageDto<OfferFilterDto> pageDto = new PageDto<>();
		OfferFilterDto filterDto = new OfferFilterDto();
		filterDto.setCurrentStatus(OfferStatus.BASKET);
//		filterDto.setFromCompany(loggedUser.getCompany().getId().toString());
		pageDto.setSize(999);
		pageDto.setFilterDto(filterDto);

		PageResource<List<OfferResponse>> filter = getService().filterOffer(pageDto);

		json.setResult(filter.getData());
		return json;
	}

	@PostMapping("/change-status")
	public JsonResponse<OfferResponse> changeStatus(@RequestBody OfferStatusChangedRequest offerStatusChangedRequest) {
		return getService().changeStatus(offerStatusChangedRequest);
	}

	@PostMapping("/create")
	public JsonResponse<Boolean> create(@RequestBody List<Long> idList) {

		for (Long id : idList) {
			OfferStatusChangedRequest req = new OfferStatusChangedRequest();
			req.setOfferId(id);
			JsonResponse jsonResponse = getService().changeStatus(req);
		}

		JsonResponse<Boolean> booleanJsonResponse = new JsonResponse<>();
		booleanJsonResponse.setResult(true);
		return booleanJsonResponse;
	}
}
