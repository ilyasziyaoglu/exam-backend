package exam.backend.user_answers_rel.controller;

import exam.backend.common.controller.BaseEntityController;
import exam.backend.user_answers_rel.db.entity.UserAnswers;
import exam.backend.user_answers_rel.db.mapper.UserAnswersMapper;
import exam.backend.user_answers_rel.db.repository.UserAnswersRepository;
import exam.backend.user_answers_rel.service.UserAnswersService;
import exam.client.user_answers_rel.request.UserAnswersRequest;
import exam.client.user_answers_rel.response.UsersAnswersResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//import exam.backend.common.config.security.TokenUtils;

@RestController
@RequestMapping("/user-answers")
public class UserAnswersController extends BaseEntityController<UserAnswersRequest, UsersAnswersResponse, UserAnswers, UserAnswersRepository, UserAnswersService, UserAnswersMapper> {

    @Resource
    private UserAnswersService userAnswersService;

    @Resource
    private UserAnswersMapper userAnswersMapper;

    @Override
    protected UserAnswersService getService() {
        return userAnswersService;
    }

    @Override
    protected UserAnswersMapper getMapper() {
        return userAnswersMapper;
    }
}
