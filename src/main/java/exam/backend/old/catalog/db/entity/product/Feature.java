package exam.backend.old.catalog.db.entity.product;

import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


@Entity
@Table(name = "FEATURES")
@Data
@EqualsAndHashCode(callSuper = false)
//		exclude = { "name", "description", "productNumber" ,"producer"})
//@ToString(exclude = { "name", "description", "productNumber","producer"})
public class Feature extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = GlobalConstants.DB_PREFIX + "FEATURES_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "FEATURES_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = GlobalConstants.DB_PREFIX + "FEATURES_ID_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column
	private String key;

	@Column
	private String name;
}
