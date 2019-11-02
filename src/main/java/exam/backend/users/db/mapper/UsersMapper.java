package exam.backend.users.db.mapper;


import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.users.db.entity.Users;
import exam.client.users.request.UsersRequest;
import exam.client.users.response.UsersResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper extends BaseMapper<Users, UsersRequest, UsersResponse> {

}
