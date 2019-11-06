package exam.backend.options.db.entity;

import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "OPTIONS")
@Data
@EqualsAndHashCode(callSuper = false)
public class Options extends AbstractEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = GlobalConstants.DB_PREFIX + "OPTIONS_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "OPTIONS_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = GlobalConstants.DB_PREFIX + "OPTIONS_ID_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "body")
    private String body;

    @Column(name = "is_true")
    private boolean isTrue;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "option_order")
    private int order;
}
