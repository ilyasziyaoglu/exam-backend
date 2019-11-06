package exam.backend.question_subject.db.repository;

import exam.backend.common.db.repository.BaseRepository;
import exam.backend.question_subject.db.entity.QuestionSubject;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionSubjectRepository extends BaseRepository<QuestionSubject> {

}
