package com.app.controller;

import com.app.model.PasswordGenerator;
import com.app.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.Date;

@Controller
@Log4j2
public class HomeController {

    @GetMapping("/")
    public String GetHomePage() {
        return "home";
    }

}
