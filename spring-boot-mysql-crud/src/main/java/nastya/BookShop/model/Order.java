package nastya.BookShop.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

import static org.hibernate.annotations.FetchMode.SELECT;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer Id;

    @OneToMany(mappedBy = "orderContentId.order")
    @Fetch(value = SELECT)
    private Set<OrderContent> orderContent;

    @Column(name = "order_number")
    private Integer orderNumber;

    @ManyToOne
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;

    private Integer cost;
    @Column(name = "delivery_address")
    private String deliveryAddress;
    private String description;
    @Column(name = "order_submit_date")
    private Date OrderSubmitDate;

    @ManyToOne
    @JoinColumn(name = "status", nullable = false)
    private Classification classification;

    @Column(name = "order_complete_date")
    private Date orderCompleteDate;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private User user;

    public Order() {
    }
}
