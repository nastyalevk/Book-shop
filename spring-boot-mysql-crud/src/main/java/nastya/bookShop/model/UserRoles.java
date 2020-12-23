package nastya.bookShop.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "user_roles")
public class UserRoles implements Serializable {
    @EmbeddedId
    private UserRolesId userRolesId;

    public UserRoles(){}

    public UserRoles(UserRolesId userRolesId) {
        this.userRolesId = userRolesId;
    }
}
