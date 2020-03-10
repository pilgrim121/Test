package com.example.demo.service;

import com.example.demo.po.Fcomment;

import java.util.List;

public interface FcommentService {

    List<Fcomment> listFcommentByFestivalTag(Integer fdataTag);

    Fcomment saveFcomment(Fcomment fcomment);
}
