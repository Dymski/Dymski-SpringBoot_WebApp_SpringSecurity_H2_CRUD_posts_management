package sda.twitterAtSDA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginView(){
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(){
        return "error";
    }


}
