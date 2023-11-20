package com.imran.service;

import com.imran.domain.User;
import com.imran.dto.UserDTO;
import com.imran.repository.UserRepository;

public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    // In this method we're building the logic that
    // how a new user will be stored in our database.
    @Override
    public void saveUser(UserDTO userDTO) {
        String encrypted = encryptPassword(userDTO.getPassword());
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(encrypted);

        userRepository.save(user);
    }

    private String encryptPassword(String password) {

    }
}
