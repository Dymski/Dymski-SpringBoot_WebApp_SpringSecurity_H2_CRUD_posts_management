package sda.twitterAtSDA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/searchUser")
    public String getUsersByQuery(@RequestParam(value = "query") String query, Model model){
        model.addAttribute("searchUsers", userService.getUsersByQuery(query));
        return "searchUser";
    }


}
