package exam.backend.catalog.db.entity.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import exam.backend.common.db.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import static exam.backend.common.constant.GlobalConstants.*;
import static exam.backend.common.constant.GlobalConstants.DB_PREFIX;

@Entity
@Table(name = DB_PREFIX + "PRODUCT_DOCS")
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductDocument extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = DB_PREFIX + "PRODUCT_DOC_ID_GEN", sequenceName = DB_PREFIX + "PRODUCT_DOC_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = DB_PREFIX + "PRODUCT_DOC_ID_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	private String url;

}
