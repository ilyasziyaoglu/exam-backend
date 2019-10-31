package exam.backend.catalog.db.entity.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import exam.backend.common.db.converter.StatusEnumConverter;
import exam.backend.common.db.entity.AbstractEntity;
import exam.client.common.enumeration.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static exam.backend.common.constant.GlobalConstants.DB_PREFIX;

@Entity
@Table(name = DB_PREFIX + "CATEGORIES")
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(exclude = {"children","parent"})
public class Category extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = DB_PREFIX + "CATEGORY_ID_GEN", sequenceName = DB_PREFIX + "CATEGORY_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = DB_PREFIX + "CATEGORY_ID_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Transient
	private Long parentId;

	@Column
	private String name;

	@Column
	private String description;

	@Column(name = "category_level")
	private Integer level;

	@Convert(converter = StatusEnumConverter.class)
	private Status status = Status.ACTIVE;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional=true)
	@JoinColumn(name="parent_id")
	private Category parent;

	@JsonManagedReference
	@OneToMany(mappedBy="parent", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	private Set<Category> children = new HashSet<Category>();


	public Category(){}

	public Category(String name) {
		setName(name);
	}

	public Set<Category> getChildren(){
		return level ==null ||  level > 3 ? null :  children;
	}

	public boolean equals(Object obj) {
		return getName().equals(((Category)obj).getName());
	}

}
