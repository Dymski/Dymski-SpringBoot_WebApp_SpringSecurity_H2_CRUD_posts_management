package sda.twitterAtSDA.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class MessageDto {

    private Long messageID;
    private Long postID;
    private Long commentID;
    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date messageDate;
    private String messageText;
    private Long userId;


}
