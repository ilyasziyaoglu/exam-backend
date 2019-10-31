package exam.backend.sinav.db.mapper;


import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.sinav.db.entity.Sinav;
import exam.client.sinav.dto.request.SinavRequest;
import exam.client.sinav.dto.response.SinavResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SinavMapper extends BaseMapper<Sinav, SinavRequest, SinavResponse> {

}
