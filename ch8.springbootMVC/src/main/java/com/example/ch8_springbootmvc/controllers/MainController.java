package com.example.ch8_springbootmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("/home")
    public String home(Model m){
        m.addAttribute("color", "red");
        m.addAttribute("username", "Antonio");
        return "home.html";
    }

    @RequestMapping("/myColor")
    public String homeUsingRequestParameter(@RequestParam(required = true) String name, @RequestParam(required = true) String color,
                              Model page){
        page.addAttribute("username", name);
        page.addAttribute("color", color);
        return "home.html";

    }

    @RequestMapping("/path/{name}/{color}")
    public String homeUsingPathVariable(@PathVariable(required = true) String name, @PathVariable(required = true) String color,
                              Model page){
        page.addAttribute("username", name);
        page.addAttribute("color", color);
        return "home.html";

    }
}
