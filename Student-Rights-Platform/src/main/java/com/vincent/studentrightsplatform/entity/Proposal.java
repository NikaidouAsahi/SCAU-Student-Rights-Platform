package com.vincent.studentrightsplatform.entity;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
public class Proposal {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="proposal_id")
    private int id;
    private String proposalTitle; // 标题
    private String userName; // 用户名
    private String userCollegeAndProfession; //学院专业
    private String userId; // 学号
    private String userContact; // 联系方式
    private String userEmail; // 邮箱
    private String proposalContent; // 提案内容
    private String photoPath; // 图片路径
    private String documentPath; // 文档路径
    private String solution; // 解决方案

    public void setId(int id) {
        this.id = id;
    }

    public void setProposalTitle(String proposalTitle) {
        this.proposalTitle = proposalTitle;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserCollegeAndProfession(String userCollegeAndProfession) {
        this.userCollegeAndProfession = userCollegeAndProfession;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setProposalContent(String proposalContent) {
        this.proposalContent = proposalContent;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
