package nastya.bookShop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shop_id")
    private Integer Id;

    @OneToMany(mappedBy = "shop")
    private Set<Review> reviewSet;

    @OneToMany(mappedBy = "assortmentId.shop")
    private Set<Assortment> assortmentSet;

    @OneToMany(mappedBy = "shop")
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

    public Shop(){}
}
