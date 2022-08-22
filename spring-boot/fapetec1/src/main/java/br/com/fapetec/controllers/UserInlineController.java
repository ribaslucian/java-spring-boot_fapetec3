package br.com.fapetec.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fapetec.models.User;

@RestController
@RequestMapping("/usersInline")
public class UserInlineController {

    private List<User> users = new ArrayList<>();

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/get")
    public User get() {
        User u = new User(1L, "Lucian", "ribaslucian");
        return u;
    }

    @PostMapping("/create")
    public User create(@RequestBody User u) {
        users.add(u);
        return u;
    }

    @GetMapping("/list")
    public List<User> list() {
        return users;
    }

    @PatchMapping("/search/{id}")
    public User search(@PathVariable("id") Long id) {
        Optional<User> u = users.stream().filter(user -> user.getId() == id).findFirst();

        if (u.isPresent()) {
            return u.get();
        }

        return null;
    }
}
