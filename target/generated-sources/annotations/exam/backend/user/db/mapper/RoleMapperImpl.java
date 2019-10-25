package exam.backend.user.db.mapper;

import exam.backend.user.db.entity.user.Role;
import exam.client.dto.request.RoleRequest;
import exam.client.dto.response.RoleResponse;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-25T20:49:54+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleResponse toResponse(Role entity) {
        if ( entity == null ) {
            return null;
        }

        RoleResponse roleResponse = new RoleResponse();

        roleResponse.setId( entity.getId() );

        return roleResponse;
    }

    @Override
    public Role toEntity(RoleRequest request) {
        if ( request == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( request.getId() );
        role.setStatus( request.getStatus() );
        role.setName( request.getName() );

        return role;
    }
}
