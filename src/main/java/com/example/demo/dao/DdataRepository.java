package com.example.demo.dao;

import com.example.demo.po.Ddata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface DdataRepository extends JpaRepository<Ddata,Long> {

    Ddata findDdataByTag(int tag);

    @Transactional
    @Modifying
    @Query("update Ddata d set d.views=d.views+1 where d.tag=?1")
    int updateViews(int tag);

}
