package exam.backend.old.catalog.db.entity.company;

import exam.backend.common.db.converter.StatusEnumConverter;
import exam.backend.common.db.entity.AbstractEntity;
import exam.client.common.enumeration.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import static exam.backend.common.constant.GlobalConstants.DB_PREFIX;


@Entity
@Table(name = DB_PREFIX + "COMPANIES")
@Data
@EqualsAndHashCode(callSuper = false)
public class Company extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = DB_PREFIX + "COMPANY_ID_GEN", sequenceName = DB_PREFIX + "COMPANY_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = DB_PREFIX + "COMPANY_ID_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Convert(converter = StatusEnumConverter.class)
	private Status status = Status.ACTIVE;

	@Column
	private String name;

}
