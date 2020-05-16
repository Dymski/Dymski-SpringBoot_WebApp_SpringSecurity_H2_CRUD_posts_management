package sda.twitterAtSDA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import sda.twitterAtSDA.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;




}
