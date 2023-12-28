package com.imran.repositories;

import com.imran.domain.User;

// This interface handles the crud operations with the user table
public interface UserRepo {
    void insertUser(User user);
}
