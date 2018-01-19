package com.app.controller;

import com.app.model.Direction;
import com.app.model.User;
import com.app.service.DirectionService;
import com.app.service.DirectionServiceImpl;
import com.app.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@Log4j2
@RequestMapping("/dziennik")
public class RecrutationController {


    @Autowired
    private UserService userService;

    @Autowired
    private DirectionService directionService;

    @GetMapping("/addPhoto")
    public String getAddPhotoForm(Model model) {
        model.addAttribute("photo", new User());
        return "addPhotoForm";
    }

    @PostMapping("/addPhoto")
    public String postAddPhotoForm(@ModelAttribute("user") User user, Principal principal) {
        if (user.getPhotoName().isEmpty()) {
            return "redirect:/dziennik/addPhoto/?photoEmpty";
        }
        userService.changePhoto(user.getPhotoName(), principal.getName());
        return "redirect:/dziennik/mojeKonto";
    }

    @GetMapping("/directions")
    public String getDirections(Model model) {
        model.addAttribute("direction", directionService.findAll());
        return "directions";
    }

    @GetMapping("/kierunek/{id}")
    public String saveOnDirection(@PathVariable long id, Principal principal) {
        userService.saveDirectionToUser(id, principal.getName());

        return "redirect:/dziennik/mojeKonto/?directionOk";
    }


}
