package com.vincent.studentrightsplatform;

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
    public void setId(int id) { this.id = id; }
    public void setAttachmentFileName(String filename) {
        this.attachmentFileName = filename;
    }
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
    public void setUserId(String uid) { this.userId = uid; }
    public void setUserEmail(String email) { this.userEmail = email; }
    public void setUserGrade(String grade) { this.userGrade = grade; }
    public void setUserProfession(String profession) { this.userProfession = profession; }
    public void setUserName(String name) { this.userName = name; }
    public void setUserCollege(String college) { this.userCollege = college; }
    public void setUserPhoneNumber(String phoneNumber) { this.userPhoneNumber = phoneNumber; }
}
