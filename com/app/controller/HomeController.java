package com.app.controller;

import com.app.model.PasswordGenerator;
import com.app.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class HomeController {

    @Autowired
    private PasswordGenerator passwordGenerator;

    @GetMapping("/")
    public String GetHomePage() {
        passwordGenerator.randomString(6);
        log.info(passwordGenerator.getSb());
        return "home";
    }

}
