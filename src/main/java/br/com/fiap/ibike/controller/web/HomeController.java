package br.com.fiap.ibike.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home() {
        return "home"; // retorna home.html
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // retorna login.html
    }
}
