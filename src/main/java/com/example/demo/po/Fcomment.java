package com.example.demo.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//节日评论表
@Entity
@Table(name="festivalcomment")
public class Fcomment {

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

    //多个评论对应一个fdata
    @ManyToOne
    private Fdata fdata;


    //评论对象之间的自关联关系
    @OneToMany(mappedBy = "parentComment")
    private List<Fcomment> replyComments=new ArrayList<>();

    @ManyToOne
    private Fcomment parentComment;

    public Fcomment() {
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

    public Fdata getFdata() {
        return fdata;
    }

    public void setFdata(Fdata fdata) {
        this.fdata = fdata;
    }

    public List<Fcomment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Fcomment> replyComments) {
        this.replyComments = replyComments;
    }

    public Fcomment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Fcomment parentComment) {
        this.parentComment = parentComment;
    }

    @Override
    public String toString() {
        return "Fcomment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
