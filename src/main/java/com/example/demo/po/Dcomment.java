package com.example.demo.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//舞蹈评论表
@Entity
@Table(name="dancecomment")
public class Dcomment {

    @Id
    @GeneratedValue
    //主键
    private Long id;

    private String nickname;

    private String email;

    private String content;

    private String avatar;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    //多个评论对应一个ddata
    @ManyToOne
    private Ddata ddata;


    //评论对象之间的自关联关系
    @OneToMany(mappedBy = "parentComment")
    private List<Dcomment> replyComments=new ArrayList<>();

    @ManyToOne
    private Dcomment parentComment;

    public Dcomment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Ddata getDdata() {
        return ddata;
    }

    public void setDdata(Ddata ddata) {
        this.ddata = ddata;
    }

    public List<Dcomment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Dcomment> replyComments) {
        this.replyComments = replyComments;
    }

    public Dcomment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Dcomment parentComment) {
        this.parentComment = parentComment;
    }

    @Override
    public String toString() {
        return "Dcomment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                ", ddata=" + ddata +
                ", replyComments=" + replyComments +
                ", parentComment=" + parentComment +
                '}';
    }
}
