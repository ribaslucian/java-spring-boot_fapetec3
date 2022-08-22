package br.com.fapetec3.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fapetec3.models.User;
import br.com.fapetec3.repositories.UserRepository;

@RestController
@RequestMapping("/apiV1/users")
public class ApiV1UsersController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> list() {
        return userRepository.findAll();
    }

    @PostMapping("/")
    public User create(@RequestBody User u) {
        return userRepository.save(u);
    }

    @GetMapping("/{id}")
    public User search(@PathVariable("id") Long id) {
        Optional<User> u = userRepository.findById(id);

        if (u.isPresent())
            return u.get();

        return null;
    }

    @GetMapping("/findAllMoreThan/{id}")
    public List<User> findMoreThan(@PathVariable("id") Long id) {
        return userRepository.findByIdGreaterThan(id);
    }

    @PutMapping("/{id}")
    public User edit(@RequestBody User u, @PathVariable("id") Long id) {
        return userRepository.save(u);
    }

}
