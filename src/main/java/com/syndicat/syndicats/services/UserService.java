package com.syndicat.syndicats.services;


import com.syndicat.syndicats.Repository.RoleRepository;
import com.syndicat.syndicats.Repository.UserRepository;
import com.syndicat.syndicats.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.syndicat.syndicats.entity.Role;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserService(UserRepository userRepository,RoleRepository roleRepository ,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // add user role
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByRole("ROLE_USER"));
        userRepository.save(user);
    }

    public void updateWithUserRole(User user) {
        user.setRoles(roleRepository.findByRole("ROLE_USER"));
        userRepository.save(user);
    }

    // add admin role
    public void saveUserWithAdminRole(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByRole("ROLE_ADMIN"));
        userRepository.save(user);

     }
    public void updateUserWithAdminRole(User user) {
        user.setRoles(roleRepository.findByRole("ROLE_ADMIN"));
        userRepository.save(user);
    }

    public User findByLogin(String login){
        return userRepository.findByLogin(login);

    }

    public void updateUserDate(Long id, User user) {
        user.setUpdated_at(new Date());
        userRepository.save(user);
    }

    public List<User> all(){
        return (List<User>) userRepository.findAll();
    }



}
