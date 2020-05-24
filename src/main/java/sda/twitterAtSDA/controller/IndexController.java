package sda.twitterAtSDA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import sda.twitterAtSDA.service.MessageService;
import sda.twitterAtSDA.service.UserService;

@Controller
public class IndexController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "/index"})
    public String indexView(Model model) {
        model.addAttribute("messageList", messageService.getAllMessages());
        model.addAttribute("userName", userService.getUserNameByEmail(SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName()));
        model.addAttribute("userId", userService.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).getId());
        return "index";
    }
}

