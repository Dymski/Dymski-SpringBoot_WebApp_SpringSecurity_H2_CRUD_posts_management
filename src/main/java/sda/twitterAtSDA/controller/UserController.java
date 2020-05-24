package sda.twitterAtSDA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sda.twitterAtSDA.model.dto.UserDto;
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

    @GetMapping("/users/{name}")
    public ModelAndView findAllUserByNameQuery(@PathVariable("name") String name){
        return new ModelAndView("users", "usersList", userService.getUsersByName(name));
    }

    @GetMapping("/users")
    public ModelAndView findAllUsers(){
        return new ModelAndView("users", "usersList", userService.getAllUsers());
    }
}
