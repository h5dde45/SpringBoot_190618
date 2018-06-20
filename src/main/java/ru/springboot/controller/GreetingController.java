package ru.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.springboot.domain.Message;
import ru.springboot.repositories.MessageRepository;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "новый user...") String name,
                           Model model) {
        model.addAttribute("greeting", "Hi " + name);
        return "greeting";
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("messages", messageRepository.findAll());
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text,
                      @RequestParam String tag,
                      Model model) {
        Message message = new Message(text, tag);
        messageRepository.save(message);
        model.addAttribute("messages", messageRepository.findAll());
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam(name = "filter") String filter,
                         Model model) {
        if (filter != null && !filter.isEmpty()) {
            model.addAttribute("messages",
                    messageRepository.findByTag(filter));
        } else {
            model.addAttribute("messages",
                    messageRepository.findAll());
        }
        return "main";
    }
}
