package exam.backend.users.db.entity;

import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "USERS")
@Data
@EqualsAndHashCode(callSuper = false)
public class Users extends AbstractEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = GlobalConstants.DB_PREFIX + "USERS_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "USERS_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = GlobalConstants.DB_PREFIX + "USERS_ID_GEN", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column
    private String username;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column
    private boolean gender;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "money_balance")
    private float moneyBalance;

    @Column(name = "register_date")
    private ZonedDateTime registerDate;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "user_type")
    private int userType;


}
