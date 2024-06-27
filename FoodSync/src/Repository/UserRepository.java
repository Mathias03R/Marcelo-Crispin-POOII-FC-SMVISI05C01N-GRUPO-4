package Repository;

import modelo.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();

    Optional<User> findById(Long id);

    void save(User user);

    void update(User user);

    void delete(Long id);
}
