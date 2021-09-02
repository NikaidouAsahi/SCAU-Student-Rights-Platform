package com.vincent.studentrightsplatform.ParamModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CommentParam {
    @NotNull
    private String attachmentFile;
    @NotNull
    private String fileName;
    @NotBlank
    private String commentText;
    @NotBlank
    private String userName;
    @NotBlank
    private String userEmail;
    @NotBlank
    private String userCollege;
    @NotBlank
    private String userGrade;
    @NotBlank
    private String userProfession;
    @NotBlank
    private String userPhoneNumber;

    public String getAttachmentFile() { return this.attachmentFile; }
    public String getFileName() { return this.fileName; }
    public String getCommentText() { return this.commentText; }
    public String getUserName() { return this.userName; }
    public String getUserEmail() { return this.userEmail; }
    public String getUserCollege() { return this.userCollege; }
    public String getUserGrade() { return this.userGrade; }
    public String getUserProfession() { return this.userProfession; }
    public String getUserPhoneNumber() { return this.userPhoneNumber; }

    public void setAttachmentFile(String attachmentFile) { this.attachmentFile = attachmentFile; }
    public void setFileName(String fileName) { this.fileName = fileName; }
    public void setCommentText(String commentText) { this.commentText = commentText; }
    public void setUserName(String userName) { this.userName = userName; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    public void setUserCollege(String userCollege) { this.userCollege = userCollege; }
    public void setUserGrade(String userGrade) { this.userGrade = userGrade; }
    public void setUserProfession(String userProfession) { this.userProfession = userProfession; }
    public void setUserPhoneNumber(String userPhoneNumber) { this.userPhoneNumber = userPhoneNumber; }
}
