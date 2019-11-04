package exam.backend.user_exam_rel.db.mapper;


import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.user_exam_rel.db.entity.UserExam;
import exam.client.exam_question_rel.request.ExamQuestionRequest;
import exam.client.exam_question_rel.response.ExamQuestionResponse;
import exam.client.user_exam_rel.request.UserExamRequest;
import exam.client.user_exam_rel.response.UserExamResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserExamMapper extends BaseMapper<UserExam, UserExamRequest, UserExamResponse> {

}
