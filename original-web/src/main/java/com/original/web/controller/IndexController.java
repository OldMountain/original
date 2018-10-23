package com.original.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * IndexController
 *
 * @author luhangqi
 * @date 2018/10/23
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/console")
    public String console() {
        return "view/console";
    }
    @RequestMapping("/homePage1")
    public String homePage1() {
        return "view/homePage1";
    }
}
