package exam.backend.common.db.converter;

import exam.client.common.enumeration.AbstractEnum;

import javax.persistence.AttributeConverter;

public abstract class AbstractEnumConverter<E extends Enum<E> & AbstractEnum>
		implements AttributeConverter<E, Integer> {

	public Integer toDatabaseColumn(E attr) {
		return (attr == null) ? null : attr.getId();
	}

	public E toEntityAttribute(Class<E> cls, Integer dbCol) {
		if (dbCol == null) {
			return null;
		}
		try {
			return AbstractEnum.fromId(cls, dbCol);
		} catch (Exception e) {
			return null;
		}

	}
}
