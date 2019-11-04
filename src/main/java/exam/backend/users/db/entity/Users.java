package exam.backend.users.db.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.exam.db.entity.Exam;
import exam.backend.exam_entered_rel.db.entity.ExamEntered;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "e_mail", unique = true)
    private String eMail;

    @Column(name = "user_type")
    private int userType;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "money_balance")
    private float moneyBalance;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<ExamEntered> examsEntered;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Exam> examsCreated;
}
