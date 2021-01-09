package nastya.BookShop.dto.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

    private Integer id;
    private Integer userId;
    private String comment;
    private Integer rating;
    private Integer shopId;

}
