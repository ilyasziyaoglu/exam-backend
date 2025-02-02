package exam.backend.user.controller;

import exam.backend.common.controller.BaseEntityController;
import exam.backend.user.db.entity.user.User;
import exam.backend.user.db.mapper.UserMapper;
import exam.backend.user.db.repository.UserRepository;
import exam.backend.user.service.UserService;
import exam.client.dto.request.UserRequest;
import exam.client.dto.response.UserResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController extends BaseEntityController<UserRequest, UserResponse, User, UserRepository, UserService, UserMapper> {

	@Resource
	private UserService userService;

	@Resource
	private UserMapper userMapper;

	@Override
	protected UserService getService() {
		return userService;
	}

	@Override
	protected UserMapper getMapper() {
		return userMapper;
	}

}
