package exam.backend.user_answers_rel.db.mapper;


import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.user_answers_rel.db.entity.UserAnswers;
import exam.client.exam_question_rel.request.ExamQuestionRequest;
import exam.client.exam_question_rel.response.ExamQuestionResponse;
import exam.client.user_answers_rel.request.UserAnswersRequest;
import exam.client.user_answers_rel.response.UsersAnswersResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAnswersMapper extends BaseMapper<UserAnswers, UserAnswersRequest, UsersAnswersResponse> {

}
