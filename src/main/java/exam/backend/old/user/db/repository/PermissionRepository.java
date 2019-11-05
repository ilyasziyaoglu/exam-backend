package exam.backend.old.user.db.repository;

import exam.backend.common.db.repository.BaseRepository;
import exam.backend.old.user.db.entity.user.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends BaseRepository<Permission> {

}
