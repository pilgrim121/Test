package com.example.demo.po;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//戏曲评论表
@Entity
@Table(name="operacomment")
public class Ocomment {

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

    //多个评论对应一个odata
    @ManyToOne
    private Odata odata;


    //评论对象之间的自关联关系
    @OneToMany(mappedBy = "parentComment")
    private List<Ocomment> replyComments=new ArrayList<>();

    @ManyToOne
    private Ocomment parentComment;



    public Ocomment() {
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

    public Odata getOdata() {
        return odata;
    }

    public void setOdata(Odata odata) {
        this.odata = odata;
    }

    public List<Ocomment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Ocomment> replyComments) {
        this.replyComments = replyComments;
    }

    public Ocomment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Ocomment parentComment) {
        this.parentComment = parentComment;
    }

    @Override
    public String toString() {
        return "Ocomment{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", createTime=" + createTime +
                '}';
    }


}
