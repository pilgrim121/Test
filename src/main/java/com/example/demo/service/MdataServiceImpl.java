package com.example.demo.service;

import com.example.demo.dao.MdataRepository;
import com.example.demo.po.Mdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MdataServiceImpl implements MdataService {

    @Autowired
    private MdataRepository mdataRepository;

    @Override
    public Mdata getMdata(int tag) {
        Mdata mdata=mdataRepository.findMdataByTag(tag);
        mdataRepository.updateViews(tag);
        return mdata;
    }
}
