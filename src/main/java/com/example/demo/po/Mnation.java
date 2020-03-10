package com.example.demo.po;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//音乐的民族表
@Entity
@Table(name="m_nation")
public class Mnation {

    @Id
    @GeneratedValue
    //主键
    private Long id;

    //民族
    private String name;

    //民族编码
    private String code;

    //一个民族下对应多个音乐
    @OneToMany(mappedBy = "mnation")
    private List<Mdata> mdataList=new ArrayList<>();

    public Mnation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Mdata> getMdataList() {
        return mdataList;
    }

    public void setMdataList(List<Mdata> mdataList) {
        this.mdataList = mdataList;
    }

    @Override
    public String toString() {
        return "Mnation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", mdataList=" + mdataList +
                '}';
    }
}
