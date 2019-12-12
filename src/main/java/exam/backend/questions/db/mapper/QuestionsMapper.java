package exam.backend.questions.db.mapper;


import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.questions.db.entity.Question;
import exam.client.questions.request.QuestionsRequest;
import exam.client.questions.response.QuestionsResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionsMapper extends BaseMapper<Question, QuestionsRequest, QuestionsResponse> {

}
