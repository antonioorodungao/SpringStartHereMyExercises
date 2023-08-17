package com.example.ch9_sessionscope.controllers;

import com.example.ch9_sessionscope.service.SessionToken;
import com.example.ch9_sessionscope.service.UserValidator;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    public LoginController(UserValidator userValidator, SessionToken sessionToken) {
        this.userValidator = userValidator;
        this.sessionToken = sessionToken;
    }

    UserValidator userValidator;
    SessionToken sessionToken;
//    HttpServletRequest request;

    @PostMapping("/")
    public String login(@RequestParam(required = true) String username, @RequestParam(required = true) String password, Model model){
        if(username.isEmpty() || password.isEmpty()){
            return "login.html";
        }
        logger.info(String.format("Username: %s Password: %s SessionID %s", username, password, sessionToken.getIdentity()));
        sessionToken.setUsername(username);
        sessionToken.setPassword(password);
        sessionToken.setUserValid(userValidator.isUserValid(username, password));
        if(sessionToken.getUserValid()) {


            return "redirect:/ok";
        }else{
            //TODO: Learn how to invalidate session.
//            request.getSession().invalidate();
            return "login.html";
        }
    }

    @GetMapping("/")
    public String login(Model m){
        m.addAttribute("message", "Kindly enter the username and password");
        logger.info("Inside the GET of login method.");
        return "login.html";
    }

    @GetMapping("/ok")
    public String ok(){
        return "ok.html";
    }


}
