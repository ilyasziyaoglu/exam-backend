package exam.backend.exam_question_rel.controller;

import exam.backend.common.controller.BaseEntityController;
import exam.backend.exam_question_rel.db.entity.ExamQuestion;
import exam.backend.exam_question_rel.db.mapper.ExamQuestionMapper;
import exam.backend.exam_question_rel.db.repository.ExamQuestionRepository;
import exam.backend.exam_question_rel.service.ExamQuestionService;
import exam.client.exam_question_rel.request.ExamQuestionRequest;
import exam.client.exam_question_rel.response.ExamQuestionResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//import exam.backend.common.config.security.TokenUtils;

@RestController
@RequestMapping("/exam-question")
public class ExamQuestionController extends BaseEntityController<ExamQuestionRequest, ExamQuestionResponse, ExamQuestion, ExamQuestionRepository, ExamQuestionService, ExamQuestionMapper> {

    @Resource
    private ExamQuestionService examQuestionService;

    @Resource
    private ExamQuestionMapper examQuestionMapper;

    @Override
    protected ExamQuestionService getService() {
        return examQuestionService;
    }

    @Override
    protected ExamQuestionMapper getMapper() {
        return examQuestionMapper;
    }
}
