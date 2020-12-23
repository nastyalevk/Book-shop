package nastya.bookShop.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "order_content")
public class OrderContent implements Serializable {
    @EmbeddedId
    private OrderContentId orderContentId;
    private Integer quantity;
    @Column(name = "price_per_item")
    private Integer price;

    public OrderContent(){}

    public OrderContent(OrderContentId orderContentId, Integer quantity, Integer price) {
        this.orderContentId = orderContentId;
        this.quantity = quantity;
        this.price = price;
    }
}
