package nastya.BookShop.repository;

import nastya.BookShop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Integer> {
}
