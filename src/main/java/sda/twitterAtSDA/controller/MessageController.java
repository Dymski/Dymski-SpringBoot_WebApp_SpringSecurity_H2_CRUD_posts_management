package sda.twitterAtSDA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sda.twitterAtSDA.model.dto.MessageDto;
import sda.twitterAtSDA.service.MessageService;

@Controller
public class MessageController {


    @Autowired
    private MessageService messageService;

    @PostMapping("/addPost")
    public String addPost(@ModelAttribute MessageDto messageDto){
        messageService.createMessage(messageDto);
        new ModelAndView("message", "newMessage", MessageDto.class);
        return "redirect:/index";
    }


}
