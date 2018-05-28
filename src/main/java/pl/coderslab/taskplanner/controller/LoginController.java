package pl.coderslab.taskplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/welcome")
    public String homepage(){
        return "homepage";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout){

        if(error != null){
            model.addAttribute("errorMsg", "Your username or password are invalid :-(");
        }

        if(logout != null) {
            model.addAttribute("msg", "You have been logged out successfully :-) ");
        }

        return "login";
    }

}
