package exam.backend.exam_created_rel.db.mapper;


import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.exam_created_rel.db.entity.ExamCreated;
import exam.client.exam_created_rel.request.ExamCreatedRequest;
import exam.client.exam_created_rel.response.ExamCreatedResponse;
import exam.client.exam_entered_rel.request.ExamEnteredRequest;
import exam.client.exam_entered_rel.response.ExamEnteredResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamCreatedMapper extends BaseMapper<ExamCreated, ExamCreatedRequest, ExamCreatedResponse> {

}
