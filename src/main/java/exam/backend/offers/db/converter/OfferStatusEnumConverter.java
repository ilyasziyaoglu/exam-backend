package exam.backend.offers.db.converter;

import exam.client.offer.enumeration.OfferStatus;
import exam.backend.common.db.converter.AbstractEnumConverter;

public class OfferStatusEnumConverter extends AbstractEnumConverter<OfferStatus> {

	@Override
	public Integer convertToDatabaseColumn(OfferStatus attribute) {
		return this.toDatabaseColumn(attribute);
	}

	@Override
	public OfferStatus convertToEntityAttribute(Integer dbData) {
		return this.toEntityAttribute(OfferStatus.class, dbData);
	}
}
