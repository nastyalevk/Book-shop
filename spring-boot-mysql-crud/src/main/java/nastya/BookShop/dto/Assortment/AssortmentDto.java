package nastya.BookShop.dto.Assortment;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AssortmentDto {
    private Integer bookId;
    private Integer shopId;
    private Integer quantity;
    private Integer Price;
    private Date creationDate;
    private Integer classificationId;
    private String classificationStatus;

    public AssortmentDto(Integer bookId, Integer shopId, Integer quantity, Integer price,
                         Date creationDate, Integer classificationId, String classificationStatus) {
        this.bookId = bookId;
        this.shopId = shopId;
        this.quantity = quantity;
        Price = price;
        this.creationDate = creationDate;
        this.classificationId = classificationId;
        this.classificationStatus = classificationStatus;
    }

    public AssortmentDto() {
    }
}
