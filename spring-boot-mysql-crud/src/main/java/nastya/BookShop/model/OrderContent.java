package nastya.BookShop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "order_content")
public class OrderContent implements Serializable {
    @EmbeddedId
    private OrderContentId orderContentId;
    private Integer quantity;
    @Column(name = "price_per_item")
    private Integer price;

    public OrderContent() {
    }

    public OrderContent(OrderContentId orderContentId, Integer quantity, Integer price) {
        this.orderContentId = orderContentId;
        this.quantity = quantity;
        this.price = price;
    }
}
