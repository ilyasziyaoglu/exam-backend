package exam.backend.exam.db.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.exam_question_rel.db.entity.ExamQuestion;
import exam.backend.exam_type.ExamType;
import exam.backend.users.db.entity.Users;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "EXAMS")
@Data
@EqualsAndHashCode()
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exam_type", foreignKey=@ForeignKey(name="EXAM_EXAM_TYPE_MTO"))
	private ExamType examType;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "exam_id", foreignKey=@ForeignKey(name="EXAM_EXAM_QUESTION_OTM"))
	private List<ExamQuestion> examQuestions;

}
