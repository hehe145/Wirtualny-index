package com.app.controller;

import com.app.model.User;
import com.app.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;

@Log4j2
@Controller
@RequestMapping("/dziennik")
public class MyAccountController {

    @Autowired
    private UserService userService;

    @GetMapping("/mojeKonto")
    public String getMyAccount(Principal principal, Model model) {
        User user = userService.findUserByPesel(principal.getName());
        model.addAttribute("user", user);
        return "myAccount";
    }

}
