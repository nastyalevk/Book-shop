package nastya.BookShop.dto.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto{
    private Integer id;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;

    public UserDto(Integer id, String userName, String email, String firstName, String lastName) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserDto() {
    }
}
