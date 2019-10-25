package exam.backend.catalog.db.entity.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import exam.backend.catalog.db.entity.company.Company;
import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "DISTRIBUTORS")
@Data
@EqualsAndHashCode(callSuper = false, exclude = "product")
public class Distributor extends AbstractEntity {


    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = GlobalConstants.DB_PREFIX + "DISTRIBUTOR_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "DISTRIBUTOR_ID_SEQ", allocationSize = 1)
    @GeneratedValue(generator = GlobalConstants.DB_PREFIX + "DISTRIBUTOR_ID_GEN", strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    private Integer stock;

    private double unitPrice;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
