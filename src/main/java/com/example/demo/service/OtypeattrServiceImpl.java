package com.example.demo.service;

import com.example.demo.dao.OtypeattrRepository;
import com.example.demo.po.Otypeattr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtypeattrServiceImpl implements OtypeattrService {

    @Autowired
    private OtypeattrRepository otypeattrRepository;

    //查找戏曲分类属性
    @Override
    public List<Otypeattr> listOtypeattr() {
        return otypeattrRepository.findAll();
    }
}
