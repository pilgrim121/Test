package com.example.demo.service;

import com.example.demo.dao.OdataRepository;
import com.example.demo.po.Odata;
import com.example.demo.po.Oprovince;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdataServiceImpl implements OdataService {

    @Autowired
    private OdataRepository odataRepository;

    @Override
    public List<Odata> listOdata(Oprovince oprovince) {
        return odataRepository.findOdataByOprovince(oprovince);
    }

    @Override
    public Odata getOdata(Long id) {
        return odataRepository.getOne(id);
    }

    @Override
    public Odata getOdata(Integer tag) {
        Odata odata = odataRepository.findOdataByTag(tag);
        odataRepository.updateViews(tag);
        return odata;

    }


}
