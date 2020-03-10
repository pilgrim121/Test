package com.example.demo.dao;

import com.example.demo.po.Fdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface FdataRepository extends JpaRepository<Fdata,Long> {

    Fdata findFdataByTag(int tag);

    @Transactional
    @Modifying
    @Query("update Fdata f set f.views=f.views+1 where f.tag=?1")
    int updateViews(int tag);

}
