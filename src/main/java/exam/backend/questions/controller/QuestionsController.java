package exam.backend.questions.controller;

import exam.backend.common.controller.BaseEntityController;
import exam.backend.questions.db.entity.Questions;
import exam.backend.questions.db.mapper.QuestionsMapper;
import exam.backend.questions.db.repository.QuestionsRepository;
import exam.backend.questions.service.QuestionsService;
import exam.client.questions.request.QuestionsRequest;
import exam.client.questions.response.QuestionsResponse;
import exam.client.users.request.UsersRequest;
import exam.client.users.response.UsersResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//import exam.backend.common.config.security.TokenUtils;

@RestController
@RequestMapping("/questions")
public class QuestionsController extends BaseEntityController<QuestionsRequest, QuestionsResponse, Questions, QuestionsRepository, QuestionsService, QuestionsMapper> {

    @Resource
    private QuestionsService questionsService;

    @Resource
    private QuestionsMapper questionsMapper;

    @Override
    protected QuestionsService getService() {
        return questionsService;
    }

    @Override
    protected QuestionsMapper getMapper() {
        return questionsMapper;
    }
}
