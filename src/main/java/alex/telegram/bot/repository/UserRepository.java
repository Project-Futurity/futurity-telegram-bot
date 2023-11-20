package alex.telegram.bot.repository;

import alex.telegram.bot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByFuturityUserId(Long id);

    Optional<User> findByFuturityUserId(Long id);
}
