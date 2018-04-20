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
import java.security.Principal;

@Controller
public class UserController {
    @Autowired
private UserRepository userRepository;
    private UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {

        this.userRepository = userRepository;
        this.userService = userService;
    }


    // This page loads on successful login.
    @RequestMapping(value = "/")
    public String home(Principal principal, Model model) {

        String username = principal.getName();
        User user = userService.findByLogin(username); // find user by email
        userService.updateUserDate(user.getId(), user); // set updated_at

        model.addAttribute("currentUser", user);
        model.addAttribute("users", userService.all());

        // if admin, return adminPage
        if (user.checkIfAdmin()) {
            return "index";
        }

        // if not, return dashboard
        return "index";

    }



    @RequestMapping("/login")
    public String loginReg(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid credentials. Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful");
        }
        return "login";
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

}
