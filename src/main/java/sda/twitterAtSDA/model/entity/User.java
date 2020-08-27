package sda.twitterAtSDA.model.entity;


import lombok.Getter;
import lombok.Setter;
import sda.twitterAtSDA.model.RoleType;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String gender;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private RoleType role;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "friendship_id")
    private Friendship friendship;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public Friendship getFriendship() {
        if (friendship == null){
            friendship = new Friendship();
        }
        return friendship;
    }

    public void setFriendship(Friendship friendship) {
        this.friendship = friendship;
    }
}
