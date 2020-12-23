package nastya.BookShop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Integer id;

    @OneToMany(mappedBy = "userRolesId.role")
    private Set<UserRoles> userRolesSet;

    @Column(name = "role_name")
    private String roleName;

    public Role(){}
}
