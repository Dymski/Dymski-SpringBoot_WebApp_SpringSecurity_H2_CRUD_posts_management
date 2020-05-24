package sda.twitterAtSDA.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UserStatus {

    @Id
    private Long userId;
    private boolean isOnline;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

}
