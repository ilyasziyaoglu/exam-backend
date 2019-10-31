package exam.backend.user.db.mapper;

import exam.backend.catalog.db.entity.company.Company;
import exam.backend.user.db.entity.user.Role;
import exam.backend.user.db.entity.user.User;
import exam.client.catalog.dto.request.company.CompanyRequest;
import exam.client.catalog.dto.response.company.CompanyResponse;
import exam.client.dto.request.RoleRequest;
import exam.client.dto.request.UserRequest;
import exam.client.dto.response.UserResponse;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-31T23:32:35+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse toResponse(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setId( entity.getId() );
        userResponse.setUsername( entity.getUsername() );
        userResponse.setEmail( entity.getEmail() );
        userResponse.setCompany( companyToCompanyResponse( entity.getCompany() ) );

        return userResponse;
    }

    @Override
    public User toEntity(UserRequest request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        user.setId( request.getId() );
        user.setStatus( request.getStatus() );
        user.setUsername( request.getUsername() );
        user.setEmail( request.getEmail() );
        user.setPassword( request.getPassword() );
        user.setRoles( roleRequestSetToRoleSet( request.getRoles() ) );
        user.setCompany( companyRequestToCompany( request.getCompany() ) );

        return user;
    }

    protected CompanyResponse companyToCompanyResponse(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyResponse companyResponse = new CompanyResponse();

        companyResponse.setId( company.getId() );
        companyResponse.setStatus( company.getStatus() );
        companyResponse.setName( company.getName() );

        return companyResponse;
    }

    protected Role roleRequestToRole(RoleRequest roleRequest) {
        if ( roleRequest == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleRequest.getId() );
        role.setStatus( roleRequest.getStatus() );
        role.setName( roleRequest.getName() );

        return role;
    }

    protected Set<Role> roleRequestSetToRoleSet(Set<RoleRequest> set) {
        if ( set == null ) {
            return null;
        }

        Set<Role> set1 = new HashSet<Role>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleRequest roleRequest : set ) {
            set1.add( roleRequestToRole( roleRequest ) );
        }

        return set1;
    }

    protected Company companyRequestToCompany(CompanyRequest companyRequest) {
        if ( companyRequest == null ) {
            return null;
        }

        Company company = new Company();

        company.setId( companyRequest.getId() );
        company.setStatus( companyRequest.getStatus() );
        company.setName( companyRequest.getName() );

        return company;
    }
}
