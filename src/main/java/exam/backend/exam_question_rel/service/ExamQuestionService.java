package exam.backend.exam_question_rel.service;

import exam.backend.common.service.BaseEntityService;
import exam.backend.exam_question_rel.db.entity.ExamQuestion;
import exam.backend.exam_question_rel.db.repository.ExamQuestionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ExamQuestionService extends BaseEntityService<ExamQuestion, ExamQuestionRepository> {

    @Resource
    private ExamQuestionRepository examQuestionRepository;

    @Override
    public ExamQuestionRepository getRepository() {
        return examQuestionRepository;
    }

}
