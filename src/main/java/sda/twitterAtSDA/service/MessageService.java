package sda.twitterAtSDA.service;


import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sda.twitterAtSDA.model.dto.MessageDto;
import sda.twitterAtSDA.model.dto.UserDto;
import sda.twitterAtSDA.model.entity.Message;
import sda.twitterAtSDA.model.entity.User;
import sda.twitterAtSDA.repository.MessageRepository;

import java.util.Comparator;
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
        String email = (SecurityContextHolder.getContext().getAuthentication().getName());
        UserDto userDto = userService.getUserByEmail(email);
        message.setName(userDto.getName()+" "+userDto.getSurname());
        message.setMessageDate(new Date());
        message.setUserId(userService.getUserByEmail(email).getId());
        message.setPostID(message.getMessageID());
        messageRepository.save(message);

    }

    public List<MessageDto> getAllMessages() {
        return messageRepository.findAll()
                .stream()
                .map(message -> mapper.map(message, MessageDto.class))
                .collect(Collectors.toList());
    }


}
