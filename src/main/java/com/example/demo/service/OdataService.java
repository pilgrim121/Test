package com.example.demo.service;

import com.example.demo.po.Odata;
import com.example.demo.po.Oprovince;

import java.util.List;

public interface OdataService {

    List<Odata> listOdata(Oprovince oprovince);

    Odata getOdata(Long id);

    Odata getOdata(Integer tag);



}
