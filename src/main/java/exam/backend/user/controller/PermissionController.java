package exam.backend.user.controller;

import exam.backend.common.controller.BaseEntityController;
import exam.backend.user.db.entity.user.Permission;
import exam.backend.user.db.mapper.PermissionMapper;
import exam.backend.user.db.repository.PermissionRepository;
import exam.backend.user.service.PermissonService;
import exam.client.dto.request.PermissionRequest;
import exam.client.dto.response.PermissionResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/role/permission")
public class PermissionController
		extends BaseEntityController<PermissionRequest, PermissionResponse, Permission, PermissionRepository, PermissonService, PermissionMapper> {

	@Resource
	private PermissonService permissonService;

	@Resource
	private PermissionMapper permissionMapper;

	@Override
	protected PermissonService getService() {
		return permissonService;
	}

	@Override
	protected PermissionMapper getMapper() {
		return permissionMapper;
	}

}
