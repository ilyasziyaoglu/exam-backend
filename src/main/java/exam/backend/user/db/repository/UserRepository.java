package exam.backend.user.db.repository;

import exam.backend.common.db.repository.BaseRepository;
import exam.backend.user.db.entity.user.User;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author Musa Ay
 *
 */

@Repository
public interface UserRepository extends BaseRepository<User> {

	User findByUsername(String username);

}
