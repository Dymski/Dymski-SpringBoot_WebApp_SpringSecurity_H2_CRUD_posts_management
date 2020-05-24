package sda.twitterAtSDA.service;


import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sda.twitterAtSDA.model.dto.MessageDto;
import sda.twitterAtSDA.model.entity.Message;
import sda.twitterAtSDA.repository.MessageRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private ModelMapper mapper;
    private MessageRepository messageRepository;
    private UserService userService;

    public MessageService(ModelMapper mapper, MessageRepository messageRepository, UserService userService) {
        this.mapper = mapper;
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

    public void createMessage(MessageDto messageDto) {
        Message message = mapper.map(messageDto, Message.class);
        String name = (userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).getName());
        String surname = (userService.findUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName()).getSurname());
        String fullName = name+" "+surname;
        message.setName(fullName);
        message.setMessageDate(new Date());
        messageRepository.save(message);
    }

    public List<MessageDto> getAllMessages() {
        return messageRepository.findAll()
                .stream()
                .map(message -> mapper.map(message, MessageDto.class))
                .collect(Collectors.toList());
    }


}
