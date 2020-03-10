package com.example.demo.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//节日编码信息数据表
@Entity
@Table(name="f_data")
public class Fdata {

    @Id
    @GeneratedValue
    //主键
    private Long id;

    //标志：与ES中对应的tag一致
    private int tag;

    //节日种类名称
    private String title;

    //节日种类名称编码
    private String namecode;

    //节日编码
    private String festivalcode;

    //图片地址
    private String img_addr;

    //资源录入时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date input_time;

    //浏览次数
    private Integer views;

    //多个Ddata对应一个Dnation
    @ManyToOne
    private Fnation fnation;

    //多个Fdata对应一个User
    @ManyToOne
    private User user;


    @OneToMany(mappedBy = "fdata")
    private List<Fcomment> fcommentList =new ArrayList<>();




    public Fdata() {
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

    public String getFestivalcode() {
        return festivalcode;
    }

    public void setFestivalcode(String festivalcode) {
        this.festivalcode = festivalcode;
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

    public Fnation getFnation() {
        return fnation;
    }

    public void setFnation(Fnation fnation) {
        this.fnation = fnation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Fcomment> getFcommentList() {
        return fcommentList;
    }

    public void setFcommentList(List<Fcomment> fcommentList) {
        this.fcommentList = fcommentList;
    }


}
