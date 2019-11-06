package exam.backend.exam_type;

import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "EXAM_TYPE")
@Data
@EqualsAndHashCode(callSuper = false)
public class ExamType extends AbstractEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = GlobalConstants.DB_PREFIX + "EXAM_TYPE_GEN", sequenceName = GlobalConstants.DB_PREFIX + "EXAM_TYPE_SEQ", allocationSize = 1)
    @GeneratedValue(generator = GlobalConstants.DB_PREFIX + "EXAM_TYPE_GEN", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "name")
    private String name;
}
