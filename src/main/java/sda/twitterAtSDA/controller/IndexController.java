package sda.twitterAtSDA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import sda.twitterAtSDA.service.MessageService;

@Controller
public class IndexController {

    @Autowired
    private MessageService messageService;

    @GetMapping(value = {"/", "/index"})
    public ModelAndView indexView() {
        return new ModelAndView("index", "messageList", messageService.getAllMessages());
    }
}

