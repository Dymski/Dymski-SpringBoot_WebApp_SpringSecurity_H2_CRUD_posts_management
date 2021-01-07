package sda.twitterAtSDA.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String surname;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private String gender;
    @Getter @Setter
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Getter @Setter
    private String role;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + name + '\'' +
                ", userSurname='" + surname + '\'' +
                ", userEmail='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", role='" + role + '\'' +
                '}';
    }

}
