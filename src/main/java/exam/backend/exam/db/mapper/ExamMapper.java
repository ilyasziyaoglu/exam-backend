package exam.backend.exam.db.mapper;


import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.exam.db.entity.Exam;
import exam.client.exam.dto.request.ExamRequest;
import exam.client.exam.dto.response.ExamResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamMapper extends BaseMapper<Exam, ExamRequest, ExamResponse> {

}
