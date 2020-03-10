package com.example.demo.service;


import com.example.demo.dao.DnationRepository;
import com.example.demo.po.Dnation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DnationServiceImpl implements DnationService{

    @Autowired
    private DnationRepository dnationRepository;

    @Override
    public List<Dnation> listDnation() {
        return dnationRepository.findAll();
    }
}
