package com.eg.sysmanage.controller;

import com.eg.api.domain.Response;
import com.eg.api.request.QueryStaffRequest;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@RestController
@RequestMapping("/login")
public class LoginController {

//    private  static  final  String REST_URL_PREFIX="http://localhost:8081";
    //微服务访问
    private  static  final  String REST_URL_PREFIX="http://PA-SYSMANAGE-CENTER";

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


}
