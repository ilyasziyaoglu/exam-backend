package exam.backend.old.user.controller;

import exam.backend.common.controller.BaseEntityController;
import exam.backend.old.user.db.entity.user.Role;
import exam.backend.old.user.db.mapper.RoleMapper;
import exam.backend.old.user.db.repository.RoleRepository;
import exam.backend.old.user.service.RoleService;
import exam.client.dto.request.RoleRequest;
import exam.client.dto.response.RoleResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/role")
public class RoleController extends BaseEntityController<RoleRequest, RoleResponse, Role, RoleRepository, RoleService, RoleMapper> {

	@Resource
	private RoleService roleService;

	@Resource
	private RoleMapper roleMapper;

	@Override
	protected RoleService getService() {
		return roleService;
	}

	@Override
	protected RoleMapper getMapper() {
		return roleMapper;
	}

}
