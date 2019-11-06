package exam.backend.question_subject.controller;

import exam.backend.common.controller.BaseEntityController;
import exam.backend.question_subject.db.entity.QuestionSubject;
import exam.backend.question_subject.db.mapper.QuestionSubjectMapper;
import exam.backend.question_subject.db.repository.QuestionSubjectRepository;
import exam.backend.question_subject.service.QuestionSubjectService;
import exam.client.question_subject.request.QuestionSubjectRequest;
import exam.client.question_subject.response.QuestionSubjectResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//import exam.backend.common.config.security.TokenUtils;

@RestController
@RequestMapping("/question_subject")
public class QuestionSubjectController extends BaseEntityController<QuestionSubjectRequest, QuestionSubjectResponse, QuestionSubject, QuestionSubjectRepository, QuestionSubjectService, QuestionSubjectMapper> {

    @Resource
    private QuestionSubjectService questionSubjectService;

    @Resource
    private QuestionSubjectMapper questionSubjectMapper;

    @Override
    protected QuestionSubjectService getService() {
        return questionSubjectService;
    }

    @Override
    protected QuestionSubjectMapper getMapper() {
        return questionSubjectMapper;
    }
}
