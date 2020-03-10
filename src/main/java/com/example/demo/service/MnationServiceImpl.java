package com.example.demo.service;

import com.example.demo.dao.MnationRepository;
import com.example.demo.po.Mnation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MnationServiceImpl implements MnationService {

    @Autowired
    private MnationRepository mnationRepository;

    @Override
    public List<Mnation> listMnation() {
        return mnationRepository.findAll();
    }
}
