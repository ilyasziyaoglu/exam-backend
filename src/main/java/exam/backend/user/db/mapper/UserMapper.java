package exam.backend.user.db.mapper;

import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.user.db.entity.user.User;
import exam.client.dto.request.UserRequest;
import exam.client.dto.response.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserRequest, UserResponse> {
}
