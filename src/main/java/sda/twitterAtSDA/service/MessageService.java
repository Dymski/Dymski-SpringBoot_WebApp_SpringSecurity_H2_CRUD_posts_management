package sda.twitterAtSDA.service;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sda.twitterAtSDA.model.dto.MessageDto;
import sda.twitterAtSDA.model.entity.Message;
import sda.twitterAtSDA.repository.MessageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private ModelMapper mapper;
    private MessageRepository messageRepository;

    public MessageService(ModelMapper mapper, MessageRepository messageRepository){
        this.mapper = mapper;
        this.messageRepository = messageRepository;
    }

    public void createMessage (MessageDto messageDto){
        Message message= mapper.map(messageDto, Message.class);
        message = messageRepository.save(message);
    }


    public List<MessageDto> getAllMessages(){
        return messageRepository.findAll()
                .stream()
                .map(message -> mapper.map(message, MessageDto.class))
                .collect(Collectors.toList());
    }


}
