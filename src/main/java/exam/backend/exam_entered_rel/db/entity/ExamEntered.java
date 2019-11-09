package exam.backend.exam_entered_rel.db.entity;

import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.exam.db.entity.Exam;
import exam.backend.user_answers_rel.db.entity.UserAnswers;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "EXAM_ENTERED")
@Data
@EqualsAndHashCode(callSuper = false)
public class ExamEntered extends AbstractEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = GlobalConstants.DB_PREFIX + "EXAM_ENTERED_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "EXAM_ENTERED_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = GlobalConstants.DB_PREFIX + "EXAM_ENTERED_ID_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "exam_score")
    private float examScore;

    @Column(name = "is_entered")
    private boolean isEntered;

    @Column(name = "exam_duration")
    private int examDuration;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "exam_id", foreignKey=@ForeignKey(name="EXAM_ENTERED_EXAM_MTO"), nullable = false)
    private Exam exam;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name= "exam_entered_id", foreignKey=@ForeignKey(name="EXAM_ENTERED_USER_ANSWERS_OTM"))
    private List<UserAnswers> userAnswers;
}
