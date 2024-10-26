package com.demotest.wepprogramming.service;

import com.demotest.wepprogramming.model.User;

import java.util.List;

public interface UserService {
    public List<User> findAllUsers();
    public User findUserByUsername(String username);
    public User createUser(String username,String password,String name, String surname);
    public User updateUser(String username,String password,String name, String surname);
    public void deleteUser(String username, String password);
    public User login(String username, String password);
    public User register(String username, String password, String confirmPassword, String name, String surname);
}
