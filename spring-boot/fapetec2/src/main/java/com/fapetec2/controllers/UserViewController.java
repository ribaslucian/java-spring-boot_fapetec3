package com.fapetec2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @RequestMapping("/users")
public class UserViewController {

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
