package com.syndicat.syndicats.services;


import com.syndicat.syndicats.Repository.RoleRepository;
import com.syndicat.syndicats.Repository.UserRepository;
import com.syndicat.syndicats.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.syndicat.syndicats.entity.Role;

import java.util.Set;

@Service
public class UserService {
    public UserRepository userRepository;
    public RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserService() {

    }

    public UserService(UserRepository userRepository, RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void saveWithUserRole(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles((Set<Role>) roleRepository.findByRole("ROLE_USER"));
        userRepository.save(user);    }


     public void saveUserWithAdminRole(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles((Set<Role>) roleRepository.findByRole("ROLE_ADMIN"));
        userRepository.save(user);

     }
     public User findByLogin(String login){
        return userRepository.findByLogin(login);

     }
}
