package com.example.demo.service;

import com.example.demo.dao.OprovinceRepository;
import com.example.demo.po.Oprovince;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OprovinceServiceImpl implements OprovinceServince {

    @Autowired
    private OprovinceRepository oprovinceRepository;

    @Override
    public List<Oprovince> listOprovince() {
        return oprovinceRepository.findAll();
    }
}
