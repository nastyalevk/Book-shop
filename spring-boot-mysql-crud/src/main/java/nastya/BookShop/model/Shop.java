package nastya.BookShop.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;


@Entity
@Data
@Table(name = "shops")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonSerialize
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shop_id")
    private Integer Id;

    @OneToMany(mappedBy = "shop")
    @JsonIgnore
    private Set<Review> reviewSet;

    @OneToMany(mappedBy = "assortmentId.shop")
    @JsonIgnore
    private Set<Assortment> assortmentSet;

    @OneToMany(mappedBy = "shop")
    @JsonIgnore
    private Set<Order> orderSet;

    @Column(name = "shop_name")
    private String shopName;
    private String country;
    private String city;
    private String adress;
    private String description;

    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    private Classification classification;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User user;

    public Shop() {
    }
}
