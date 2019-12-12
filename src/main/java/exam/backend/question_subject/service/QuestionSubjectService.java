package exam.backend.question_subject.service;

import exam.backend.common.service.BaseEntityService;
import exam.backend.question_subject.db.entity.Subject;
import exam.backend.question_subject.db.repository.QuestionSubjectRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class QuestionSubjectService extends BaseEntityService<Subject, QuestionSubjectRepository> {

    @Resource
    private QuestionSubjectRepository questionSubjectRepository;

    @Override
    public QuestionSubjectRepository getRepository() {
        return questionSubjectRepository;
    }

}
