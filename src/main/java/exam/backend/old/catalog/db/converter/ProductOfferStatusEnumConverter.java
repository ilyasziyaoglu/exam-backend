package exam.backend.old.catalog.db.converter;

import exam.client.catalog.enumeration.ProductOfferStatus;
import exam.backend.common.db.converter.AbstractEnumConverter;

public class ProductOfferStatusEnumConverter extends AbstractEnumConverter<ProductOfferStatus> {

	@Override
	public Integer convertToDatabaseColumn(ProductOfferStatus attribute) {
		return this.toDatabaseColumn(attribute);
	}

	@Override
	public ProductOfferStatus convertToEntityAttribute(Integer dbData) {
		return this.toEntityAttribute(ProductOfferStatus.class, dbData);
	}
}
