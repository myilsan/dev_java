package com.dev.dev;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@Controller
public class BasicController {

    @GetMapping("/date")
    @ResponseBody
    String hello(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "오늘 날짜3 : "+ ZonedDateTime.now().format(formatter);

    }

    @GetMapping("/")
    String hello2(){
        return "index.html";
    }
}
