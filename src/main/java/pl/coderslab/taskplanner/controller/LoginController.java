package pl.coderslab.taskplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        return "Hello";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
