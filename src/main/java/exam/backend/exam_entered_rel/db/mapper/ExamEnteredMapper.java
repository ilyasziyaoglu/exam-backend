package exam.backend.exam_entered_rel.db.mapper;


import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.exam_entered_rel.db.entity.ExamEntered;
import exam.client.exam_entered_rel.request.ExamEnteredRequest;
import exam.client.exam_entered_rel.response.ExamEnteredResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamEnteredMapper extends BaseMapper<ExamEntered, ExamEnteredRequest, ExamEnteredResponse> {

}
