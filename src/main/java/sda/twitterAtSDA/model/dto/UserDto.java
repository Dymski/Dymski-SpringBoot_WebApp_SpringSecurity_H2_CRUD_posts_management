package sda.twitterAtSDA.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserDto {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String surname;
    @Getter
    @Setter
    private Integer age;
    @Getter
    @Setter
    private String gender;
    @Getter
    @Setter
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateOfBirth;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String role;


}
