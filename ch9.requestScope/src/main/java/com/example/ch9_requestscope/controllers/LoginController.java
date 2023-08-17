package com.example.ch9_requestscope.controllers;

import com.example.ch9_requestscope.services.LoginProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    LoginProcessor loginProcessor;

    @GetMapping("/")
    public String loginGet(Model m){
        m.addAttribute("message", "");
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(@RequestParam(required = true) String username, @RequestParam(required = true) String password,
                            Model m){

        loginProcessor.setPassword(password);
        loginProcessor.setUsername(username);

        boolean loggedIn = loginProcessor.isValidLogin();

        if(loggedIn) {
            m.addAttribute("message", "You are accepted.");
        }else{
            m.addAttribute("message", "Login failed");
        }

        return "login.html";
    }
}
