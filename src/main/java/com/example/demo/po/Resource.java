package com.example.demo.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author yxx
 * @create 2020-01-10 16:32
 * 资源索引
 */
@Document(indexName = "resource",type = "resource")
public class Resource {

    //文档的注解Id
    @Id

    //id为长整形，无需分词，即无需指定分析器
    @Field(type = FieldType.Long,store =true)
    private long id;

    //标志：与数据库中的tag保持一致
    @Field(type = FieldType.Integer,store = true)
    private int tag;

    @Field(type = FieldType.Text,store = true,analyzer = "ik_max_word")
    private String title;//文档标题

    @Field(type = FieldType.Text,store = true)
    private String type;//资源类型

    @Field(type = FieldType.Text,store = true,analyzer = "ik_max_word")
    private String content;//文档内容

    @Field(type = FieldType.Text,store = true)
    private String description;//文档内容简要描述

    //文档内容的html
    @Field(type = FieldType.Text,store = true)
    private String content_html;


    public Resource(long id, int tag, String title, String type, String content, String description, String content_html) {
        this.id = id;
        this.tag = tag;
        this.title = title;
        this.type = type;
        this.content = content;
        this.description = description;
        this.content_html = content_html;
    }

    public Resource() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent_html() {
        return content_html;
    }

    public void setContent_html(String content_html) {
        this.content_html = content_html;
    }


    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", tag=" + tag +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", content_html='" + content_html + '\'' +
                '}';
    }
}
