package com.example.demo.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//舞蹈的民族表
@Entity
@Table(name="d_nation")
public class Dnation {

    @Id
    @GeneratedValue
    //主键
    private Long id;

    //民族
    private String name;

    //民族编码
    private String code;

    //一个民族下对应多个舞蹈
    @OneToMany(mappedBy = "dnation")
    private List<Ddata> ddatalist=new ArrayList<>();

    public Dnation() {
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

    public List<Ddata> getDdatalist() {
        return ddatalist;
    }

    public void setDdatalist(List<Ddata> ddatalist) {
        this.ddatalist = ddatalist;
    }


    @Override
    public String toString() {
        return "Dnation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", ddatalist=" + ddatalist +
                '}';
    }
}
