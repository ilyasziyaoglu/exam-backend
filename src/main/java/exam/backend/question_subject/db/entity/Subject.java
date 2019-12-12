package exam.backend.question_subject.db.entity;

import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.questions.db.entity.Question;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "QUESTION_SUBJECT")
@Data
@EqualsAndHashCode(callSuper = false)
public class Subject extends AbstractEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = GlobalConstants.DB_PREFIX + "QUESTION_SUBJECT_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "QUESTION_SUBJECT_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = GlobalConstants.DB_PREFIX + "QUESTION_SUBJECT_ID_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "subject_id", foreignKey=@ForeignKey(name="SUBJECT_QUESTION_OTM"))
    private List<Question> questions;
}
