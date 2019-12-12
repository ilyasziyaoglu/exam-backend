package exam.backend.user_answers_rel.db.entity;

import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.options.db.entity.Options;
import exam.backend.questions.db.entity.Question;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "USER_ANSWERS")
@Data
@EqualsAndHashCode(callSuper = false)
public class UserAnswers extends AbstractEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = GlobalConstants.DB_PREFIX + "USER_ANSWERS_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "USER_ANSWERS_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = GlobalConstants.DB_PREFIX + "USER_ANSWERS_ID_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "question_id", foreignKey=@ForeignKey(name="USER_ANSWERS_QUESTIONS_MTO"))
    private Question question;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "option_id", foreignKey=@ForeignKey(name="USER_ANSWERS_OPTIONS_MTO"))
    private Options option;
}
