package sda.twitterAtSDA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import sda.twitterAtSDA.model.dto.UserDto;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public ModelAndView registerView(){
        return new ModelAndView("register", "newUser", new UserDto());
    }
}
