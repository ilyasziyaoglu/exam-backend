package exam.backend.old.catalog.db.repository.product;

import exam.backend.old.catalog.db.entity.company.Company;
import exam.backend.old.catalog.db.entity.product.Distributor;
import exam.backend.old.catalog.db.entity.product.Product;
import exam.client.catalog.dto.filter.ProductFilterDto;
import exam.backend.common.db.specification.AbstractSpecification;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.boot.Metadata;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductQuery extends AbstractSpecification<Product, ProductFilterDto> {


	public Specification<Product> filter(ProductFilterDto dto) {
		return new Specification<Product>() {
			@Override
			public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> criteria, CriteriaBuilder cb) {
				ProductFilterDto searchDto = dto != null ? dto : new ProductFilterDto();


				List<Predicate> predicates = new ArrayList<>();

				if (StringUtils.isNotEmpty(dto.getProductNumber())) {
					predicates.add(cb.like(root.get("productNumber"), "%" + dto.getProductNumber() + "%"));
				}

				if (StringUtils.isNotEmpty(dto.getName())){
					predicates.add(cb.like(cb.lower(root.get("name")), "%" + dto.getName().toLowerCase() + "%"));
				}
//
				if (StringUtils.isNotEmpty(dto.getDistributors())) {

					Join<Distributor, Metadata> distributorJoin = root.join("distributors");
					Join<Company, Metadata> companyJoin = distributorJoin.join("company");
					predicates.add(cb.equal(companyJoin.get("id"), dto.getDistributors()));

				}
//
				if (CollectionUtils.isNotEmpty(dto.getCategoryIds())) {
					predicates.add(root.get("categoryId").in(dto.getCategoryIds()));
				}

				criteria.orderBy(cb.desc(root.get("id")));
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		};
	}

}

