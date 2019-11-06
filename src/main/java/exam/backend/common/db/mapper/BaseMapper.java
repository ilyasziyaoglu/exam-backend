package exam.backend.common.db.mapper;

import exam.client.common.dto.request.AbstractRequest;
import exam.client.common.dto.response.AbstractResponse;
import exam.backend.common.db.entity.AbstractEntity;

public interface BaseMapper<Entity extends AbstractEntity, Request extends AbstractRequest, Response extends AbstractResponse> {

	Response toResponse(Entity entity);

	Entity toEntity(Request request);
}