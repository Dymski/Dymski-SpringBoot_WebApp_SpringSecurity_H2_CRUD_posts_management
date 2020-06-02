package sda.twitterAtSDA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sda.twitterAtSDA.model.dto.UserDto;
import sda.twitterAtSDA.model.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    }
