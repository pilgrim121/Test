package com.example.demo.web;

import com.example.demo.po.Ocomment;
import com.example.demo.service.OcommentService;
import com.example.demo.service.OdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OcommentController {

    @Autowired
    private OcommentService ocommentService;

    @Autowired
    private OdataService odataService;

    @Value("${ocomment.avatar}")
    private String avatar;

    @GetMapping("/ocomments/{operadataTag}")
    public String comments(@PathVariable Integer operadataTag, Model model){
        model.addAttribute("ocomments",ocommentService.listOcommentByOperaTag(operadataTag));
        return "OperaResource::commentList";
    }


    @PostMapping("/ocomments")
    public String post(Ocomment ocomment){

        Integer odataTag=ocomment.getOdata().getTag();
        ocomment.setOdata(odataService.getOdata(odataTag));
        ocomment.setAvatar(avatar);
        ocommentService.saveOcomment(ocomment);
        return "redirect:/ocomments/"+ odataTag;
    }


}
