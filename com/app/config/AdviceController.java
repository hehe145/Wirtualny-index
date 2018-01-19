package com.app.config;


import com.app.controller.exception.BadPassword;
import com.app.controller.exception.BadUser;
import com.app.controller.exception.YouSaved;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class AdviceController {

    @ExceptionHandler(BadPassword.class)
    public String badBassword() {
        return "redirect:/dziennik/reg/?badPassword";
    }

    @ExceptionHandler(BadUser.class)
    public String userException() {
        return "redirect:/dziennik/password/?badUser";
    }

    @ExceptionHandler(YouSaved.class)
    public String youSaved() {
        return "redirect:/dziennik/mojeKonto/?saved";
    }



}
