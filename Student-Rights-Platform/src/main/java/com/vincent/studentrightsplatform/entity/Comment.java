package com.vincent.studentrightsplatform.entity;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="comment_id")
    private int id;
    private String attachmentFileName;
    private String commentText;
    private String userId;
    private String userEmail;
    private String userGrade;
    private String userProfession;
    private String userName;
    private String userCollege;
    private String userPhoneNumber;

    public void setId(int id) {
        this.id = id;
    }

    public void setAttachmentFileName(String attachmentFileName) {
        this.attachmentFileName = attachmentFileName;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    public void setUserProfession(String userProfession) {
        this.userProfession = userProfession;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserCollege(String userCollege) {
        this.userCollege = userCollege;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }
}
