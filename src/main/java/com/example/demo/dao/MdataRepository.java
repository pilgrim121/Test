package com.example.demo.dao;

import com.example.demo.po.Mdata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MdataRepository extends JpaRepository<Mdata,Long> {

    Mdata findMdataByTag(int tag);

    @Transactional
    @Modifying
    @Query("update Mdata m set m.views=m.views+1 where m.tag=?1")
    int updateViews(int tag);

}
