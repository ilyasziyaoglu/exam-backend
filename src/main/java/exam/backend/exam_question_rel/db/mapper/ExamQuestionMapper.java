package exam.backend.exam_question_rel.db.mapper;


import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.exam_question_rel.db.entity.ExamQuestion;
import exam.client.exam_question_rel.request.ExamQuestionRequest;
import exam.client.exam_question_rel.response.ExamQuestionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamQuestionMapper extends BaseMapper<ExamQuestion, ExamQuestionRequest, ExamQuestionResponse> {

}
