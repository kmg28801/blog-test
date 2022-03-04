package tj.kmg.blog.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tj.kmg.blog.test.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

   Optional<User> findByEmail(String email);
}