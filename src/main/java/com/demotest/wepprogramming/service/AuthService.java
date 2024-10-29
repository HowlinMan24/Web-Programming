package com.demotest.wepprogramming.service;

import com.demotest.wepprogramming.model.User;

public interface AuthService {
    User login(String username, String password);

    User register(String username, String password, String repeatPassword, String name, String surname);
}