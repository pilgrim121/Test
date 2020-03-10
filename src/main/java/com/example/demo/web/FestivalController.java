package com.example.demo.web;


import com.example.demo.dao.ResourceRepository;
import com.example.demo.po.Dnation;
import com.example.demo.po.Dtypeattr;
import com.example.demo.po.Fnation;
import com.example.demo.po.Resource;
import com.example.demo.service.FdataService;
import com.example.demo.service.FnationService;
import com.example.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class FestivalController {

    @Autowired
    private FnationService fnationService;

    @Autowired
    private FdataService fdataService;

    @Autowired
    private ResourceRepository resourceRepository;


    @RequestMapping("/festival")
    public String dance(Model model,
                        @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "20") int pageSize){

        List<Fnation> fnationList=fnationService.listFnation();
        model.addAttribute("fnations",fnationList);

        return "festival";
    }



    //根据tag值获取内容
    @GetMapping("/FestivalResource/{tag}")
    public String blog(@PathVariable int tag, Model model){
        model.addAttribute("fdata",fdataService.getFdata(tag));
        model.addAttribute("resource", resourceRepository.getResourceByTag(tag));
        return "FestivalResource";
    }


}
