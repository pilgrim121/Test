package com.example.demo;

import com.example.demo.dao.ResourceRepository;
import com.example.demo.po.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ElasticsearchTemplate template;

//    /*创建索引*/
//    @Test
//    ////创建索引，并配置映射关系
//    public void createIndex() throws Exception{
//        template.createIndex(Resource.class);
//        template.putMapping(Resource.class);
//    }

}
