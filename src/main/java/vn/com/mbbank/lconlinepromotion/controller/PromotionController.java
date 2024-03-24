package vn.com.mbbank.lconlinepromotion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.mbbank.lconlinepromotion.constant.LcAttributeGroupEnum;
import vn.com.mbbank.lconlinepromotion.constant.LcConstant;
import vn.com.mbbank.lconlinepromotion.constant.LcPromotionCommonAttributeId;
import vn.com.mbbank.lconlinepromotion.constant.LcPromotionTypeConfig;
import vn.com.mbbank.lconlinepromotion.entity.*;
import vn.com.mbbank.lconlinepromotion.process.PromotionContext;
import vn.com.mbbank.lconlinepromotion.process.simple.SimplePromotionProcess;
import vn.com.mbbank.lconlinepromotion.process.simple.SimplePromotionRequest;
import vn.com.mbbank.lconlinepromotion.repository.*;
import vn.com.mbbank.lconlinepromotion.services.PromotionServices;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/promotion")
public class PromotionController {

    @Autowired
    private  LcPromotionRepository lcPromotionRepository;
    @Autowired
    private  LcPromotionAttributeGroupRepository lcPromotionAttributeGroupRepository;
    @Autowired
    private  LcPromotionAttributeRepository lcPromotionAttributeRepository;
    @Autowired
    private  LcPromotionAttributeValueRepository lcPromotionAttributeValueRepository;
    @Autowired
    private  LcGiftRepository lcGiftRepository;
    @Autowired
    private PromotionServices promotionServices;

    @GetMapping
    @Transactional
    public List<LcPromotion> test() {
        List<LcPromotion> lcPromotionList = lcPromotionRepository.findByStartDateLessThanAndEndDateGreaterThanAndStatus(new Date(), new Date(), LcConstant.PROMOTION_STATUS.ACTIVE.name());
        return lcPromotionList;
    }

    @GetMapping("/insert-attribute")
    @Transactional
    public List<LcPromotionAttribute> insertPromotionAttribute() {
        Optional<LcPromotionAttributeGroup> lcPromotionAttributeGroupOptional = lcPromotionAttributeGroupRepository.findByName(LcAttributeGroupEnum.COMMON_ATTRIBUTE_GROUP.name());
        if (lcPromotionAttributeGroupOptional.isPresent()) {
            LcPromotionAttributeGroup lcPromotionAttributeGroup = lcPromotionAttributeGroupOptional.get();

            Optional<LcPromotionAttribute> allowMultipleAttr = lcPromotionAttributeRepository.findById(LcPromotionCommonAttributeId.ALLOW_MULTIPLE.ID);
            if (allowMultipleAttr.isEmpty()) {
                LcPromotionAttribute allowMulitple = new LcPromotionAttribute();
                allowMulitple.setLcPromotionAttributeGroup(lcPromotionAttributeGroup);
                allowMulitple.setId(LcPromotionCommonAttributeId.ALLOW_MULTIPLE.ID);
                allowMulitple.setCreatedBy("ADMIN");
                allowMulitple.setCreatedDate(new Date());
                lcPromotionAttributeRepository.save(allowMulitple);

            }

            Optional<LcPromotionAttribute> usesAttr = lcPromotionAttributeRepository.findById(LcPromotionCommonAttributeId.USES.ID);
            if (usesAttr.isEmpty()) {
                LcPromotionAttribute uses = new LcPromotionAttribute();
                uses.setLcPromotionAttributeGroup(lcPromotionAttributeGroup);
                uses.setId(LcPromotionCommonAttributeId.USES.ID);
                uses.setCreatedBy("ADMIN");
                uses.setCreatedDate(new Date());
                lcPromotionAttributeRepository.save(uses);
            }
        }
        return lcPromotionAttributeRepository.findAll();
    }

    @GetMapping("/insert-promotion-attribute")
    @Transactional
    public List<LcPromotion> insertPromotion1() {
        Optional<LcPromotion> lcPromotionOptional = lcPromotionRepository.findByPromotionCode("CTKM1");
        if (lcPromotionOptional.isPresent()) {
            LcPromotion lcPromotion1 = lcPromotionOptional.get();
            Optional<LcPromotionAttribute> attributeAllowMultipleOptional = lcPromotionAttributeRepository.findById(LcPromotionCommonAttributeId.ALLOW_MULTIPLE.ID);
            if (attributeAllowMultipleOptional.isPresent()) {
                LcPromotionAttribute allowMultipleAttr = attributeAllowMultipleOptional.get();

                LcPromotionAttributeValue allowMultipleAttrValue = new LcPromotionAttributeValue();
                allowMultipleAttrValue.setLcPromotion(lcPromotion1);
                allowMultipleAttrValue.setLcPromotionAttribute(allowMultipleAttr);
                allowMultipleAttrValue.setValue(LcPromotionCommonAttributeId.ALLOW_MULTIPLE.VALUES.N.name());
                allowMultipleAttrValue.setCreatedBy("ADMIN");
                allowMultipleAttrValue.setCreatedDate(new Date());
                
                lcPromotionAttributeValueRepository.save(allowMultipleAttrValue);
            }

            Optional<LcPromotionAttribute> attributeUsesOptional = lcPromotionAttributeRepository.findById(LcPromotionCommonAttributeId.USES.ID);
            if (attributeUsesOptional.isPresent()) {
                LcPromotionAttribute usesAttr = attributeUsesOptional.get();

                LcPromotionAttributeValue usesAttrValue = new LcPromotionAttributeValue();
                usesAttrValue.setLcPromotion(lcPromotion1);
                usesAttrValue.setLcPromotionAttribute(usesAttr);
                usesAttrValue.setValue("1");
                usesAttrValue.setCreatedBy("ADMIN");
                usesAttrValue.setCreatedDate(new Date());

                lcPromotionAttributeValueRepository.save(usesAttrValue);
            }
        }
        return lcPromotionRepository.findAll();
    }

    @GetMapping("/insert-promotion-gift")
    @Transactional
    public List<LcPromotion> insertPromotionGift() {
        Optional<LcPromotion> lcPromotionOptional = lcPromotionRepository.findByPromotionCode("CTKM1");
        if (lcPromotionOptional.isPresent()) {
            Optional<LcGift> gift01Optional = lcGiftRepository.findByGiftCode("GIFT_CODE_01");
            if (gift01Optional.isEmpty()) {
                LcGift lcGift = new LcGift();
                lcGift.setGiftCode("GIFT_CODE_01");
                lcGift.setLcPromotion(lcPromotionOptional.get());
                lcGift.setName("Qua tang so 1");
                lcGift.setCreatedDate(new Date());
                lcGift.setCreatedBy("ADMIN");

                lcGiftRepository.save(lcGift);
            }
        }
        return lcPromotionRepository.findAll();
    }

    @GetMapping("/test-process-promotion")
    @Transactional
    public void testProcessPromotion() throws Exception {
        List<LcPromotion> lcPromotionList = lcPromotionRepository.findByStartDateLessThanAndEndDateGreaterThanAndStatus(new Date(), new Date(), LcConstant.PROMOTION_STATUS.ACTIVE.name());
        for (LcPromotion lcPromotion : lcPromotionList) {
            PromotionContext promotionContext = getPromotionContext(lcPromotion);
            SimplePromotionProcess process = new SimplePromotionProcess();
            process.execute(promotionContext);
        }


    }

    private static PromotionContext getPromotionContext(LcPromotion lcPromotion) {
        PromotionContext promotionContext = new PromotionContext();
        promotionContext.setPromotionConfig(lcPromotion);

        for (LcPromotionAttributeValue attributeValue : lcPromotion.getLcPromotionAttributeValues()) {
            String attrId = attributeValue.getLcPromotionAttribute().getId();
            String attrValue = attributeValue.getValue();
        }

        SimplePromotionRequest simplePromotionRequest = new SimplePromotionRequest();
        simplePromotionRequest.setLcAmount(new BigDecimal("57000"));
        simplePromotionRequest.setLcCurrency("USD");
        simplePromotionRequest.setCorpId("Lc571922");
        promotionContext.setRequest(simplePromotionRequest);
        return promotionContext;
    }
}
