package exam.backend.old.catalog.db.repository.product;

import exam.backend.old.catalog.db.entity.product.Feature;
import exam.backend.common.db.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends BaseRepository<Feature> {

	public Feature findByKey(String key);
}
