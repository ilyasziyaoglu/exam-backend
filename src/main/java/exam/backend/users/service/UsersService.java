package exam.backend.users.service;

import exam.backend.common.service.BaseEntityService;
import exam.backend.users.db.entity.Users;
import exam.backend.users.db.repository.UsersRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersService extends BaseEntityService<Users, UsersRepository> {

    @Resource
    private UsersRepository usersRepository;

    @Override
    public UsersRepository getRepository() {
        return usersRepository;
    }

}
