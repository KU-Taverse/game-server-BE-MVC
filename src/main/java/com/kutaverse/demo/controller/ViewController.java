package com.kutaverse.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping
    public String viewHome(){
        return "index";
    }
}
