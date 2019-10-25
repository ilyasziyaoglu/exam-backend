package exam.backend.user.service;

import exam.backend.common.service.BaseEntityService;
import exam.backend.user.db.entity.user.Role;
import exam.backend.user.db.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleService extends BaseEntityService<Role, RoleRepository> {

	@Resource
	private RoleRepository roleRepository;

	@Override
	public RoleRepository getRepository() {
		return roleRepository;
	}

}
