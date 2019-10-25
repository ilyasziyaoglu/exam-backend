package exam.backend.common.service;

import exam.client.common.dto.pager.DtColumnDto;
import exam.client.common.dto.pager.DtOrderDto;
import exam.client.common.dto.pager.PageDto;
import exam.backend.common.db.entity.AbstractEntity;
import exam.backend.common.db.repository.BaseRepository;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class BaseEntityService<Entity extends AbstractEntity, Repository extends BaseRepository<Entity>> extends BaseService {

	public abstract Repository getRepository();

	public ServiceResult<List<Entity>> getAll() {
		return new ServiceResult<>(getRepository().findAll());
	}


	public ServiceResult<Page<Entity>> getAll(Pageable pageable) {
		return new ServiceResult<>(getRepository().findAll(pageable));
	}

	public ServiceResult<Entity> get(Long id) {
		Optional<Entity> optional = getRepository().findById(id);
		return optional.map(ServiceResult::new).orElseGet(() -> new ServiceResult<>(HttpStatus.NOT_FOUND, (id + " record not found.")));
	}

	public ServiceResult<Entity> save(Entity entity) {
		preSaveInternal(entity);
		Entity save = getRepository().save(entity);
		postSaveInternal(save);
		return new ServiceResult<>(HttpStatus.OK, save);
	}

	public void delete(Long id) {
		getRepository().deleteById(id);
	}


	private void preSaveInternal(Entity entity) {
		try {
			preSave(entity);
		} catch (Exception e) {
//			logger.error("preSaveInternal got exception.", e);
		}
	}

	protected void preSave(Entity entity) {
	}

	private void postSaveInternal(Entity entity) {
		try {
			postSave(entity);
		} catch (Exception e) {
//			logger.error("postSaveInternal got exception.", e);
		}
	}

	protected void postSave(Entity entity) {
	}


	protected <T> ServiceResult<Page<Entity>> filter(Specification<Entity> specifications, PageDto<T> page) {
		ServiceResult serviceResult = new ServiceResult();

		try {
			PageRequest pageRequest = PageRequest.of(page.getPage(), page.getSize(), Sort.Direction.DESC, new String[]{"id"});
			if (CollectionUtils.isNotEmpty(page.getOrder()) && CollectionUtils.isNotEmpty(page.getColumns())) {
				Optional<DtOrderDto> dtOrderOptional = page.getOrder().stream().findFirst();
				if (dtOrderOptional.isPresent()) {
					DtOrderDto dtOrderDto = (DtOrderDto)dtOrderOptional.get();
					DtColumnDto sortedColumn = (DtColumnDto)page.getColumns().stream().filter((c) -> {
						return c.getName().equals(dtOrderDto.getColumn().toString());
					}).findFirst().orElse(null);
					if (sortedColumn != null && sortedColumn.getOrderable()) {
						Sort.Order order = (new Sort.Order(Sort.Direction.fromString(dtOrderDto.getDir()), sortedColumn.getData())).ignoreCase();
						pageRequest = PageRequest.of(page.getPage(), page.getSize(), Sort.by(new Sort.Order[]{order}));
					}
				}
			}

			Page<Entity> pageEntity = this.getRepository().findAll(specifications, pageRequest);
			serviceResult.setValue(pageEntity);
		} catch (Exception var9) {
			serviceResult.setHttpStatus(HttpStatus.BAD_REQUEST);
			serviceResult.setMessage(var9.getMessage());
//			this.log.error("filter got exception. Message = " + var9.getMessage(), new Object[]{var9});
		}

		return serviceResult;
	}
}
