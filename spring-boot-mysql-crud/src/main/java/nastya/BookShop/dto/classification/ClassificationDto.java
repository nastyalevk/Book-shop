package nastya.BookShop.dto.classification;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClassificationDto {
    private Integer id;
    private Integer classificationId;
    private String classificationStatus;
    private String name;

    public ClassificationDto(Integer id, Integer classificationId, String classificationStatus, String name) {
        this.id = id;
        this.classificationId = classificationId;
        this.classificationStatus = classificationStatus;
        this.name = name;
    }

    public ClassificationDto() {
    }
}
