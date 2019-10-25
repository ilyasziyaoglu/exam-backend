package exam.backend.catalog.db.converter;

import exam.client.catalog.enumeration.ProductStatus;
import exam.backend.common.db.converter.AbstractEnumConverter;

public class ProductStatusEnumConverter extends AbstractEnumConverter<ProductStatus> {

	@Override
	public Integer convertToDatabaseColumn(ProductStatus attribute) {
		return this.toDatabaseColumn(attribute);
	}

	@Override
	public ProductStatus convertToEntityAttribute(Integer dbData) {
		return this.toEntityAttribute(ProductStatus.class, dbData);
	}
}
