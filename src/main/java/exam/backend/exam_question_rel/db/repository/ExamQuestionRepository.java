package exam.backend.exam_question_rel.db.repository;

import exam.backend.common.db.repository.BaseRepository;
import exam.backend.exam_question_rel.db.entity.ExamQuestion;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamQuestionRepository extends BaseRepository<ExamQuestion> {

}
