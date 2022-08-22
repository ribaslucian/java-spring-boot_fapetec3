package br.com.fapetec3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {

    @GetMapping("/users/list")
    public String list() {
        return "users/list.html";
    }

    @GetMapping("/users/create")
    public String create() {
        // return "users/create.html";
        return "redirect:/users/list";
    }
}
