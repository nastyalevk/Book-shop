package nastya.BookShop.repository;

import nastya.BookShop.dto.role.ERole;
import nastya.BookShop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByRoleName(ERole name);

    Optional<Role> findById(Integer id);

    Role findByRoleName(String roleName);
}
