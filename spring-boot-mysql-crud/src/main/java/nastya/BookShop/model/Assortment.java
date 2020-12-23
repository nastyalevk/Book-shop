package nastya.BookShop.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "assortment")
public class Assortment {
    @EmbeddedId
    private AssortmentId assortmentId;
    private String quantity;
    @Column(name = "price_per_item")
    private String Price;
    @Column(name = "creation_date")
    private Date creationDate;
//    private Integer status;

    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    private Classification classification;

    public Assortment(){}

    public Assortment(AssortmentId assortmentId, String quantity, String price, Date creationDate, Classification classification) {
        this.assortmentId = assortmentId;
        this.quantity = quantity;
        Price = price;
        this.creationDate = creationDate;
        this.classification = classification;
    }
}
