package vn.com.mbbank.lconlinepromotion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.com.mbbank.lconlinepromotion.entity.LcPromotionAttribute;
import vn.com.mbbank.lconlinepromotion.entity.LcPromotionAttributeGroup;

import java.util.Optional;

@Repository
public interface LcPromotionAttributeGroupRepository extends JpaRepository<LcPromotionAttributeGroup, String> {
    Optional<LcPromotionAttributeGroup> findByName(String name);
}
