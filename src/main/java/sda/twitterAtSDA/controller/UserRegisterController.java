package sda.twitterAtSDA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserRegisterController {

    @GetMapping("/register")
    public String registerView(){
        return "/register";
    }
}
