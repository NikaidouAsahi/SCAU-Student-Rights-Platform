package com.vincent.studentrightsplatform;

import javax.persistence.*;

@Entity
public class Proposal {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="proposal_id")
    private int id;
    public void setId(int id) { this.id = id; }
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
}
