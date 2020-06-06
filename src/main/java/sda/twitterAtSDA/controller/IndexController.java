package sda.twitterAtSDA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import sda.twitterAtSDA.model.dto.MessageDto;
import sda.twitterAtSDA.model.entity.User;
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
        User user = userService.getUserById(userService.getUserByEmail(SecurityContextHolder.getContext()
                .getAuthentication()
                .getName())
                .getId());
        model.addAttribute("postsList", messageService.getAllPosts());
        model.addAttribute("commentsList", messageService.getAllComments((Long) model.getAttribute("postsID")));
        model.addAttribute("userName", user.getName());
        model.addAttribute("userId", user.getId());
        return "index";
    }
}

