package com.slabstech.revive.server.springboot.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

    @Value("${spring.application.name}")
    String appName;
   
    @RequestMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        
        model.addAttribute("serviceNames", "App.DB");
        
        return "home";
    }
}