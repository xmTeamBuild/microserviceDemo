package com.eg.sysmanage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.eg.api.domain.Response;
import com.eg.common.constants.Constants;
import com.eg.sysmanage.model.GnMenu;
import com.eg.sysmanage.model.Staff;
import com.eg.sysmanage.service.IGnMenuService;
import com.eg.sysmanage.service.IStaffService;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shenzq
 * @since 2020-08-06
 */
@RestController
@RequestMapping("/api/v1/gnMenu")
public class GnMenuController {

    @Autowired
    private IGnMenuService iGnMenuService ;
    /**
     * 初始化查询菜单
     * @param rep
     * @param req
     * @param principal
     * @return
     */
    @GetMapping(value = "/initMenuList")
    public Response initMenuList(HttpServletResponse rep, HttpServletRequest req, Principal principal) {
        Response response = new Response(false, Constants.BUSI_FAILURE_CODE,Constants.BUSI_FAILURE_MESSAGE);
        QueryWrapper<GnMenu> wrapper = new QueryWrapper<GnMenu>();
        List<GnMenu> menuList = iGnMenuService.list(wrapper);
        if(!CollectionUtils.isEmpty(menuList)){
            // 如果存在员工信息，则登录成功
            response.setSuccess(true);
            response.setResultCode(Constants.BUSI_SUCCESS_CODE);
            response.setResultMessage(Constants.BUSI_SUCCESS_MESSAGE);
            response.setResult(menuList);
        }
        return response;
    }
}

