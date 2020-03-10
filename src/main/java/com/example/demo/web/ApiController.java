package com.example.demo.web;


import com.alibaba.fastjson.JSONObject;
import com.example.demo.Apipo.Apilist;
import com.example.demo.HttpApiService.HttpAPIService;
import com.example.demo.util.HttpResult;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ApiController {

    @Resource
    private HttpAPIService httpAPIService;

    //保存token
    private String Authorization;


    @RequestMapping({"/list/{pageNum}"})
    public String apitest(Map<String,Object> map, Model model,@PathVariable int pageNum) throws Exception {

        //登录
        Map<String, Object> hashMap = new HashMap<>();
        //填写账号密码
        String username = "admin";
        String password = "admin2018";
        hashMap.put("username", username);
        hashMap.put("password", password);
        HttpResult result = httpAPIService.doPost("http://219.244.71.206/ziyuanapi/login", hashMap);
        JSONObject body = JSONObject.parseObject(result.getBody());
        JSONObject auth = JSONObject.parseObject(body.getString("data"));
        Authorization = auth.getString("token");
        map.put("data", result);

        System.out.println(result.getBody());
        JSONObject jsob=new JSONObject(body);
        int bodyCode=jsob.getInteger("code");
        System.out.println("-------------------");
        System.out.println("bodyCode="+bodyCode);
        System.out.println("-------------------");
        map.put("login_bodyCode",bodyCode);

        if(bodyCode==0){
        //此时登录成功
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("page", pageNum);
        jsonObject.put("limit", 20);
//        jsonObject.put("keys", "李白");

        HttpResult result1 = httpAPIService.doPostJson("http://219.244.71.206/ziyuanapi/index/list",jsonObject.toJSONString(),Authorization);
        map.put("name","SpringBoot");
        map.put("data1", result1);

        JSONObject body1 = JSONObject.parseObject(result1.getBody());
        //System.out.println(result1.getBody());
        JSONObject jsob1=new JSONObject(body1);
        int bodyCode1=jsob1.getInteger("code");
        //code为0时表示正常返回数据
        System.out.println("-------------------");
        System.out.println("bodyCode1="+bodyCode1);
        System.out.println("-------------------");
        //取出data键对应的值
        String bodyData=jsob1.getString("data");
        System.out.println(bodyData);
        Gson gson=new Gson();
        Apilist apilist=gson.fromJson(bodyData, Apilist.class);
        System.out.println(apilist);
        model.addAttribute("apilist",apilist);

        map.put("list_bodyCode",bodyCode1);
        }
        return "ApiList";
    }



}
