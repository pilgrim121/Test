package com.example.demo.service;

import com.example.demo.dao.BasicattrRepository;
import com.example.demo.po.Basicattr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicattrServiceImpl implements BasicattrService {

    @Autowired
    private BasicattrRepository basicattrRepository;

    @Override
    public List<Basicattr> listBasicattr() {
        return basicattrRepository.findAll();
    }

}
