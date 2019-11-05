package exam.backend.old.user.service;

import exam.backend.common.service.BaseEntityService;
import exam.backend.old.user.db.entity.user.Role;
import exam.backend.old.user.db.repository.RoleRepository;
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
