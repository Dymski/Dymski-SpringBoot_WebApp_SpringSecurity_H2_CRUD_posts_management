package sda.twitterAtSDA.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Set;

@Entity
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long Id;
    @Getter @Setter
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> friends;

}
