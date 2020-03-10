package com.example.demo.web;

import com.example.demo.dao.ResourceRepository;
import com.example.demo.po.Basicattr;
import com.example.demo.po.Otypeattr;
import com.example.demo.po.Oprovince;
import com.example.demo.po.Resource;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author yxx
 * @create 2020-01-05 15:41
 */


@Controller
public class IndexController {

    @Autowired
    private ResourceRepository resourceRepository;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    /*
    从首页index，点击标识管理后跳转到的页面（这里调用api的login接口），待做
    */
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    //全局搜索
    @RequestMapping("/ResourceSearch")
    public String ResourchSearch(@PageableDefault(size = 5, sort = {"_id"}, direction = Sort.Direction.DESC) Pageable pageable,
                                                   @RequestParam String query, Model model){
        //System.out.println("--------执行开始--------");
        Page<Resource> page=resourceRepository.findByTitleOrContent("%"+query+"%","%"+query+"%",pageable);
        //System.out.println(page);
        model.addAttribute("page", page);
        //System.out.println("--------执行完毕--------");
        //返回输入的查询内容
        model.addAttribute("query",query);
        return "ResourceSearch";
    }







}
