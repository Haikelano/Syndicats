package com.syndicat.syndicats.web;

import com.syndicat.syndicats.Repository.UserRepository;
import com.syndicat.syndicats.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestService {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> getUsers() {

        return userRepository.findAll();
    }

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public User save(@RequestBody User u) {

        return userRepository.save(u);
    }

}
