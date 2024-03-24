package vn.com.mbbank.lconlinepromotion.process;

import org.apache.commons.chain.impl.ContextBase;
import vn.com.mbbank.lconlinepromotion.entity.LcPromotion;
import vn.com.mbbank.lconlinepromotion.request.BaseRequest;

public class PromotionContext extends ContextBase {
    protected BaseRequest request;
    protected LcPromotion promotionConfig;

    public BaseRequest getRequest() {
        return request;
    }

    public void setRequest(BaseRequest request) {
        this.request = request;
    }

    public LcPromotion getPromotionConfig() {
        return promotionConfig;
    }

    public void setPromotionConfig(LcPromotion promotionConfig) {
        this.promotionConfig = promotionConfig;
    }
}
