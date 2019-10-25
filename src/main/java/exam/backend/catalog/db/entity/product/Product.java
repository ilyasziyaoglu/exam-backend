package exam.backend.catalog.db.entity.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import exam.backend.catalog.db.entity.company.Company;
import exam.client.common.enumeration.Status;
import exam.backend.common.constant.GlobalConstants;
import exam.backend.common.db.converter.StatusEnumConverter;
import exam.backend.common.db.entity.AbstractEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Musa Ay
 *
 */

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "PRODUCTS")
@Data
@EqualsAndHashCode(callSuper = false, exclude = "distributors")
//		exclude = { "name", "description", "productNumber" ,"producer"})
@ToString(exclude = { "distributors"})
public class Product extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = GlobalConstants.DB_PREFIX + "PRODUCT_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "PRODUCT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = GlobalConstants.DB_PREFIX + "PRODUCT_ID_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private String productNumber;

	@Column
	private String producer;

	@Column
	private Boolean manualCreated;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_company_id", nullable = true)
	private Company owner;


	@Column
	private String productId;

	@Column
	private Long categoryId;

	@Column
	private String productType;

	@Column
	private String ProductTypeDesc;

	@Column
	private String note;

	@Convert(converter = StatusEnumConverter.class)
	private Status status;

	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Distributor> distributors= new HashSet<>();

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	private Set<ProductFeature> productFeatures= new HashSet<>();


	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "ed_related_products", joinColumns = @JoinColumn(name = "product_id"))
	@Column(name = "related_product_id")
	private Set<Long> relatedProducts = new HashSet<>();


	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "ed_similar_products", joinColumns = @JoinColumn(name = "product_id"))
	@Column(name = "similar_product_id")
	private Set<Long> similarProducts = new HashSet<>();


	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "ed_product_images", joinColumns = @JoinColumn(name = "product_id"))
	@Column(name = "product_image_id")
	private Set<String> images = new HashSet<>();



}
