package com.example.demo.service;

import com.example.demo.dao.MtypeattrRepository;
import com.example.demo.po.Mtypeattr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MtypeattrServiceImpl implements MtypeattrService {

    @Autowired
    private MtypeattrRepository mtypeattrRepository;

    @Override
    public List<Mtypeattr> listMtypeattr() {
        return mtypeattrRepository.findAll();
    }
}
