package com.eg.sysmanage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eg.api.domain.Response;
import com.eg.common.constants.Constants;
import com.eg.sysmanage.model.Staff;
import com.eg.sysmanage.service.IStaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shenzq
 * @since 2020-07-15
 */
@RestController
@RequestMapping("/staff")
public class StaffController {
    private static final Logger logger = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    private IStaffService iStaffService ;

    @Autowired
    private DiscoveryClient client;

    @PostMapping(value = "/login")
    public Response login(HttpServletResponse rep, HttpServletRequest req, @RequestBody Staff staff, Principal principal) {
        Response response = new Response(false, Constants.BUSI_FAILURE_CODE,Constants.BUSI_FAILURE_MESSAGE);
        QueryWrapper<Staff> wrapper = new QueryWrapper<Staff>();
        Staff staff1 = iStaffService.getOne(wrapper);
        if(staff1 != null){
            // 如果存在员工信息，则登录成功
            String token = "123";
            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("token", token);
            response.setSuccess(true);
            response.setResultCode(Constants.BUSI_SUCCESS_CODE);
            response.setResultMessage(Constants.BUSI_SUCCESS_MESSAGE);
            response.setResult(tokenMap);
        }
        return response;
    }


    @GetMapping(value = "/list")
    public Response getList(HttpServletResponse rep, HttpServletRequest req, Principal principal) {
        Response response = new Response(false, Constants.BUSI_FAILURE_CODE,Constants.BUSI_FAILURE_MESSAGE);
        QueryWrapper<Staff> wrapper = new QueryWrapper<Staff>();
        Staff staff1 = iStaffService.getOne(wrapper);
        if(staff1 != null){
            // 如果存在员工信息，则登录成功
            String token = "123";
            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("token", token);
            response.setSuccess(true);
            response.setResultCode(Constants.BUSI_SUCCESS_CODE);
            response.setResultMessage(Constants.BUSI_SUCCESS_MESSAGE);
            response.setResult(tokenMap);
        }
        return response;
    }

    @GetMapping(value = "/testDocker")
    public String testDocker(HttpServletResponse rep, HttpServletRequest req, Principal principal) {
        return "Hello Docker World";
    }

    @GetMapping(value="/discovery")
    public Object discovery(){
        List<String> list = client.getServices();
        System.out.println("***"+list);

        List<ServiceInstance> serviceInstanceList = client.getInstances("PA-SYSMANAGE-CENTER");
        for(ServiceInstance instance : serviceInstanceList){
            System.out.println(instance.getServiceId() +"\t"
                    +instance.getHost() +"\t"+instance.getPort() +"\t"
            +instance.getUri());
        }
        return this.client;
    }
}

