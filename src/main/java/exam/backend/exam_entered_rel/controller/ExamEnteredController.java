package exam.backend.user_exam_rel.controller;

import exam.backend.common.controller.BaseEntityController;
import exam.backend.user_exam_rel.db.entity.UserExam;
import exam.backend.user_exam_rel.db.mapper.UserExamMapper;
import exam.backend.user_exam_rel.db.repository.UserExamRepository;
import exam.backend.user_exam_rel.service.UserExamService;
import exam.client.exam_question_rel.request.ExamQuestionRequest;
import exam.client.exam_question_rel.response.ExamQuestionResponse;
import exam.client.user_exam_rel.request.UserExamRequest;
import exam.client.user_exam_rel.response.UserExamResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//import exam.backend.common.config.security.TokenUtils;

@RestController
@RequestMapping("/user-exam")
public class UserExamController extends BaseEntityController<UserExamRequest, UserExamResponse, UserExam, UserExamRepository, UserExamService, UserExamMapper> {

    @Resource
    private UserExamService userExamService;

    @Resource
    private UserExamMapper userExamMapper;

    @Override
    protected UserExamService getService() {
        return userExamService;
    }

    @Override
    protected UserExamMapper getMapper() {
        return userExamMapper;
    }
}
