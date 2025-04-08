package com.example.Service;

import com.example.Entity.Account;
import com.example.Entity.User;
import com.example.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class UserService {
    private UserRepository userRepository;

    public User createAccount(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUser(Long id){
        return userRepository.findById(id);
    }

}
