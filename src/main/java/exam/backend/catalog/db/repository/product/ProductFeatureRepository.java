package exam.backend.catalog.db.repository.product;

import exam.backend.catalog.db.entity.product.ProductFeature;
import exam.backend.common.db.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductFeatureRepository extends BaseRepository<ProductFeature> {
}
