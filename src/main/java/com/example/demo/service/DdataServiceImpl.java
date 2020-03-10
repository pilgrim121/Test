package com.example.demo.service;

import com.example.demo.dao.DdataRepository;
import com.example.demo.po.Ddata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DdataServiceImpl implements DdataService {

    @Autowired
    private DdataRepository ddataRepository;

    @Override
    public Ddata getDdata(int tag) {
        Ddata ddata=ddataRepository.findDdataByTag(tag);
        ddataRepository.updateViews(tag);
        return ddata;
    }
}
