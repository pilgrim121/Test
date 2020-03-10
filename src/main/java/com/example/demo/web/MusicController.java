package com.example.demo.web;


import com.example.demo.dao.ResourceRepository;
import com.example.demo.po.Mnation;
import com.example.demo.po.Mtypeattr;
import com.example.demo.po.Resource;
import com.example.demo.service.MdataService;
import com.example.demo.service.MnationService;
import com.example.demo.service.MtypeattrService;
import com.example.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MusicController {

    @Autowired
    private MnationService mnationService;

    @Autowired
    private MtypeattrService mtypeattrService;

    @Autowired
    private MdataService mdataService;

    @Autowired
    private ResourceRepository resourceRepository;


    @GetMapping("/music")
    public String music(Model model){

        List<Mnation> mnationList=mnationService.listMnation();
        model.addAttribute("mnations",mnationList);

        List<Mtypeattr> mtypeattrList=mtypeattrService.listMtypeattr();
        model.addAttribute("mtypeattrs",mtypeattrList);

        return "music";
    }


    //根据tag值获取内容
    @GetMapping("/MusicResource/{tag}")
    public String blog(@PathVariable int tag, Model model){
        model.addAttribute("mdata",mdataService.getMdata(tag));
        model.addAttribute("resource", resourceRepository.getResourceByTag(tag));
        return "MusicResource";
    }


}
