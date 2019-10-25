package exam.backend.user.db.mapper;

import exam.backend.user.db.entity.user.Permission;
import exam.client.dto.request.PermissionRequest;
import exam.client.dto.response.PermissionResponse;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-25T20:49:54+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class PermissionMapperImpl implements PermissionMapper {

    @Override
    public PermissionResponse toResponse(Permission entity) {
        if ( entity == null ) {
            return null;
        }

        PermissionResponse permissionResponse = new PermissionResponse();

        permissionResponse.setId( entity.getId() );

        return permissionResponse;
    }

    @Override
    public Permission toEntity(PermissionRequest request) {
        if ( request == null ) {
            return null;
        }

        Permission permission = new Permission();

        permission.setId( request.getId() );
        permission.setStatus( request.getStatus() );
        permission.setName( request.getName() );
        permission.setDescription( request.getDescription() );

        return permission;
    }
}
