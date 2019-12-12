package exam.backend.questions.service;

import exam.backend.common.service.BaseEntityService;
import exam.backend.questions.db.entity.Question;
import exam.backend.questions.db.repository.QuestionsRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class QuestionsService extends BaseEntityService<Question, QuestionsRepository> {

    @Resource
    private QuestionsRepository questionsRepository;

    @Override
    public QuestionsRepository getRepository() {
        return questionsRepository;
    }

}
