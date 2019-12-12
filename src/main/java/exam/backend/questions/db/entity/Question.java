package exam.backend.questions.db.entity;

import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.options.db.entity.Options;
import exam.backend.question_subject.db.entity.Subject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "QUESTIONS")
@Data
@EqualsAndHashCode(callSuper = false)
public class Question extends AbstractEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = GlobalConstants.DB_PREFIX + "QUESTIONS_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "QUESTIONS_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = GlobalConstants.DB_PREFIX + "QUESTIONS_ID_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "body")
    private String body;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "question_id", foreignKey=@ForeignKey(name="QUESTIONS_OPTIONS_OTM"), updatable = false)
    private List<Options> options;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_subject_id", foreignKey=@ForeignKey(name="QUESTIONS_QUESTION_SUBJECT_MTO"), updatable = false)
    private Subject subject;
}
