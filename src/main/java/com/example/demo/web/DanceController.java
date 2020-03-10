package com.example.demo.web;

import com.example.demo.dao.ResourceRepository;
import com.example.demo.po.Dnation;
import com.example.demo.po.Dtypeattr;
import com.example.demo.po.Resource;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class DanceController {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private DnationService dnationService;

    @Autowired
    private DdataService ddataService;

    @Autowired
    private DtypeattrService dtypeattrService;

    @RequestMapping("/dance")
    public String dance(Model model){

        List<Dnation> dnationList=dnationService.listDnation();
        model.addAttribute("dnations",dnationList);

        List<Dtypeattr> dtypeattrList=dtypeattrService.listDtypeattr();
        model.addAttribute("dtypeattrs",dtypeattrList);

        return "dance";
    }



    //根据tag值获取内容
    @GetMapping("/DanceResource/{tag}")
    public String blog(@PathVariable int tag, Model model){
        model.addAttribute("ddata",ddataService.getDdata(tag));
        model.addAttribute("resource", resourceRepository.getResourceByTag(tag));
        return "DanceResource";
    }

}
