package sda.twitterAtSDA.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MessageDto {

    @Getter
    @Setter
    private Long messageID;
    @Getter @Setter
    private Long postID;
    @Getter @Setter
    private Long commentID;
    @Getter @Setter
    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Getter @Setter
    private Date messageDate;
    @Getter @Setter
    private String messageText;
    @Getter @Setter
    private Long userId;


}
