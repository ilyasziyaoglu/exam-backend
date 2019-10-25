package exam.backend.common.db.converter;

import exam.client.common.enumeration.Status;

public class StatusEnumConverter extends AbstractEnumConverter<Status> {

	@Override
	public Integer convertToDatabaseColumn(Status attribute) {
		return this.toDatabaseColumn(attribute);
	}

	@Override
	public Status convertToEntityAttribute(Integer dbData) {
		return this.toEntityAttribute(Status.class, dbData);
	}
}
