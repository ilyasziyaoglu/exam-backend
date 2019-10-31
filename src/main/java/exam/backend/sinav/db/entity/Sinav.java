package exam.backend.sinav.db.entity;

import exam.backend.catalog.db.entity.company.Company;
import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "SINAVLAR")
@Data
@EqualsAndHashCode(callSuper = false)
public class Sinav extends AbstractEntity {

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = GlobalConstants.DB_PREFIX + "SINAV_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "SINAV_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = GlobalConstants.DB_PREFIX + "SINAV_ID_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column
	private String name;

	@Column
	private String description;

	@ManyToOne
	private Company company;

	@Column(name="exam_date")
	private ZonedDateTime date;

	@Column
	private int registeredCount;

	@Column
	private int questionCoun;

	@Column
	private String type;

}
