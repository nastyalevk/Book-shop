package nastya.BookShop.dto.shop;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShopDto{
    private Integer id;
    private String shopName;
    private String country;
    private String city;
    private String address;
    private String description;
    private Integer classificationId;
    private String classificationStatus;
    private Integer userId;

    public ShopDto(Integer id, String shopName, String country, String city, String address, String description, Integer classificationId, String classificationStatus, Integer userId) {
        this.id = id;
        this.shopName = shopName;
        this.country = country;
        this.city = city;
        this.address = address;
        this.description = description;
        this.classificationId = classificationId;
        this.classificationStatus = classificationStatus;
        this.userId = userId;
    }

    public ShopDto() {
    }
}
