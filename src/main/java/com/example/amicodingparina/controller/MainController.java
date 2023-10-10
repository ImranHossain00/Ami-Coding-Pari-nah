package com.example.amicodingparina.controller;

import com.example.amicodingparina.domain.User;
import com.example.amicodingparina.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/add")
    public String addUser(@RequestParam String userName,
                          @RequestParam String password,
                          @RequestParam List<Integer> numbers) {
        User user = new User(userName, password, numbers);
        userRepo.save(user);
        return "saved";

    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> showAll() {
        return userRepo.findAll();
    }
}
