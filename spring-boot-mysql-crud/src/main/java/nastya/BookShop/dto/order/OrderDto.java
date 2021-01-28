package nastya.BookShop.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Integer orderNumber;
    private Integer shopId;
    private Integer cost;
    private String deliveryAddress;
    private String description;
    private String OrderSubmitDate;
    private Integer classificationId;
    private String classificationStatus;
    private String orderCompleteDate;
    private String username;

}

