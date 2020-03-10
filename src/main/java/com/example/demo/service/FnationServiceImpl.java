package com.example.demo.service;

import com.example.demo.dao.FnationRepository;
import com.example.demo.po.Fnation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FnationServiceImpl implements FnationService {

    @Autowired
    private FnationRepository fnationRepository;

    @Override
    public List<Fnation> listFnation() {
        return fnationRepository.findAll();
    }
}
