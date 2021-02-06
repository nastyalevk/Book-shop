package nastya.BookShop.dto.Assortment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssortmentDto {

    private Integer bookId;
    private Integer shopId;
    private Integer quantity;
    private Integer Price;
    private String creationDate;
    private AssortmentClassification classification;

}
