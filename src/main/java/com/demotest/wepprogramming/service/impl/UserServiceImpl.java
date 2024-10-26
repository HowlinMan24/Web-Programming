package com.demotest.wepprogramming.service.impl;

import com.demotest.wepprogramming.model.User;
import com.demotest.wepprogramming.model.exceptions.InvalidArgumentsException;
import com.demotest.wepprogramming.model.exceptions.InvalidListOfUsersException;
import com.demotest.wepprogramming.model.exceptions.InvalidUserException;
import com.demotest.wepprogramming.model.exceptions.PasswordsDoNotMatchException;
import com.demotest.wepprogramming.repository.InMemoryUserRepository;
import com.demotest.wepprogramming.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final InMemoryUserRepository userRepository;

    public UserServiceImpl(InMemoryUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return this.userRepository.findAll().orElseThrow(InvalidListOfUsersException::new);
    }

    @Override
    public User findUserByUsername(String username) {
        return this.userRepository.findByUsername(username).orElseThrow(InvalidUserException::new);
    }

    @Override
    public User createUser(String username, String password, String name, String surname) {
        if(username.isEmpty() || password.isEmpty() || name.isEmpty() || surname.isEmpty())
            throw new InvalidArgumentsException();
        User user = new User(username, password, name, surname);
        return this.userRepository.saveOrUpdate(user);
    }

    @Override
    public User updateUser(String username, String password, String name, String surname) {
        if(username.isEmpty() || password.isEmpty() || name.isEmpty() || surname.isEmpty())
            throw new InvalidArgumentsException();
        User user = new User(username,password,name,surname);
        return this.userRepository.saveOrUpdate(user);
    }

    @Override
    public void deleteUser(String username, String password) {
        if(username.isEmpty() || password.isEmpty())
            throw new InvalidArgumentsException();
        this.userRepository.delete(this.findUserByUsername(username));
    }

    @Override
    public User login(String username, String password) {
        if(username.isEmpty() || password.isEmpty())
            throw new InvalidArgumentsException();
        return this.userRepository.findByUsernameAndPassword(username,password).orElseThrow(InvalidUserException::new);
    }

    @Override
    public User register(String username, String password, String confirmPassword, String name, String surname) {
        if(username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || name.isEmpty() || surname.isEmpty())
            throw new InvalidArgumentsException();
        if(!password.equals(confirmPassword))
            throw new PasswordsDoNotMatchException();
        User user = new User(username,password,name,surname);
        return this.userRepository.saveOrUpdate(user);
    }
}
