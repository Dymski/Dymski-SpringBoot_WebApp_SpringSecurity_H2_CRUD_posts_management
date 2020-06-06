package sda.twitterAtSDA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        messageService.createPost(messageDto);
        new ModelAndView("message", "newMessage", MessageDto.class);
        return "redirect:/index";
    }

    @PostMapping("/deleteMessage")
    public String deleteMessage(@ModelAttribute("message") MessageDto messageDto){
        messageService.deleteMessage(messageDto.getMessageID());
        return "redirect:/index";
    }

    @PostMapping("/addComment")
    public String addComment(@ModelAttribute MessageDto messageDto){
        messageService.createComment(messageDto);
        new ModelAndView("message", "newMessage", MessageDto.class);
        return "redirect:/index";
    }


}
