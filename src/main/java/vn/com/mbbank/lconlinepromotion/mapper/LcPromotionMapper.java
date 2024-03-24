package vn.com.mbbank.lconlinepromotion.mapper;

import org.mapstruct.Mapper;
import vn.com.mbbank.lconlinepromotion.dto.LcPromotionDto;
import vn.com.mbbank.lconlinepromotion.entity.LcPromotion;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LcPromotionMapper {
    LcPromotionDto toDto(LcPromotion lcPromotion);
    List<LcPromotionDto> toListDto(List<LcPromotion> lcPromotionList);
}
