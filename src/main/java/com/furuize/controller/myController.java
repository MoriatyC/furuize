package com.furuize.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
*@author: Menghui Chen
*@version: 2018年4月19日下午4:43:33
**/

@Controller

public class myController {
    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }
    @GetMapping("/prediction")
    public String prediction(Model model) {
        return "prediction";
    }
    

}
