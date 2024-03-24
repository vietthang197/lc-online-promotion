package vn.com.mbbank.lconlinepromotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.mbbank.lconlinepromotion.entity.LcPromotionAttributeValue;

@Repository
public interface LcPromotionAttributeValueRepository extends JpaRepository<LcPromotionAttributeValue, String> {
}
