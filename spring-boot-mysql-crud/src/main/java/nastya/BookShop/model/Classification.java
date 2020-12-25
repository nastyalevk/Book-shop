package nastya.BookShop.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Set;

import static org.hibernate.annotations.FetchMode.SELECT;

@Data
@Entity
@Table(name = "classif")
public class Classification {
    @Id
    @Column(name = "classif_id")
    private Integer id;

    @OneToMany(mappedBy = "classification")
    @Fetch(value = SELECT)
    private Set<Classification> classificationSet;

    @OneToMany(mappedBy = "classification")
    @Fetch(value = SELECT)
    private Set<Shop> shopSet;

    @OneToMany(mappedBy = "classification")
    @Fetch(value = SELECT)
    private Set<Assortment> assortmentSet;

    @OneToMany(mappedBy = "classification")
    @Fetch(value = SELECT)
    private Set<Order> orderSet;

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    private Classification classification;

    private String name;

    public Classification() {
    }
}
