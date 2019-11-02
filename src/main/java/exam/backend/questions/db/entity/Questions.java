package exam.backend.questions.db.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.exam_question_rel.db.entity.ExamQuestion;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "QUESTIONS")
@Data
@EqualsAndHashCode(callSuper = false)
public class Questions extends AbstractEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = GlobalConstants.DB_PREFIX + "QUESTIONS_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "QUESTIONS_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = GlobalConstants.DB_PREFIX + "QUESTIONS_ID_GEN", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String email;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private List<ExamQuestion> examQuestions;

    @Column
    private String body;

    @Column(name = "image_url")
    private String imageUrl;

}
