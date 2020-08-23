package sda.twitterAtSDA.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Getter
@Setter
public class UserStatus {

    @Id
    private Long userId;
    private boolean isOnline;

}
