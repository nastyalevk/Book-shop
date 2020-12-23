package nastya.BookShop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "classif")
public class Classification {
    @Id
    @Column(name = "classif_id")
    private Integer id;

    @OneToMany(mappedBy = "classification")
    private Set<Classification> classificationSet;

    @OneToMany(mappedBy = "classification")
    private Set<Shop> shopSet;

    @OneToMany(mappedBy = "classification")
    private Set<Assortment> assortmentSet;

    @OneToMany(mappedBy = "classification")
    private Set<Order> orderSet;

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    private Classification classification;

    private String name;

    public Classification() {
    }
}
