package com.vincent.studentrightsplatform.ParamModel;

import javax.validation.constraints.NotEmpty;

public class ProposalParam {
    @NotEmpty
    private String photo; // 图片文件base64格式
    @NotEmpty
    private String document; // 文档文件base64格式
    @NotEmpty
    private String photoName; // 图片文件名
    @NotEmpty
    private String documentName; // 文档文件名
    @NotEmpty
    private String proposalTitle; // 标题
    @NotEmpty
    private String userName; // 用户名
    @NotEmpty
    private String userCollegeAndProfession; //学院专业
    @NotEmpty
    private String userId; // 学号
    @NotEmpty
    private String userContact; // 联系方式
    @NotEmpty
    private String userEmail; // 邮箱
    @NotEmpty
    private String proposalContent; // 提案内容
    @NotEmpty
    private String solution; // 解决方案

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getProposalTitle() {
        return proposalTitle;
    }

    public void setProposalTitle(String proposalTitle) {
        this.proposalTitle = proposalTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCollegeAndProfession() {
        return userCollegeAndProfession;
    }

    public void setUserCollegeAndProfession(String userCollegeAndProfession) {
        this.userCollegeAndProfession = userCollegeAndProfession;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getProposalContent() {
        return proposalContent;
    }

    public void setProposalContent(String proposalContent) {
        this.proposalContent = proposalContent;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
