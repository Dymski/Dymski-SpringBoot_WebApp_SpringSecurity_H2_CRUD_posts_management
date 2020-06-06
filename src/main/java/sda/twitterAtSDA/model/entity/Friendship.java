package sda.twitterAtSDA.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long Id;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> friends;

    public Set<User> getFriends() {
        if (friends == null){
            friends = new HashSet<>();
        }
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }
}
