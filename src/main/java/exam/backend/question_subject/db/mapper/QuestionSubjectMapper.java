package exam.backend.question_subject.db.mapper;


import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.question_subject.db.entity.Subject;
import exam.client.question_subject.request.QuestionSubjectRequest;
import exam.client.question_subject.response.QuestionSubjectResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionSubjectMapper extends BaseMapper<Subject, QuestionSubjectRequest, QuestionSubjectResponse> {

}
