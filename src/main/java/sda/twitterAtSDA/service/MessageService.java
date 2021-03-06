package sda.twitterAtSDA.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sda.twitterAtSDA.model.dto.MessageDto;
import sda.twitterAtSDA.model.dto.UserDto;
import sda.twitterAtSDA.model.entity.Message;
import sda.twitterAtSDA.repository.MessageRepository;

import javax.validation.constraints.Null;
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

    public void createPost(MessageDto messageDto) {
        Message message = mapper.map(messageDto, Message.class);
        String email = (SecurityContextHolder.getContext().getAuthentication().getName());
        UserDto userDto = userService.getUserByEmail(email);
        message.setName(userDto.getName() + " " + userDto.getSurname());
        this.messageTimeStamp = new Date();
        message.setMessageDate(messageTimeStamp);
        message.setUserId(userService.getUserByEmail(email).getId());
        message.setCommentID(0l);
        messageRepository.save(message);
        message.setPostID(getMessageIdByTimeStamp(messageTimeStamp));
        messageRepository.save(message);

    }

    public void createComment(MessageDto messageDto){
        Message message = mapper.map(messageDto, Message.class);
        String email = (SecurityContextHolder.getContext().getAuthentication().getName());
        UserDto userDto = userService.getUserByEmail(email);
        message.setName(userDto.getName() + " " + userDto.getSurname());
        this.messageTimeStamp = new Date();
        message.setMessageDate(messageTimeStamp);
        message.setUserId(userService.getUserByEmail(email).getId());
        message.setPostID(messageDto.getPostID());
        message.setCommentID(messageDto.getPostID());
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

    public List<MessageDto> getAllPosts() {
        List<MessageDto> list = messageRepository.findAll()
                .stream()
                .filter(message -> message.getCommentID().equals(0l))   // HC
                .map(message -> mapper.map(message, MessageDto.class))
                .collect(Collectors.toList());
        Collections.reverse(list);
        return list;
    }

    public List<MessageDto> getAllComments() {
            List<MessageDto> list = messageRepository.findAll()
                    .stream()
                    .filter(message -> (!message.getCommentID().equals(0L)))
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
