package com.imran.service;

import com.imran.domain.User;
import com.imran.dto.*;
import com.imran.exceptions.UserNotFoundException;

import java.sql.SQLException;
import java.util.Optional;

public interface UserService {

    // Strategy how to save signup data in the database.
    void signup(SignupDTO dto);

    // If email is present then it will return false otherwise true.
    boolean isEmailUnique(String email);

    User verifyEmailAndPassword(LoginDTO dto) throws UserNotFoundException, SQLException;
}
