package nastya.BookShop.dto.role;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleDto {

    private Integer id;
    private String roleName;

    public RoleDto(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public RoleDto() {
    }
}
