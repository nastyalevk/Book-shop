package nastya.BookShop.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import nastya.BookShop.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "orders")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonSerialize
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer id;

    @OneToMany(mappedBy = "orderContentId.order")
    @JsonIgnore
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
