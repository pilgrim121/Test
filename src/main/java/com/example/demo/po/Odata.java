package com.example.demo.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//戏曲编码信息表
@Entity
@Table(name="o_data")
public class Odata {

    @Id
    @GeneratedValue
    //主键
    private Long id;

    //标志：与ES中对应的tag一致
    private int tag;

    //戏曲种类名称
    private String title;

    //戏曲种类名称编码
    private String operakind_namecode;

    //戏曲编码
    private String opera_code;


    //图片地址
    private String img_addr;

   //资源录入时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date input_time;

   //浏览次数
    private Integer views;

    //点赞次数
    //private Integer prises;

    //是否开启评论
    //private Boolean commentabled;


    //多个Odata对应一个Oprovince
    @ManyToOne
    private Oprovince oprovince;

    //多个Operadata对应一个User
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "odata")
    private List<Ocomment> ocommentList =new ArrayList<>();



    public Odata() {
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

    public String getOperakind_namecode() {
        return operakind_namecode;
    }

    public void setOperakind_namecode(String operakind_namecode) {
        this.operakind_namecode = operakind_namecode;
    }

    public String getOpera_code() {
        return opera_code;
    }

    public void setOpera_code(String opera_code) {
        this.opera_code = opera_code;
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

//
//    public Integer getPrises() {
//        return prises;
//    }
//
//    public void setPrises(Integer prises) {
//        this.prises = prises;
//    }
//


//
//    public Boolean getCommentabled() {
//        return commentabled;
//    }
//
//    public void setCommentabled(Boolean commentabled) {
//        this.commentabled = commentabled;
//    }
//
//

    public Oprovince getOprovince() {
        return oprovince;
    }

    public void setOprovince(Oprovince oprovince) {
        this.oprovince = oprovince;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Ocomment> getOperacommentList() {
        return ocommentList;
    }

    public void setOperacommentList(List<Ocomment> ocommentList) {
        this.ocommentList = ocommentList;
    }

    //
//    @Override
//    public String toString() {
//        return "Odata{" +
//                "id=" + id +
//                ", operakind_name='" + operakind_name + '\'' +
//                ", operakind_namecode='" + operakind_namecode + '\'' +
//                ", opera_code='" + opera_code + '\'' +
//                ", img_addr='" + img_addr + '\'' +
//                ", province=" + province +
//                '}';
//    }

}
