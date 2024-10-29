package com.demotest.wepprogramming.service.impl;

import com.demotest.wepprogramming.model.User;
import com.demotest.wepprogramming.model.exceptions.InvalidArgumentsException;
import com.demotest.wepprogramming.model.exceptions.InvalidUserException;
import com.demotest.wepprogramming.model.exceptions.PasswordsDoNotMatchException;
import com.demotest.wepprogramming.repository.InMemoryUserRepository;
import com.demotest.wepprogramming.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final InMemoryUserRepository userRepository;

    public AuthServiceImpl(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        return this.userRepository.findByUsernameAndPassword(username, password).orElseThrow(InvalidUserException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if (username == null || password == null || repeatPassword == null || name == null || surname == null) {
            throw new InvalidArgumentsException();
        }
        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }
        return this.userRepository.saveOrUpdate(new User(username, password, name, surname));
    }
}