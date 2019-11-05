package exam.backend.old.user.service;

import exam.backend.common.service.BaseEntityService;
import exam.backend.old.user.db.entity.user.User;
import exam.backend.old.user.db.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseEntityService<User, UserRepository> {

    private UserRepository userRepository;

    @Override
    public UserRepository getRepository() {
        return userRepository;
    }
}