package com.example.demo.service;

import com.example.demo.dao.DtypeattrRepository;
import com.example.demo.po.Dtypeattr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtypeattrServiceImpl implements DtypeattrService {

    @Autowired
    private DtypeattrRepository dtypeattrRepository;

    @Override
    public List<Dtypeattr> listDtypeattr() {
        return dtypeattrRepository.findAll();
    }
}
