package nastya.BookShop.dto.userRoles;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRolesDto {
    private Integer userId;
    private Integer roleId;

    public UserRolesDto(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public UserRolesDto() {
    }
}
