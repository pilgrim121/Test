package com.example.demo.service;

import com.example.demo.po.Dcomment;

import java.util.List;

public interface DcommentService {

    List<Dcomment> listDcommentByDanceTag(Integer ddataTag);

    Dcomment saveDcomment(Dcomment ocomment);
}
