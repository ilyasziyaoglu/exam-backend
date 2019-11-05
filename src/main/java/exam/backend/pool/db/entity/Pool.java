package exam.backend.pool.db.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.users.db.entity.Users;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "POOL")
@Data
@EqualsAndHashCode(callSuper = false)
public class Pool extends AbstractEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = GlobalConstants.DB_PREFIX + "POOL_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "POOL_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = GlobalConstants.DB_PREFIX + "POOL_ID_GEN", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "pool_name")
    private String poolName;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id", nullable = false)
    private Users owner;
}
