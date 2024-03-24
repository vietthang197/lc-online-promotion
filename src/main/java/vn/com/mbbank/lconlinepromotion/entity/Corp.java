package vn.com.mbbank.lconlinepromotion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CORP")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Corp implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    private String name;

    private String hostCifId;

    private String taxId;

    @OneToMany(mappedBy = "corp")
    private Set<LcCorpPromotionHistory> lcCorpPromotionHistories = new HashSet<>();
}
