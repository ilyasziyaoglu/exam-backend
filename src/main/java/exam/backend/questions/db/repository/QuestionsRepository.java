package exam.backend.questions.db.repository;

import exam.backend.common.db.repository.BaseRepository;
import exam.backend.questions.db.entity.Questions;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends BaseRepository<Questions> {

}
