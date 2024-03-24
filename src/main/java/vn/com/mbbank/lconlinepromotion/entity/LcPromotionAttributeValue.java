package vn.com.mbbank.lconlinepromotion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LC_ONLINE_PROMOTION_ATTRIBUTE_VALUE")
public class LcPromotionAttributeValue implements Serializable {

    @EmbeddedId
    private PromotionAttributeValueId id = new PromotionAttributeValueId();

    @ManyToOne
    @MapsId("attributeId")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private LcPromotionAttribute lcPromotionAttribute;

    @ManyToOne
    @MapsId("promotionId")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private LcPromotion lcPromotion;

    private String value;

    private String unit;

    private String description;

    // ngày tạo ctkm
    private Date createdDate;

    // ngày kết thúc ctkm
    private Date updatedDate;

    // người tạo ctkm
    private String createdBy;

    // người cập nhật ctkm
    private String updatedBy;

    public static class PromotionAttributeValueId implements Serializable {
        private String promotionId;
        private String attributeId;

        public PromotionAttributeValueId() {
        }

        public PromotionAttributeValueId(String promotionId, String attributeId) {
            this.promotionId = promotionId;
            this.attributeId = attributeId;
        }

        public String getPromotionId() {
            return promotionId;
        }

        public void setPromotionId(String promotionId) {
            this.promotionId = promotionId;
        }

        public String getAttributeId() {
            return attributeId;
        }

        public void setAttributeId(String attributeId) {
            this.attributeId = attributeId;
        }
    }

    public PromotionAttributeValueId getId() {
        return id;
    }

    public void setId(PromotionAttributeValueId id) {
        this.id = id;
    }

    public LcPromotionAttribute getLcPromotionAttribute() {
        return lcPromotionAttribute;
    }

    public void setLcPromotionAttribute(LcPromotionAttribute lcPromotionAttribute) {
        this.lcPromotionAttribute = lcPromotionAttribute;
    }

    public LcPromotion getLcPromotion() {
        return lcPromotion;
    }

    public void setLcPromotion(LcPromotion lcPromotion) {
        this.lcPromotion = lcPromotion;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
