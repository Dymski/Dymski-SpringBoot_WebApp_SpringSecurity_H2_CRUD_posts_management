package sda.twitterAtSDA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sda.twitterAtSDA.model.dto.UserDto;
import sda.twitterAtSDA.model.entity.User;
import sda.twitterAtSDA.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String addUser(@ModelAttribute UserDto userDto){
         userService.addUser(userDto);
         return "redirect:/index";
    }
}
