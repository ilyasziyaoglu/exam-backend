package exam.backend.common.db.entity.property;

import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "PROPERTIES")
@Data
@EqualsAndHashCode(callSuper = false)
public class Property extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = GlobalConstants.DB_PREFIX + "PROPERTY_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "PROPERTY_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = GlobalConstants.DB_PREFIX + "PROPERTY_ID_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "prop_key")
	private String key;

	@Column(name = "prop_value")
	private String value;

	@Column
	private String description;

}
