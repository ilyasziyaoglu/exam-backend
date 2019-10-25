package exam.backend.common.controller;

import exam.client.common.dto.request.AbstractRequest;
import exam.client.common.dto.response.AbstractResponse;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.common.db.repository.BaseRepository;
import exam.backend.common.service.BaseEntityService;

public abstract class AbstractBaseController<Request extends AbstractRequest, Response extends AbstractResponse, Entity extends AbstractEntity, Repository extends BaseRepository<Entity>, Service extends BaseEntityService<Entity, Repository>, Mapper extends BaseMapper<Entity, Request, Response>> {

	protected abstract Service getService();

	protected abstract Mapper getMapper();

}
