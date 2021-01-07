package sda.twitterAtSDA.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private String gender;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateOfBirth;
    private String password;
    private String role;


}
