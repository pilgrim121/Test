package com.example.demo.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//戏曲的省份表
@Entity
@Table(name="o_province")
public class Oprovince {
    @Id
    @GeneratedValue
    //主键
    private Long id;

    //地域
    private String province_name;

    //地域编码
    private String province_code;

    //一个省对应多个戏曲
    @OneToMany(mappedBy = "oprovince")
    private List<Odata> odatalist =new ArrayList<>();

    public Oprovince() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public List<Odata> getOdatalist() {
        return odatalist;
    }

    public void setOdatalist(List<Odata> odatalist) {
        this.odatalist = odatalist;
    }

    public String getProvince_code() {
        return province_code;
    }

    public void setProvince_code(String province_code) {
        this.province_code = province_code;
    }

    @Override
    public String toString() {
        return "Oprovince{" +
                "id=" + id +
                ", province_name='" + province_name + '\'' +
                ", province_code='" + province_code + '\'' +
                ", odatalist=" + odatalist +
                '}';
    }
}
