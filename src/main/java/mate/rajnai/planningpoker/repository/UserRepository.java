package mate.rajnai.planningpoker.repository;

import mate.rajnai.planningpoker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
