package com.example.ch9_applicationscope.controllers;

import com.example.ch9_applicationscope.services.LoginValidationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    LoginValidationService loginValidation;

    public LoginController(LoginValidationService loginValidation) {
        this.loginValidation = loginValidation;
    }

    @GetMapping("/")
    public String login(){
        return "login.html";
    }

    @PostMapping("/")
    public String login(@RequestParam String username, @RequestParam String password, Model m){
        boolean accepted = loginValidation.isUserAuthorized(username, password);
        if(accepted){
            return "redirect:/userpage";
        }else{
            m.addAttribute("message", "Invalid credentials");
        }
        return "login.html";
    }

    @GetMapping("/userpage")
    public String userpage(Model m){
        m.addAttribute("username", loginValidation.getLoggedUser());
        return "userpage.html";
    }

}
