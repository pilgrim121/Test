package com.example.demo.dao;

import com.example.demo.po.Odata;
import com.example.demo.po.Oprovince;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OdataRepository extends JpaRepository<Odata,Long>{

    //根据省份名称查找省下面对应的戏曲列表

    List<Odata> findOdataByOprovince(Oprovince oprovince);


    Odata findOdataByTag(int tag);

    @Transactional
    @Modifying
    @Query("update Odata o set o.views=o.views+1 where o.tag=?1")
    int updateViews(int tag);


}
