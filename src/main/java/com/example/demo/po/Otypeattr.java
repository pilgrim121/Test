package com.example.demo.po;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//戏曲分类属性表
@Entity
@Table(name="o_typeattr")
public class Otypeattr {

    @Id
    @GeneratedValue
    //主键
    private Long id;

    //分类属性名称
    private String name;

    //分类属性编码
    private Long code;

    //分类属性值
    private String value;

    public Otypeattr() {
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

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Operatypeattr{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", value='" + value + '\'' +
                '}';
    }
}
