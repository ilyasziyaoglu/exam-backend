package exam.backend.users.db.repository;

import exam.backend.common.db.repository.BaseRepository;
import exam.backend.users.db.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends BaseRepository<Users> {

}
