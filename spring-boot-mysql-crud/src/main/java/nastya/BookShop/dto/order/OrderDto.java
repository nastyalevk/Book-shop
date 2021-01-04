package nastya.BookShop.dto.order;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;


@Setter
@Getter
public class OrderDto {

    private Integer id;
    private Integer orderNumber;
    private Integer shopId;
    private Integer cost;
    private String deliveryAddress;
    private String description;
    private Date OrderSubmitDate;
    private Integer classificationId;
    private String classificationStatus;
    private Date orderCompleteDate;
    private Integer userId;

    public OrderDto(Integer id, Integer orderNumber, Integer shopId, Integer cost, String deliveryAddress, String description, Date orderSubmitDate, Integer classificationId, String classificationStatus, Date orderCompleteDate, Integer userId) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.shopId = shopId;
        this.cost = cost;
        this.deliveryAddress = deliveryAddress;
        this.description = description;
        OrderSubmitDate = orderSubmitDate;
        this.classificationId = classificationId;
        this.classificationStatus = classificationStatus;
        this.orderCompleteDate = orderCompleteDate;
        this.userId = userId;
    }

    public OrderDto() {
    }
}

