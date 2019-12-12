package exam.backend.category;

import com.fasterxml.jackson.annotation.JsonBackReference;
import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "EXAM_TYPE")
@Data
@EqualsAndHashCode(callSuper = false)
public class Category extends AbstractEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = GlobalConstants.DB_PREFIX + "EXAM_TYPE_GEN", sequenceName = GlobalConstants.DB_PREFIX + "EXAM_TYPE_SEQ", allocationSize = 1)
    @GeneratedValue(generator = GlobalConstants.DB_PREFIX + "EXAM_TYPE_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer level;

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "parent_id", foreignKey=@ForeignKey(name="CATEGORY_PARENT_OTO"))
    private Category parent;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "parent_id", foreignKey=@ForeignKey(name="CATEGORY_CHILDREN_OTO"))
    private List<Category> children;
}
