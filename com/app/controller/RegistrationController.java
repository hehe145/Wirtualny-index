package com.app.controller;

import com.app.model.Country;
import com.app.model.User;
import com.app.service.CountryService;
import com.app.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@Log4j2
@RequestMapping("/dziennik")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));

    }

    @Autowired
    private CountryService countryService;

    @ModelAttribute("country")
    public List<Country> getAllCountry() {
        List<Country> countryList = countryService.getAllCountry();
        return countryList;
    }

    @GetMapping("/reg")
    public String getRegistrationForm(Model model) {
        model.addAttribute(new User());
        return "registrationForm";
    }

    @PostMapping("/reg")
    public String posRegistrationForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info(bindingResult);
            return "registrationForm";
        }
        userService.save(user);
        return "redirect:/?reg";
    }

    @GetMapping("/password")
    public String changePassword(Model model) {
        model.addAttribute("user", new User());
        return "password";
    }

    @PostMapping("/password")
    public String postChangePassword(@ModelAttribute("user") User user) {
        userService.sendNewPassword(user);
        return "redirect:/login?newPassword";
    }

    @GetMapping("/haslo")
    public String changePasswordInSystem(Model model) {
        model.addAttribute("user", new User());
        return "newPassword";
    }

    @PostMapping("/haslo")
    public String postPasswordChange(@ModelAttribute("user") User user, Principal principal) {
        userService.changePassword(user, principal.getName());
        return "redirect:/dziennik/mojeKonto";
    }


}
