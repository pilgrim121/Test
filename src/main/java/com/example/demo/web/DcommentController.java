package com.example.demo.web;


import com.example.demo.po.Dcomment;
import com.example.demo.po.Ocomment;
import com.example.demo.service.DcommentService;
import com.example.demo.service.DdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DcommentController {

    @Autowired
    private DcommentService dcommentService;

    @Autowired
    private DdataService ddataService;


    @Value("${dcomment.avatar}")
    private String avatar;


    @GetMapping("/dcomments/{ddataTag}")
    public String comments(@PathVariable Integer ddataTag, Model model){
        model.addAttribute("dcomments",dcommentService.listDcommentByDanceTag(ddataTag));
        return "DanceResource::commentList";
    }


    @PostMapping("/dcomments")
    public String post(Dcomment dcomment){

        Integer danceTag=dcomment.getDdata().getTag();
        dcomment.setDdata(ddataService.getDdata(danceTag));
        dcomment.setAvatar(avatar);
        dcommentService.saveDcomment(dcomment);
        return "redirect:/dcomments/"+ danceTag;
    }

}
