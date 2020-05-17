package sda.twitterAtSDA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import sda.twitterAtSDA.model.dto.CreateUserDto;
import sda.twitterAtSDA.model.entity.User;
import sda.twitterAtSDA.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String addUser(@ModelAttribute CreateUserDto userDto){
         userService.addUser(userDto);
         return "redirect:/index";
    }
}
