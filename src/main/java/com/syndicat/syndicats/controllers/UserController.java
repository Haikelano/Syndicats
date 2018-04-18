package com.syndicat.syndicats.controllers;

import com.syndicat.syndicats.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class UserController {
    @Autowired
private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/user_list")
    public String getUser(Model model) {

        model.addAttribute("user", userRepository.findAll());
        return "user_list";
    }
}
