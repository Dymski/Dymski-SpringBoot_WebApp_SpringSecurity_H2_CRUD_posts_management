package sda.twitterAtSDA.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UserStatus {

    @Id
    @Getter
    @Setter
    private Long userId;
    @Getter @Setter
    private boolean isOnline;

}
