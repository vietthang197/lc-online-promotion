package vn.com.mbbank.lconlinepromotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.mbbank.lconlinepromotion.entity.LcGift;

import java.util.Optional;

@Repository
public interface LcGiftRepository extends JpaRepository<LcGift, String> {
    Optional<LcGift> findByGiftCode(String giftCode);
}
