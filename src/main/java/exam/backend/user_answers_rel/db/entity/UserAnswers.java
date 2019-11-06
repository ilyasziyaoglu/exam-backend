package exam.backend.user_answers_rel.db.entity;

import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.options.db.entity.Options;
import exam.backend.questions.db.entity.Questions;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    private Questions question;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "option_id")
    private Options option;
}
