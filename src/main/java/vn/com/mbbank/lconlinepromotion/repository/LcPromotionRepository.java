package vn.com.mbbank.lconlinepromotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.mbbank.lconlinepromotion.entity.LcPromotion;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface LcPromotionRepository extends JpaRepository<LcPromotion, String> {
    List<LcPromotion> findByStartDateLessThanAndEndDateGreaterThanAndStatus(Date start, Date end, String status);
    Optional<LcPromotion> findByPromotionCode(String code);
}
