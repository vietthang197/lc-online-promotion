package vn.com.mbbank.lconlinepromotion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "LC_ONLINE_PROMOTION")
public class LcPromotion implements Serializable {

    // id của ctkm
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @ManyToOne
    private LcPromotionType promotionType;

    // mã code của chương trình khuyến mại
    @Column(name = "PROMOTION_CODE", unique = true)
    private String promotionCode;

    // Tên chương trình khuyến mại
    private String promotionName;

    // Độ ưu tiên của ctkm
    private Integer priority;

    // Ngày bắt đầu ctkm
    private Date startDate;

    // Ngày kết thúc ctkm
    private Date endDate;

    // trạng thái của ctkm
    private String status;

    // mô tả ctkm
    private String description;

    // ngày tạo ctkm
    private Date createdDate;

    // ngày kết thúc ctkm
    private Date updatedDate;

    // người tạo ctkm
    private String createdBy;

    // người cập nhật ctkm
    private String updatedBy;

    @OneToMany(mappedBy = "lcPromotion", fetch = FetchType.LAZY)
    private Set<LcGift> lcGifts = new HashSet<>();

    @OneToMany(mappedBy = "lcPromotion")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Set<LcCorpPromotionHistory> lcCorpPromotionHistories = new HashSet<>();

    @OneToMany(mappedBy = "lcPromotion")
    private Set<LcPromotionAttributeValue> lcPromotionAttributeValues = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LcPromotionType getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(LcPromotionType promotionType) {
        this.promotionType = promotionType;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Set<LcGift> getLcGifts() {
        return lcGifts;
    }

    public void setLcGifts(Set<LcGift> lcGifts) {
        this.lcGifts = lcGifts;
    }

    public Set<LcCorpPromotionHistory> getLcCorpPromotionHistories() {
        return lcCorpPromotionHistories;
    }

    public void setLcCorpPromotionHistories(Set<LcCorpPromotionHistory> lcCorpPromotionHistories) {
        this.lcCorpPromotionHistories = lcCorpPromotionHistories;
    }

    public Set<LcPromotionAttributeValue> getLcPromotionAttributeValues() {
        return lcPromotionAttributeValues;
    }

    public void setLcPromotionAttributeValues(Set<LcPromotionAttributeValue> lcPromotionAttributeValues) {
        this.lcPromotionAttributeValues = lcPromotionAttributeValues;
    }
}
