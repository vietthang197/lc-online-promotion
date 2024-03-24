package vn.com.mbbank.lconlinepromotion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LC_ONLINE_PROMOTION_ATTRIBUTE")
public class LcPromotionAttribute implements Serializable {

    // attribute identify
    @Id
    private String id;

    @ManyToOne
    private LcPromotionAttributeGroup lcPromotionAttributeGroup;

    private String description;

    // ngày tạo ctkm
    private Date createdDate;

    // ngày kết thúc ctkm
    private Date updatedDate;

    // người tạo ctkm
    private String createdBy;

    // người cập nhật ctkm
    private String updatedBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LcPromotionAttributeGroup getLcPromotionAttributeGroup() {
        return lcPromotionAttributeGroup;
    }

    public void setLcPromotionAttributeGroup(LcPromotionAttributeGroup lcPromotionAttributeGroup) {
        this.lcPromotionAttributeGroup = lcPromotionAttributeGroup;
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
}
