package com.example.demo.service;

import com.example.demo.po.Ocomment;

import java.util.List;

public interface OcommentService {
    List<Ocomment> listOcommentByOperaTag(Integer operadataTag);

    Ocomment saveOcomment(Ocomment ocomment);
}
