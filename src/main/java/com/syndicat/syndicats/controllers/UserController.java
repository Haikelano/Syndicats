package com.syndicat.syndicats.controllers;

import com.syndicat.syndicats.Repository.UserRepository;
import com.syndicat.syndicats.entity.User;
import com.syndicat.syndicats.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import com.syndicat.syndicats.entity.User;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
private UserRepository userRepository;
    private UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {

        this.userRepository = userRepository;
        this.userService = userService;
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
    @RequestMapping("/registration")
    public String registerForm(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {

        return "registration";
    }
    @PostMapping("/registration")
    public  String registration(@Valid @ModelAttribute("user") User user , Model model){

        userService.saveWithUserRole(user);

        return "login";
    }
    @RequestMapping("login")
    public  String loginFom(@Valid @ModelAttribute("user") User user){

        return "login";
    }
}
