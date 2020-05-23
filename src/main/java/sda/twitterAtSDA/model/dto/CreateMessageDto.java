package sda.twitterAtSDA.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CreateMessageDto {

    private Long messageID;
    private Long postID;
    private Long commentID;
    private Long userID;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date messageDate;
    private String messageText;

    public Long getMessageID() {
        return messageID;
    }

    public void setMessageID(Long messageID) {
        this.messageID = messageID;
    }

    public Long getPostID() {
        return postID;
    }

    public void setPostID(Long postID) {
        this.postID = postID;
    }

    public Long getCommentID() {
        return commentID;
    }

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
