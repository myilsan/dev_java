package com.dev.dev;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Controller
public class BasicController<CompanySignupRes> {


    @GetMapping("/apiTest")
    @ResponseBody

    public String date(Model model) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return "오늘 날짜 : "+ ZonedDateTime.now().format(formatter);

    }

    @PostMapping("/signup")
    @ResponseBody
    @Tag(name = "Response Estimate", description = "Response Estimate API")
    @Operation(summary = "업체 회원가입", description = "업체 측에서 회원가입 할 때 사용하는 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "1000", description = "요청에 성공하였습니다.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "2002", description = "이미 가입된 계정입니다.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4000", description = "데이터베이스 연결에 실패하였습니다.", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "4011", description = "비밀번호 암호화에 실패하였습니다.", content = @Content(mediaType = "application/json"))

    })
    @Parameters({
            @Parameter(name = "email", description = "이메일", example = "chrome123@naver.com"),
            @Parameter(name = "password", description = "6자~12자 이내", example = "abcd1234"),
            @Parameter(name = "companyName", description = "업체명", example = "코리아 시스템"),
            @Parameter(name = "companyNumber", description = "업체 번호", example = "112233"),
            @Parameter(name = "companyAddress", description = "업체 주소", example = "인천시 미추홀구 용현동")
    })
    public String signUp(Model model) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String nowDate = ZonedDateTime.now().format(formatter);

            model.addAttribute("email","myilsan@cj.net");
            model.addAttribute("password","1111");
            model.addAttribute("companyName"," CGV");
            model.addAttribute("companyNumber","AF21014");
            model.addAttribute("companyAddress","경기도 고양시 일산서구 원일로");
            model.addAttribute("nowDate",nowDate);

            ObjectMapper objectMapper = new ObjectMapper();

            return objectMapper.writeValueAsString(model);

        } catch (Exception ex) {
            //return ex.printStackTrace();
        }
        return "";
    }


    @GetMapping("/")
    String hello2(Model model) {

        model.addAttribute("data", "index~~");
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
        model.addAttribute("items", Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4"));
        return "start_page.html";
    }






    @GetMapping("/HelloApi")
    @ResponseBody
    public helloClass HelloApi(@RequestParam("name") String name, @RequestParam("age") String age)
    {
        helloClass test = new helloClass();
        test.setName(name);
        test.setAge(age);
        return test;

    }
    @Getter
    @Setter
    static class helloClass {
        private String name;
        private String age;

    }

}
