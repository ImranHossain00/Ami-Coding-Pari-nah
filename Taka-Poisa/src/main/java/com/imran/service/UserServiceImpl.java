package com.imran.service;

import com.imran.domain.User;
import com.imran.dto.*;
import com.imran.exceptions.UserNotFoundException;
import com.imran.repositories.UserRepo;
import com.imran.util.SecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    private static final Logger LOGGER
            = LoggerFactory.getLogger(UserServiceImpl.class);
    private UserRepo repository;

    public UserServiceImpl(UserRepo repository) {
        this.repository = repository;
    }

    @Override
    public void signup(SignupDTO dto) {
        var user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setLoginPassword(encryptPassword(dto.getPassword()));

        LOGGER.info("Going to repo to insert user data");
        repository.insertUser(user);
    }

    // Returns true if email is unique.
    @Override
    public boolean isEmailUnique(String email) {
        // Email is not found so email is unique.
        return repository.findByEmail(email) == null;
    }


    @Override
    public User verifyEmailAndPassword(LoginDTO dto) throws UserNotFoundException {

        return Optional.ofNullable(repository.findByEmail(dto.getEmail()))
                .filter(user -> user.getLoginPassword().equals(encryptPassword(dto.getPassword())))
                .orElseThrow(() -> new UserNotFoundException("Password/Email is incorrect"));

    }

    @Override
    public void logout(HttpServletRequest req) {
        SecurityContext.logout(req);
    }

    private String encryptPassword(String password) {
        try {
            var digest
                    = MessageDigest.getInstance("SHA-256");
            var bytes
                    = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Unable to encrypt password", e);
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();

        for (var b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
