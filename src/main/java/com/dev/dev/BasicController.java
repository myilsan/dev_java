package com.dev.dev;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;


@Controller
public class BasicController {

    @GetMapping("/date")
    @ResponseBody
    String hello() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "오늘 날짜 ++ : "+ ZonedDateTime.now().format(formatter);

    }

    @GetMapping("/")
    String hello2() {
        return "index.html";
    }

    @GetMapping("hello")
    public String hello(Model model) {

        model.addAttribute("data", "hello~~");
        return "hello.html";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Hello Thymeleaf");
        model.addAttribute("items", Arrays.asList("Item 1", "Item 2", "Item 3"));
        return "start_page.html";
    }
}