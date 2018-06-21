package ru.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.springboot.domain.Message;
import ru.springboot.repositories.MessageRepository;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> map) {
        Iterable<Message> messages = messageRepository.findAll();
        map.put("messages", messages);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text,
                      @RequestParam String tag,
                      Map<String, Object> map) {
        Message message = new Message(text, tag);
        messageRepository.save(message);
        map.put("messages", messageRepository.findAll());
        return "main";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam(name = "filter") String filter,
                         Map<String, Object> map) {
        if (filter != null && !filter.isEmpty()) {
            map.put("messages",
                    messageRepository.findByTag(filter));
        } else {
            map.put("messages", messageRepository.findAll());
        }
        return "main";
    }
}
