package com.example.demo.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//舞蹈编码信息数据表
@Entity
@Table(name="d_data")
public class Ddata {

    @Id
    @GeneratedValue
    //主键
    private Long id;

    //标志：与ES中对应的tag一致
    private int tag;

    //舞蹈种类名称
    private String title;

    //舞蹈种类名称编码
    private String namecode;

    //舞蹈编码
    private String dancecode;

    //图片地址
    private String img_addr;

    //资源录入时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date input_time;

    //浏览次数
    private Integer views;

    //多个Ddata对应一个Dnation
    @ManyToOne
    private Dnation dnation;

    //多个Ddata对应一个User
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "ddata")
    private List<Dcomment> dcommentList =new ArrayList<>();



    public Ddata() {
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

    public String getDancecode() {
        return dancecode;
    }

    public void setDancecode(String dancecode) {
        this.dancecode = dancecode;
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

    public Dnation getDnation() {
        return dnation;
    }

    public void setDnation(Dnation dnation) {
        this.dnation = dnation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public List<Dcomment> getDcommentList() {
        return dcommentList;
    }

    public void setDcommentList(List<Dcomment> dcommentList) {
        this.dcommentList = dcommentList;
    }
}
