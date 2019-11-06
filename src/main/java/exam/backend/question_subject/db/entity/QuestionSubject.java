package exam.backend.question_subject.db.entity;

import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "QUESTION_SUBJECT")
@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionSubject extends AbstractEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = GlobalConstants.DB_PREFIX + "QUESTION_SUBJECT_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "QUESTION_SUBJECT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = GlobalConstants.DB_PREFIX + "QUESTION_SUBJECT_ID_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
}
