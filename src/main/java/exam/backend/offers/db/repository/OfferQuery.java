package exam.backend.offers.db.repository;

import exam.client.catalog.dto.filter.OfferFilterDto;
import exam.backend.common.db.specification.AbstractSpecification;
import exam.backend.offers.db.entity.Offer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Murat Celik
 */
@Component
public class OfferQuery extends AbstractSpecification<Offer, OfferFilterDto> {


    public static Specification<Offer> filterOffer(OfferFilterDto dto) {
        return new Specification<Offer>() {
            @Override
            public Predicate toPredicate(Root<Offer> root, CriteriaQuery<?> criteria, CriteriaBuilder cb) {
                OfferFilterDto searchDto = dto != null ? dto : new OfferFilterDto();


                List<Predicate> predicates = new ArrayList<>();

                if (StringUtils.isNotEmpty(dto.getProductNumber())) {
                    predicates.add(cb.like(root.join("product").get("productNumber"), "%" + dto.getProductNumber() + "%"));
                }

                if (dto.getCurrentStatus() != null) {
                    predicates.add(cb.equal(root.get("currentStatus"), dto.getCurrentStatus()));
                }

                if (dto.getCurrentStatusNot() != null) {

                    predicates.add(cb.notEqual(root.get("currentStatus"), dto.getCurrentStatusNot()));
                }

                if (dto.getStartDate() != null && dto.getEndDate() !=null) {
                    Predicate startDatePredicate=cb.lessThanOrEqualTo(root.get("createdDate"),dto.getEndDate());
                    Predicate endDatePredicate=cb.greaterThanOrEqualTo(root.get("createdDate"),
                            dto.getStartDate()
                    );
                    predicates.add(startDatePredicate);
                    predicates.add(endDatePredicate);

                    predicates.add(cb.lessThanOrEqualTo(root.get("createdDate"), dto.getStartDate()));
                }

				if (dto.getEndDate() != null) {
					predicates.add(cb.greaterThanOrEqualTo(root.get("createdDate"), dto.getEndDate()));
				}

				if(dto.getFromCompany()!= null){
				    predicates.add(cb.equal(root.join("fromCompany").get("id"),dto.getFromCompany()));
                }
                if(dto.getToCompany()!= null){
                    predicates.add(cb.equal(root.join("toCompany").get("id"),dto.getToCompany()));
                }

                criteria.orderBy(cb.desc(root.get("id")));
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

}

