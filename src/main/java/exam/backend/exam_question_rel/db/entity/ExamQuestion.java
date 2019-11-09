package exam.backend.exam_question_rel.db.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.exam.db.entity.Exam;
import exam.backend.questions.db.entity.Questions;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "EXAM_QUESTION")
@Data
@EqualsAndHashCode(callSuper = false)
public class ExamQuestion extends AbstractEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = GlobalConstants.DB_PREFIX + "EXAM_QUESTION_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "EXAM_QUESTION_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = GlobalConstants.DB_PREFIX + "EXAM_QUESTION_ID_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "question_order")
    private int questionOrder;

    @Column
    private int point;

    @Column(name = "option_count")
    private int optionCount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id", nullable = false)
    private Questions question;

}
