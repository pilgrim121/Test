package com.example.demo.service;

import com.example.demo.dao.FdataRepository;
import com.example.demo.po.Fdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FdataServiceImpl implements FdataService {

    @Autowired
    private FdataRepository fdataRepository;

    @Override
    public Fdata getFdata(int tag) {
        Fdata fdata=fdataRepository.findFdataByTag(tag);
        fdataRepository.updateViews(tag);
        return fdata;
    }
}
