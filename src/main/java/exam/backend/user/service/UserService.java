package exam.backend.user.service;

import exam.backend.common.service.BaseEntityService;
import exam.backend.user.db.entity.user.User;
import exam.backend.user.db.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseEntityService<User, UserRepository> {

    private UserRepository userRepository;

    @Override
    public UserRepository getRepository() {
        return userRepository;
    }
}