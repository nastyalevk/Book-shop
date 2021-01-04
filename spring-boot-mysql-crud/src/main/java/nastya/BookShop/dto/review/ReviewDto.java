package nastya.BookShop.dto.review;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto {
    private Integer id;
    private Integer userId;
    private String comment;
    private Integer rating;
    private Integer shopId;

    public ReviewDto(Integer id, Integer userId, String comment, Integer rating, Integer shopId) {
        this.id = id;
        this.userId = userId;
        this.comment = comment;
        this.rating = rating;
        this.shopId = shopId;
    }

    public ReviewDto() {
    }
}
