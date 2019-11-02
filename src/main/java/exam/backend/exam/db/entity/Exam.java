package exam.backend.exam.db.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import exam.backend.catalog.db.entity.company.Company;
import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.exam_question_rel.db.entity.ExamQuestion;
import exam.backend.questions.db.entity.Questions;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "EXAMS")
@Data
@EqualsAndHashCode(callSuper = false)
public class Exam extends AbstractEntity {

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = GlobalConstants.DB_PREFIX + "EXAM_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "EXAM_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = GlobalConstants.DB_PREFIX + "EXAM_ID_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column
	private String name;

	@Column
	private String description;

	@Column(name="date_time")
	private ZonedDateTime dateTime;

	@Column(name = "registered_count")
	private int registeredCount;

	@Column(name = "question_count")
	private int questionCount;

	@Column(name = "exam_type")
	private String examType;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "exam_id")
	private List<ExamQuestion> examQuestions;

}
