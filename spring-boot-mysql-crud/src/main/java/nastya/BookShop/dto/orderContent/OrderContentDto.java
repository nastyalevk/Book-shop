package nastya.BookShop.dto.orderContent;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderContentDto {

    @JsonProperty("orderNumber")
    private Integer orderNumber;
    @JsonProperty("bookId")
    private Integer bookId;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("price")
    private Integer price;

}
