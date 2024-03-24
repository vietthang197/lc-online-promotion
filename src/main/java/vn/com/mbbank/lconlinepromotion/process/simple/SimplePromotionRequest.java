package vn.com.mbbank.lconlinepromotion.process.simple;

import vn.com.mbbank.lconlinepromotion.request.BaseRequest;

import java.math.BigDecimal;

public class SimplePromotionRequest extends BaseRequest {
    private BigDecimal lcAmount;
    private String lcCurrency;
    private String corpId;

    public BigDecimal getLcAmount() {
        return lcAmount;
    }

    public void setLcAmount(BigDecimal lcAmount) {
        this.lcAmount = lcAmount;
    }

    public String getLcCurrency() {
        return lcCurrency;
    }

    public void setLcCurrency(String lcCurrency) {
        this.lcCurrency = lcCurrency;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }
}
