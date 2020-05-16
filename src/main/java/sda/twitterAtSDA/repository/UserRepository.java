package sda.twitterAtSDA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.twitterAtSDA.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
