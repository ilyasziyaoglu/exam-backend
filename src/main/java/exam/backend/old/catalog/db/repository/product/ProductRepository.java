package exam.backend.old.catalog.db.repository.product;

import exam.backend.old.catalog.db.entity.product.Product;
import exam.backend.common.db.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public interface ProductRepository extends BaseRepository<Product> {

	Product findByProductNumber(String productNumber);

	Product findByIdNotAndProductNumber(Long id, String productNumber);

	List<Product> findProductsByIdIn(List<Long> ids);

	List<Product> findProductsByProductNumberIn(Set<String> ids);

	default Map<String, Long> findByClientIdMap(Set<String> ids) {
		return findProductsByProductNumberIn(ids).stream().collect(Collectors.toMap(Product::getProductNumber, Product::getId));
	}

	@Modifying
	@Transactional
	@Query(value = "insert into ED_RELATED_PRODUCTS (PRODUCT_ID,RELATED_PRODUCT_ID) values(:productId,:relatedProductId)",nativeQuery = true)
	void saveProductRelated(Long productId, Long relatedProductId);

}
