package com.syndicat.syndicats.controllers;

import com.syndicat.syndicats.dao.UserRepository;
import com.syndicat.syndicats.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addProduit(Model model){
       model.addAttribute("user",new User());
        return "addUser";
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Model model,@Valid User user){

        userRepository.save(user);
        model.addAttribute("users" ,userRepository.findById(user.getId()));
        return "Confirmation";
    }

    @RequestMapping(value="/")
    public String home(){

        return "index";
    }
}
