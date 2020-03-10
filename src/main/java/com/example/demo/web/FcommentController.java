package com.example.demo.web;


import com.example.demo.po.Fcomment;
import com.example.demo.service.FcommentService;
import com.example.demo.service.FdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FcommentController {

    @Autowired
    private FcommentService fcommentService;

    @Autowired
    private FdataService fdataService;


    @Value("${fcomment.avatar}")
    private String avatar;


    @GetMapping("/fcomments/{fdataTag}")
    public String comments(@PathVariable Integer fdataTag, Model model){
        model.addAttribute("fcomments",fcommentService.listFcommentByFestivalTag(fdataTag));
        return "FestivalResource::commentList";
    }


    @PostMapping("/fcomments")
    public String post(Fcomment fcomment){

        Integer festivalTag=fcomment.getFdata().getTag();
        fcomment.setFdata(fdataService.getFdata(festivalTag));
        fcomment.setAvatar(avatar);
        fcommentService.saveFcomment(fcomment);
        return "redirect:/fcomments/"+ festivalTag;
    }

}
