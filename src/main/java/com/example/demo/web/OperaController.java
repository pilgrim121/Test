package com.example.demo.web;

import com.example.demo.dao.ResourceRepository;
import com.example.demo.po.Basicattr;
import com.example.demo.po.Oprovince;
import com.example.demo.po.Otypeattr;
import com.example.demo.service.BasicattrService;
import com.example.demo.service.OdataService;
import com.example.demo.service.OprovinceServince;
import com.example.demo.service.OtypeattrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OperaController {

    @Autowired
    private OprovinceServince oprovinceServince;

    @Autowired
    private BasicattrService basicattrService;

    @Autowired
    private OtypeattrService otypeattrService;

    @Autowired
    private OdataService odataService;

    @Autowired
    private ResourceRepository resourceRepository;

    @RequestMapping("/opera")
    public String opera(Model model) {
        List<Oprovince> oprovinceList = oprovinceServince.listOprovince();
        model.addAttribute("oprovinces", oprovinceList);
        //System.out.println("省份列表："+oprovinceList);

        //System.out.println("基本属性列表："+basicattrList);
        List<Basicattr> basicattrList = basicattrService.listBasicattr();
        model.addAttribute("basicattrs", basicattrList);

        //System.out.println("分类属性列表："+otypeattrList);
        List<Otypeattr> otypeattrList = otypeattrService.listOtypeattr();
        model.addAttribute("otypeattrs", otypeattrList);

        return "opera";
    }



    //根据资源标志tag获取资源内容
    @GetMapping("/OperaResource/{tag}")
    public String blog(@PathVariable int tag, Model model){
        model.addAttribute("odata", odataService.getOdata(tag));
        model.addAttribute("resource", resourceRepository.getResourceByTag(tag));
        return "OperaResource";
    }
}
