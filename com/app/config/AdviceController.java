package com.app.config;


import com.app.controller.exception.BadPassword;
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

    /*
    @ExceptionHandler(VehicleNotFoundException.class)
    public String getNotFound() {
        return "/errors/404";
    }

    @ExceptionHandler({DataIntegrityViolationException.class, JDBCConnectionException.class})
    public String dataException() {
        return "/errors/dbError";
    }

    @ExceptionHandler({org.springframework.beans.TypeMismatchException.class})
    public String dataBadRequest() {
        return "redirect:/?badRequest";
    }

    @ExceptionHandler(Exception.class)
    public String exception(Model model,Exception e) {
        e.printStackTrace();
        return "/errors/exception";
    }


    @ExceptionHandler(UserExist.class)
    public String userException() {
        return "redirect:/reg/?badUser";
    }




    @ExceptionHandler(BadPasswordCheck.class)
    public String badBasswordCheck() {
        return "redirect:/password/?badPassword";
    }

    @ExceptionHandler(NotUser.class)
    public String notUser() {
        return "redirect:/password/?notUser";
    }
*/

}
