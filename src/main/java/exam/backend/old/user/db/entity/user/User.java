package exam.backend.old.user.db.entity.user;

import exam.backend.old.catalog.db.entity.company.Company;
import exam.client.common.enumeration.Status;
import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.converter.StatusEnumConverter;
import exam.backend.common.db.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "USERS")
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = GlobalConstants.DB_PREFIX + "USER_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "USER_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = GlobalConstants.DB_PREFIX + "USER_ID_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Convert(converter = StatusEnumConverter.class)
	private Status status;

	private String username;

	private String email;

	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = GlobalConstants.DB_PREFIX + "USER_ROLES", joinColumns = { @JoinColumn(name = "ROLE_ID", nullable = false) },
			inverseJoinColumns = { @JoinColumn(name = "USER_ID", nullable = false) })
	private Set<Role> roles = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "company_id", foreignKey = @ForeignKey(name = "FK_P_COMPANY_ID"))
	private Company company;

}
