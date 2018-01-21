package com.app.controller;

import com.app.model.Country;
import com.app.model.RecrutationDays;
import com.app.model.User;
import com.app.service.CountryService;
import com.app.service.DirectionService;
import com.app.service.RecrutationDaysService;
import com.app.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@Log4j2
@RequestMapping("/dziennik")
public class RecrutationController {


    @Autowired
    private UserService userService;

    @Autowired
    private DirectionService directionService;

    @Autowired
    private RecrutationDaysService recrutationDaysService;


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
    public String getDirections(Model model, Principal principal) {
        model.addAttribute("direction", directionService.findAll());
        model.addAttribute("users", userService.findUserByPesel(principal.getName()));
        model.addAttribute("dni", recrutationDaysService.getDaysOfRecrutation());
        log.info("Dni " + recrutationDaysService.getDaysOfRecrutation());
        return "directions";
    }

    @GetMapping("/kierunek/{id}")
    public String saveOnDirection(@PathVariable long id, Principal principal) {
        userService.saveDirectionToUser(id, principal.getName());

        return "redirect:/dziennik/mojeKonto/?directionOk";
    }

    @GetMapping("/deleteDirection")
    public String deleteUserDirection(Principal principal) {
        userService.deleteUserDirection(principal.getName());
        return "redirect:/dziennik/mojeKonto/?deleteUserDirection";
    }

    @GetMapping("/edycjaKonta/{id}")
    public String editUser(@PathVariable("id") User user, Model model) {
        model.addAttribute("user", user);
        return "editRegistrationForm";
    }

    @PostMapping("/edycjaKonta/{id}")
    public String postEdit(Principal principal, @ModelAttribute("user") User user) {
        User findUser = userService.findUserByPesel(principal.getName());
        findUser.setName(user.getName());
        findUser.setSurname(user.getSurname());
        findUser.setDateOfBirth(user.getDateOfBirth());
        findUser.setEmail(user.getEmail());
        findUser.setUlica(user.getUlica());
        findUser.setCountry(user.getCountry());
        findUser.setMiejscowosc(user.getMiejscowosc());
        findUser.setPhoneNumber(user.getPhoneNumber());
        findUser.setNrDomu(user.getNrDomu());
        findUser.setPhotoName(user.getPhotoName());
        userService.editForm(findUser);
        return "redirect:/dziennik/mojeKonto";
    }

    @Secured("ADMIN")
    @GetMapping("/setRecrutationDays")
    public String setRecrutationDays(Model model) {
        model.addAttribute("data", new RecrutationDays());
        return "setDataRecrutation";
    }

    @Secured("ADMIN")
    @PostMapping("/setRecrutationDays")
    public String postSetRecrutationDays(@ModelAttribute("RecrutationDays") RecrutationDays recrutationDays) {
        recrutationDaysService.saveDateRecutation(recrutationDays);
        return "redirect:/dziennik/mojeKonto";
    }

    @GetMapping("/addMaturaPhoto")
    public String getMaturaSkan(Model model) {
        model.addAttribute("maturaPhoto", new User());
        return "addMaturaPhotoForm";
    }

    @PostMapping("/addMaturaPhoto")
    public String getMaturaSkan(@ModelAttribute("user") User user, Principal principal) {
        if (user.getMaturaPhoto().isEmpty()) {
            return "redirect:/dziennik/addMaturaPhoto/?emptyPhoto";
        }
        userService.changeMaturaPhoto(user.getMaturaPhoto(), principal.getName());
        return "redirect:/dziennik/mojeKonto";
    }

    @GetMapping("/allRegistred")
    public String getRegistredUsers(Model model) {
        model.addAttribute("users", userService.getAllUsersRegistrated());
        return "redistrated";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUserWithDirection(@PathVariable long id) {
        userService.deleteUserWithDirection(id);
        return "redirect:/dziennik/allRegistred";
    }



}
