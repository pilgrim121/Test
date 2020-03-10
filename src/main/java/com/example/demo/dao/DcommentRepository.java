package com.example.demo.dao;

import com.example.demo.po.Dcomment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DcommentRepository extends JpaRepository<Dcomment,Long> {
    //找到tag对应，且其父评论id为空，的资源的评论列表
    List<Dcomment> findByDdataTagAndParentCommentNull(Integer ddataTag, Sort sort);
}
