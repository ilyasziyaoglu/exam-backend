package exam.backend.exam_question_rel.db.entity;

import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "EXAM_QUESTION")
@Data
@EqualsAndHashCode(callSuper = false)
public class ExamQuestion extends AbstractEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = GlobalConstants.DB_PREFIX + "EXAM_QUESTION_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "EXAM_QUESTION_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = GlobalConstants.DB_PREFIX + "EXAM_QUESTION_ID_GEN", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "question_order")
    private int questionOrder;

    @Column
    private int point;

    @Column(name = "option_count")
    private int optionCount;

}
