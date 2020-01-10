package com.dlsp.controller;

import com.dlsp.config.FileUploadProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/totest")
    @ResponseBody
    public String totest(){

        return "hello tri-orange";
    }

    @RequestMapping("/toindex")
    public String toindex(){

        return "index";
    }

}
