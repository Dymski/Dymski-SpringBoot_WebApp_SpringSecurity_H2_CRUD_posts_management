package sda.twitterAtSDA.model.dto;

public class UserFriendsListDto {

    private Long UserId;
    private Long addedFriendId;
    private String userName;
    private String userSurname;

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public Long getAddedFriendId() {
        return addedFriendId;
    }

    public void setAddedFriendId(Long addedFriendId) {
        this.addedFriendId = addedFriendId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }
}
