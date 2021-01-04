package nastya.BookShop.dto.orderContent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderContentDto {
    private Integer orderId;
    private Integer bookId;
    private Integer quantity;
    private Integer price;

    public OrderContentDto(Integer orderId, Integer bookId, Integer quantity, Integer price) {
        this.orderId = orderId;
        this.bookId = bookId;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderContentDto() {
    }
}
