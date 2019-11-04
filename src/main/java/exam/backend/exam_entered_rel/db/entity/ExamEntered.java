package exam.backend.exam_entered_rel.db.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.exam.db.entity.Exam;
import exam.backend.options.db.entity.Options;
import exam.backend.questions.db.entity.Questions;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "EXAM_ENTERED")
@Data
@EqualsAndHashCode(callSuper = false)
public class ExamEntered extends AbstractEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = GlobalConstants.DB_PREFIX + "EXAM_ENTERED_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "EXAM_ENTERED_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = GlobalConstants.DB_PREFIX + "EXAM_ENTERED_ID_GEN", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "exam_score")
    private float examScore;

    @Column(name = "is_entered")
    private boolean isEntered;

    @Column(name = "exam_duration")
    private int examDuration;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_entered_id")
    private HashMap<Questions, Options> userAnswers;
}
