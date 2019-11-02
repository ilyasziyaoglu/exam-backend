package exam.backend.options.db.mapper;


import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.options.db.entity.Options;
import exam.client.options.request.OptionsRequest;
import exam.client.options.response.OptionsResponse;
import exam.client.questions.request.QuestionsRequest;
import exam.client.questions.response.QuestionsResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OptionsMapper extends BaseMapper<Options, OptionsRequest, OptionsResponse> {

}
