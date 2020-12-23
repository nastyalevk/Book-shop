package nastya.bookShop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;

    @OneToMany(mappedBy = "userRolesId.user")
    private Set<UserRoles> userRolesSet;

    @OneToMany(mappedBy = "user")
    private Set<Review> reviewSet;

    @OneToMany(mappedBy = "user")
    private Set<Shop> shopSet;

    @OneToMany(mappedBy = "user")
    private Set<Order> orderSet;

    @Column(name = "username")
    private String userName;
    private String email;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public User(){}
}
