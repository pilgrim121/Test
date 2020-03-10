package com.example.demo.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//节日的民族表
@Entity
@Table(name="f_nation")
public class Fnation {

    @Id
    @GeneratedValue
    //主键
    private Long id;

    //民族
    private String name;

    //民族编码
    private String code;

    //一个民族下对应多个节日
    @OneToMany(mappedBy = "fnation")
    private List<Fdata> fdatalist=new ArrayList<>();

    public Fnation() {
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

    public List<Fdata> getFdatalist() {
        return fdatalist;
    }

    public void setFdatalist(List<Fdata> fdatalist) {
        this.fdatalist = fdatalist;
    }

    @Override
    public String toString() {
        return "Fnation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", fdatalist=" + fdatalist +
                '}';
    }
}
