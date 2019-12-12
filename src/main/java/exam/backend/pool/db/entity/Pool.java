package exam.backend.pool.db.entity;

import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.questions.db.entity.Question;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "POOL")
@Data
@EqualsAndHashCode(callSuper = false)
public class Pool extends AbstractEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = GlobalConstants.DB_PREFIX + "POOL_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "POOL_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = GlobalConstants.DB_PREFIX + "POOL_ID_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "pool_id", foreignKey=@ForeignKey(name="POOL_QUESTIONS_MTM"))
    private List<Question> questions;
}
