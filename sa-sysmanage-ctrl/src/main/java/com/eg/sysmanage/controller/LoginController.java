package com.eg.sysmanage.controller;

import com.alibaba.fastjson.JSON;
import com.eg.api.domain.Response;
import com.eg.api.request.QueryStaffRequest;
import com.eg.api.utils.HttpServerUtil;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
@RequestMapping("/login")
public class LoginController {

    private  static  final  String REST_URL_PREFIX="http://localhost:8002";
    //微服务访问
//    private  static  final  String REST_URL_PREFIX="http://PA-SYSMANAGE-CENTER";

    @Autowired
   private RestTemplate restTemplate ;

    @RequestMapping(value="/consumer/dept/add")
    public boolean login(){
        QueryStaffRequest request = new QueryStaffRequest() ;
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", null,Boolean.class);
//        restTemplate.postForObject()
    }

    @GetMapping(value="/getList")
    public Response getList(HttpServletResponse rep, HttpServletRequest req, Principal principal) {
        QueryStaffRequest request = new QueryStaffRequest() ;
        return restTemplate.getForObject(REST_URL_PREFIX+"/team/staff/list",Response.class);
//        restTemplate.postForObject()
    }

    @GetMapping(value="/consumer/discovery")
    public Object discovery(HttpServletResponse rep, HttpServletRequest req, Principal principal) {
        QueryStaffRequest request = new QueryStaffRequest() ;
        return restTemplate.getForObject(REST_URL_PREFIX+"/team/staff/discovery",Object.class);
//        restTemplate.postForObject()
    }

    @PostMapping(value="/loginValidate")
    public Response loginValidate(HttpServletRequest req,HttpServletResponse rep, Principal principal) {
        String reqBody = HttpServerUtil.reader(req, rep);
        QueryStaffRequest request = JSON.parseObject(reqBody, QueryStaffRequest.class);
        Response response = restTemplate.postForObject(REST_URL_PREFIX+"/team/staff/login",request,Response.class);
        return response;
    }

    @GetMapping(value="/getMenuList")
    public  Response getMenu(HttpServletResponse rep, HttpServletRequest req, Principal principal){
        QueryStaffRequest request = new QueryStaffRequest() ;
        return restTemplate.getForObject(REST_URL_PREFIX+"/team/api/v1/gnMenu/initMenuList",Response.class);
    }

}
