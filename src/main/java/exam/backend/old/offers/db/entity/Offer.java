package exam.backend.old.offers.db.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import exam.backend.old.catalog.db.entity.company.Company;
import exam.backend.old.catalog.db.entity.product.Product;
import exam.backend.old.offers.db.converter.OfferStatusEnumConverter;
import exam.client.offer.enumeration.OfferStatus;
import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.old.user.db.entity.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = GlobalConstants.DB_PREFIX + "OFFERS")
@Data
@EqualsAndHashCode(callSuper = false)
public class Offer extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = GlobalConstants.DB_PREFIX + "OFFER_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "OFFER_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = GlobalConstants.DB_PREFIX + "OFFER_ID_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column
	private Long grupId;

	@Column
	private BigDecimal amount;

	@Column
	private Double unitPrice;

	@Column
	private OfferStatus currentStatus;

	@Transient
	private Long productId;

	@Transient
	private Long userId;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "offer_id")
	private Set<OfferHistory> offerHistory =  new HashSet<>();

	@Convert(converter = OfferStatusEnumConverter.class)
	private OfferStatus offerStatus;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "from_company_id", nullable = false)
	private Company fromCompany;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "to_company_id", nullable = false)
	private Company toCompany;
}
