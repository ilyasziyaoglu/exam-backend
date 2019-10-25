package exam.backend.offers.db.mapper;


import exam.client.offer.dto.request.OfferRequest;
import exam.client.offer.dto.response.OfferResponse;
import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.offers.db.entity.Offer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper extends BaseMapper<Offer, OfferRequest, OfferResponse> {
    OfferResponse toSimpleResponse(Offer entity);
}
