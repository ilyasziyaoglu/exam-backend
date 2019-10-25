package exam.backend.user.db.mapper;

import exam.backend.common.db.mapper.BaseMapper;
import exam.backend.user.db.entity.user.Permission;
import exam.client.dto.request.PermissionRequest;
import exam.client.dto.response.PermissionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper extends BaseMapper<Permission, PermissionRequest, PermissionResponse> {
}
