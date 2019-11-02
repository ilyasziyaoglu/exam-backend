package exam.backend.users.controller;

import exam.backend.common.controller.BaseEntityController;
import exam.backend.users.db.entity.Users;
import exam.backend.users.db.mapper.UsersMapper;
import exam.backend.users.db.repository.UsersRepository;
import exam.backend.users.service.UsersService;
import exam.client.users.request.UsersRequest;
import exam.client.users.response.UsersResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//import exam.backend.common.config.security.TokenUtils;

@RestController
@RequestMapping("/users")
public class UsersController extends BaseEntityController<UsersRequest, UsersResponse, Users, UsersRepository, UsersService, UsersMapper> {

    @Resource
    private UsersService usersService;

    @Resource
    private UsersMapper usersMapper;

    @Override
    protected UsersService getService() {
        return usersService;
    }

    @Override
    protected UsersMapper getMapper() {
        return usersMapper;
    }
}
