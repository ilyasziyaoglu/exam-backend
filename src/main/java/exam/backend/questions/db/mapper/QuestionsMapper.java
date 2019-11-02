package exam.backend.questions.db.mapper;


import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.questions.db.entity.Questions;
import exam.client.questions.request.QuestionsRequest;
import exam.client.questions.response.QuestionsResponse;
import exam.client.users.request.UsersRequest;
import exam.client.users.response.UsersResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionsMapper extends BaseMapper<Questions, QuestionsRequest, QuestionsResponse> {

}
