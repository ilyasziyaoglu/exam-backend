package exam.backend.offers.db.repository;

import exam.backend.offers.db.entity.OfferHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferHistoryRepository extends JpaRepository<OfferHistory, Long> {

}
