package exam.backend.user.db.entity.user;

import exam.client.common.enumeration.Status;
import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.converter.StatusEnumConverter;
import exam.backend.common.db.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "ROLES")
@Data
@EqualsAndHashCode(callSuper = false)
public class Role extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = GlobalConstants.DB_PREFIX + "ROLE_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "ROLE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = GlobalConstants.DB_PREFIX + "ROLE_ID_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Convert(converter = StatusEnumConverter.class)
	private Status status;

	private String name;

	private String description;

//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = DB_PREFIX + "ROLE_PERMISSIONS", joinColumns = { @JoinColumn(name = "PERMISSION_ID", nullable = false) },
//			inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", nullable = false) })
//	private Set<Permission> permissions = new HashSet<>();

}
