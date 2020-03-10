package com.example.demo.service;

import com.example.demo.po.Mcomment;

import java.util.List;

public interface McommentService {

    List<Mcomment> listMcommentByMusicTag(Integer mdataTag);

    Mcomment saveMcomment(Mcomment mcomment);

}
