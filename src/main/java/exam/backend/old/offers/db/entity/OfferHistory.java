package exam.backend.old.offers.db.entity;

import exam.backend.old.offers.db.converter.OfferStatusEnumConverter;
import exam.client.offer.enumeration.OfferStatus;
import exam.backend.common.constant.GlobalConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = GlobalConstants.DB_PREFIX + "OFFERS_HISTORY")
@Data
@EqualsAndHashCode(callSuper = false)
public class OfferHistory  {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = GlobalConstants.DB_PREFIX + "OFFERS_HISTORY_ID_GEN", sequenceName = GlobalConstants.DB_PREFIX + "OFFERS_HISTORY_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = GlobalConstants.DB_PREFIX + "OFFERS_HISTORY_ID_GEN", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Convert(converter = OfferStatusEnumConverter.class)
	private OfferStatus status;

	@Column
	private String description;

	@Column(name = "change_date")
	private ZonedDateTime date;
}
