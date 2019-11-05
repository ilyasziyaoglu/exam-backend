package exam.backend.pool.db.mapper;


import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.pool.db.entity.Pool;
import exam.client.pool.request.PoolRequest;
import exam.client.pool.response.PoolResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PoolMapper extends BaseMapper<Pool, PoolRequest, PoolResponse> {

}
