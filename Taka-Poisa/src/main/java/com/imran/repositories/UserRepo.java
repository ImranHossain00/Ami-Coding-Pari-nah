package com.imran.repositories;

import com.imran.domain.User;
import com.imran.exceptions.UserNotFoundException;

import java.sql.SQLException;
import java.util.Optional;

// This interface handles the crud operations with the user table
public interface UserRepo {
    void insertUser(User user);
    User findByEmail(String email);
}
