package exam.backend.user_answers_rel.service;

import exam.backend.common.service.BaseEntityService;
import exam.backend.user_answers_rel.db.entity.UserAnswers;
import exam.backend.user_answers_rel.db.repository.UserAnswersRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserAnswersService extends BaseEntityService<UserAnswers, UserAnswersRepository> {

    @Resource
    private UserAnswersRepository userAnswersRepository;

    @Override
    public UserAnswersRepository getRepository() {
        return userAnswersRepository;
    }

}
