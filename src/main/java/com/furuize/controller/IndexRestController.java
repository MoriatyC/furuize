package com.furuize.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*@author: Menghui Chen
*@version: 2018年4月23日下午8:25:50
**/

@RestController
public class IndexRestController {
    @GetMapping("/read")
    public String read(Model model) {
        Path path = Paths.get("home", "cmh", "dataset", "data.json");
//        Path path = Paths.get("d:","data.json");
        String json = null;
        try {
            byte[] bytes = Files.readAllBytes(path);
            json = new String(bytes, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
