package exam.backend.old.user.db.mapper;

import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.old.user.db.entity.user.Role;
import exam.client.dto.request.RoleRequest;
import exam.client.dto.response.RoleResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<Role, RoleRequest, RoleResponse> {
}
