package exam.backend.catalog.db.entity.product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import exam.backend.common.db.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import static exam.backend.common.constant.GlobalConstants.DB_PREFIX;

@Entity
@Table(name = DB_PREFIX + "PRODUCT_FEATURES")
@Data
@EqualsAndHashCode(callSuper = false)
//		exclude = { "name", "description", "productNumber" ,"producer"})
//@ToString(exclude = { "name", "description", "productNumber","producer"})
public class ProductFeature extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = DB_PREFIX + "PRODUCT_FEATURE_ID_GEN", sequenceName = DB_PREFIX + "PRODUCT_FEATURE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = DB_PREFIX + "PRODUCT_FEATURE_ID_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "feature_id", nullable = false)
	private Feature feature;

	@Column
	private String value;
}
