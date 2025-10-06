package com.example;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute Register register, Model model) {
        model.addAttribute("user", register); 
        return "dashboard";
    }
}
