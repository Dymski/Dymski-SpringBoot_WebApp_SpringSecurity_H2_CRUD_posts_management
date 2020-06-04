package sda.twitterAtSDA.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Friends {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Setter
    private Long friendId;
}
