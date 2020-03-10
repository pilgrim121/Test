package com.example.demo.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//音乐编码信息数据表
@Entity
@Table(name="m_data")
public class Mdata {

    @Id
    @GeneratedValue
    //主键
    private Long id;

    //标志：与ES中对应的tag一致
    private int tag;

    //音乐种类名称
    private String title;

    //音乐种类名称编码
    private String namecode;

    //音乐编码
    private String musiccode;

    //图片地址
    private String img_addr;

    //资源录入时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date input_time;

    //浏览次数
    private Integer views;

    //多个音乐对应一个民族
    @ManyToOne
    private Mnation mnation;

    //多个Mdata对应一个用户
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "mdata")
    private List<Mcomment> mcommentList=new ArrayList<>();
    //private List<Mcomment> mcommentList =new ArrayList<>();



    public Mdata() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNamecode() {
        return namecode;
    }

    public void setNamecode(String namecode) {
        this.namecode = namecode;
    }

    public String getMusiccode() {
        return musiccode;
    }

    public void setMusiccode(String musiccode) {
        this.musiccode = musiccode;
    }

    public String getImg_addr() {
        return img_addr;
    }

    public void setImg_addr(String img_addr) {
        this.img_addr = img_addr;
    }

    public Date getInput_time() {
        return input_time;
    }

    public void setInput_time(Date input_time) {
        this.input_time = input_time;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Mnation getMnation() {
        return mnation;
    }

    public void setMnation(Mnation mnation) {
        this.mnation = mnation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Mcomment> getMcommentList() {
        return mcommentList;
    }

    public void setMcommentList(List<Mcomment> mcommentList) {
        this.mcommentList = mcommentList;
    }
}
