package com.alan.hrsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// 必须导入正确的 ModelAndView 包
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @RequestMapping("test")
    public ModelAndView test() {
        ModelAndView mv=new ModelAndView("test");
        return mv;
    }
}
