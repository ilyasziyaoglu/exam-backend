package exam.backend.old.user.service;

import exam.backend.common.service.BaseEntityService;
import exam.backend.old.user.db.entity.user.Permission;
import exam.backend.old.user.db.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PermissonService extends BaseEntityService<Permission, PermissionRepository> {

	@Resource
	private PermissionRepository permissionRepository;

	@Override
	public PermissionRepository getRepository() {
		return permissionRepository;
	}

}
