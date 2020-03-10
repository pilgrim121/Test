package com.example.demo.po;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//用户表（资源标识管理后台）
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    //主键
    private Long id;

    private String username;
    private String pwd;
    private String wechat_imgaddr;

    //一个用户对应多个戏曲
    @OneToMany(mappedBy = "user")
    private List<Odata> operalist=new ArrayList<>();

    //一个用户对应多个舞蹈
    @OneToMany(mappedBy = "user")
    private List<Ddata> dancelist=new ArrayList<>();

    //一个用户对应多个歌曲
    @OneToMany(mappedBy = "user")
    private List<Mdata> musiclist=new ArrayList<>();

    //一个用户对应多个节日
    @OneToMany(mappedBy = "user")
    private List<Fdata> festivallist=new ArrayList<>();



    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getWechat_imgaddr() {
        return wechat_imgaddr;
    }

    public void setWechat_imgaddr(String wechat_imgaddr) {
        this.wechat_imgaddr = wechat_imgaddr;
    }

    public List<Odata> getOperalist() {
        return operalist;
    }

    public void setOperalist(List<Odata> operalist) {
        this.operalist = operalist;
    }

    public List<Ddata> getDancelist() {
        return dancelist;
    }

    public void setDancelist(List<Ddata> dancelist) {
        this.dancelist = dancelist;
    }

    public List<Mdata> getMusiclist() {
        return musiclist;
    }

    public void setMusiclist(List<Mdata> musiclist) {
        this.musiclist = musiclist;
    }

    public List<Fdata> getFestivallist() {
        return festivallist;
    }

    public void setFestivallist(List<Fdata> festivallist) {
        this.festivallist = festivallist;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                ", wechat_imgaddr='" + wechat_imgaddr + '\'' +
                '}';
    }
}
