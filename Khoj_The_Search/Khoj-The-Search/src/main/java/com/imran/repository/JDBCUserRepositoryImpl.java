package com.imran.repository;

import com.imran.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class JDBCUserRepositoryImpl implements UserRepository{
    private List<User> USERS = new ArrayList<>();
    @Override
    public void save(User user) {
        USERS.add(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return USERS.stream()
                .filter(user -> Objects.equals(user.getUsername(), username))
                .findFirst();
    }
}
