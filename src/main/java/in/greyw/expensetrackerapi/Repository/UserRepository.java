package in.greyw.expensetrackerapi.Repository;

import in.greyw.expensetrackerapi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
