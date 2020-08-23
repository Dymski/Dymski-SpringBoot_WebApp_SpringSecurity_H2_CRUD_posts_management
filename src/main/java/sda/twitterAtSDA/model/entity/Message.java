package sda.twitterAtSDA.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageID;
    private Long postID;
    private Long commentID;
    private Long userId;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date messageDate;
    private String messageText;

}
