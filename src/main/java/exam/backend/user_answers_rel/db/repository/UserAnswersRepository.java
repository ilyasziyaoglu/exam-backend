package exam.backend.user_answers_rel.db.repository;

import exam.backend.common.db.repository.BaseRepository;
import exam.backend.user_answers_rel.db.entity.UserAnswers;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnswersRepository extends BaseRepository<UserAnswers> {

}
