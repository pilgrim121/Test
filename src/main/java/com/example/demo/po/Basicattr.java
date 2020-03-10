package com.example.demo.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//基本属性表
@Entity
@Table(name="basicattr")
public class Basicattr {

    @Id
    @GeneratedValue
    //主键
    private Long id;

    //基本属性名称
    private String name;

    //基本属性编码
    private Long code;

    //基本属性内容
    private String value;

    public Basicattr() {
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
        return "Basicattr{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", value='" + value + '\'' +
                '}';
    }
}
