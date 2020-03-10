package com.example.demo.dao;

import com.example.demo.po.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ResourceRepository extends ElasticsearchRepository<Resource,Long> {

    List<Resource> findByTitleOrContent(String title, String Content);
    //根据标题或内容查询,这里最后一个参数可以设置分页
    Page<Resource> findByTitleOrContent(String title, String Content, Pageable pageable);

    Resource getResourceByTag(int tag);



}
