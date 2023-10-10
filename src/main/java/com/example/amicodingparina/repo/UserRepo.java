package com.example.amicodingparina.repo;

import com.example.amicodingparina.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {

}
