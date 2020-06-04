package sda.twitterAtSDA.model.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long messageID;
    @Getter @Setter
    private Long postID;
    @Getter @Setter
    private Long commentID;
    @Getter @Setter
    private Long userId;
    @Getter @Setter
    private String name;
    @Temporal(TemporalType.DATE)
    @Getter @Setter
    private Date messageDate;
    @Getter @Setter
    private String messageText;

}
