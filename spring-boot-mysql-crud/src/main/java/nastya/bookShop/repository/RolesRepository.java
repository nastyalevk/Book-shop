package nastya.bookShop.repository;

import nastya.bookShop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Integer> {
}
