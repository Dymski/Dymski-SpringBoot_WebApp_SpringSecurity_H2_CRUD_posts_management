package sda.twitterAtSDA.service;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sda.twitterAtSDA.model.dto.MessageDto;
import sda.twitterAtSDA.model.dto.UserDto;
import sda.twitterAtSDA.model.entity.Message;
import sda.twitterAtSDA.repository.MessageRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private ModelMapper mapper;
    private MessageRepository messageRepository;
    private UserService userService;
    private Date messageTimeStamp;
//    private Long postsToDisplay = 5l;

    public MessageService(ModelMapper mapper, MessageRepository messageRepository, UserService userService) {
        this.mapper = mapper;
        this.messageRepository = messageRepository;
        this.userService = userService;
    }

//    private void displayMorePostsBy5(){
//        postsToDisplay = postsToDisplay + 5l;
//    }

    public void createPost(MessageDto messageDto) {
        Message message = mapper.map(messageDto, Message.class);
        String email = (SecurityContextHolder.getContext().getAuthentication().getName());
        UserDto userDto = userService.getUserByEmail(email);
        message.setName(userDto.getName() + " " + userDto.getSurname());
        this.messageTimeStamp = new Date();
        message.setMessageDate(messageTimeStamp);
        message.setUserId(userService.getUserByEmail(email).getId());
        messageRepository.save(message);
        message.setPostID(getMessageIdByTimeStamp(messageTimeStamp));
        messageRepository.save(message);

    }

    public List<MessageDto> getAllMessages() {
        List<MessageDto> list = messageRepository.findAll()
                .stream()
                .map(message -> mapper.map(message, MessageDto.class))
                .collect(Collectors.toList());

        Collections.reverse(list);

        return list;
    }

    private Long getMessageIdByTimeStamp(Date date) {
        return messageRepository.findAll()
                .stream()
                .filter(message -> message.getMessageDate().equals(date))
                .findFirst()
                .get()
                .getMessageID();
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }

}
