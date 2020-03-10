package com.example.demo.web;


import com.example.demo.po.Mcomment;
import com.example.demo.service.McommentService;
import com.example.demo.service.MdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class McommentController {

    @Autowired
    private McommentService mcommentService;

    @Autowired
    private MdataService mdataService;


    @Value("${mcomment.avatar}")
    private String avatar;


    @GetMapping("/mcomments/{mdataTag}")
    public String comments(@PathVariable Integer mdataTag, Model model){
        model.addAttribute("mcomments",mcommentService.listMcommentByMusicTag(mdataTag));
        return "MusicResource::commentList";
    }


    @PostMapping("/mcomments")
    public String post(Mcomment mcomment){

        Integer musicTag=mcomment.getMdata().getTag();
        mcomment.setMdata(mdataService.getMdata(musicTag));
        mcomment.setAvatar(avatar);
        mcommentService.saveMcomment(mcomment);
        return "redirect:/mcomments/"+ musicTag;
    }

}
