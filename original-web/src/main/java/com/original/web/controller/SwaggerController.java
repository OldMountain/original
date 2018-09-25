package com.original.web.controller;

import com.original.bean.entity.User;
import com.original.service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.Produces;
import java.util.List;

/**
 * SwaggerController
 *
 * @author luhangqi
 * @date 2018/9/25
 */
@Api(value = "swagger",description = "demo")
@Controller
@RequestMapping("/swagger")
public class SwaggerController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "测试")
    @RequestMapping(value = "/test",produces = "application/json",method = RequestMethod.POST)
    public String test(@ApiParam(value = "66",required = true)@RequestParam String ss){
        List<User> list = userService.list();
        return list.toString();
    }
}
