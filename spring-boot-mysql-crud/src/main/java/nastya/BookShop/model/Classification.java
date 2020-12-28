package nastya.BookShop.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;


@Data
@Entity
@Table(name = "classif")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonSerialize
public class Classification {
    @Id
    @Column(name = "classif_id")
    private Integer id;

//    @OneToMany(mappedBy = "classification")
//    @JsonIgnore
//    private Set<Classification> classifications;

    @OneToMany(mappedBy = "classification")
    @JsonIgnore
    private Set<Shop> shop;

    @OneToMany(mappedBy = "classification")
    @JsonIgnore
    private Set<Assortment> assortment;

    @OneToMany(mappedBy = "classification")
    @JsonIgnore
    private Set<Order> order;

//    @ManyToOne
//    @JoinColumn(name = "parent_id", nullable = false)
//    private Classification classification;

    private String name;

    public Classification() {
    }
}
