package sda.twitterAtSDA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.twitterAtSDA.model.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
