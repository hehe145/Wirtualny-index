package com.app.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dziennik")
@Log4j2
public class HomeController {

    @GetMapping("/")
    public String GetHomePage() {
        return "home";
    }

}
