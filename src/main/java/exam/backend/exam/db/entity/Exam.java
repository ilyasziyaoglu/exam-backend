package exam.backend.exam.db.entity;

import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.category.Category;
import exam.backend.question_subject.db.entity.Subject;
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
	private String code;

	@Column
	private String name;

	@Column
	private String description;

	@Column(name="date_time")
	private ZonedDateTime dateTime;

	@Column
	private Integer duration;

	@Column
	private Double price;

	@Column(name = "question_count")
	private int questionCount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category", foreignKey=@ForeignKey(name="EXAM_EXAM_TYPE_MTO"))
	private Category category;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "exam_id", foreignKey=@ForeignKey(name="EXAM_EXAM_QUESTION_OTM"))
	private List<Subject> subjects;

}
