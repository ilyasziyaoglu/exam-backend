package exam.backend.user.db.repository;

import exam.backend.common.db.repository.BaseRepository;
import exam.backend.user.db.entity.user.Role;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends BaseRepository<Role> {

}
