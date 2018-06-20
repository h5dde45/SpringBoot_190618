package ru.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping("/")
    public String main(Model model) {
        model.addAttribute("main", "new main");
        return "main";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "новый") String name,
                           Model model) {
        model.addAttribute("greeting", "hi " + name);
        return "greeting";
    }
}
