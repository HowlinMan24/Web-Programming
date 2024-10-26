package com.demotest.wepprogramming.repository;

import com.demotest.wepprogramming.bootstrap.DataHolder;
import com.demotest.wepprogramming.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryUserRepository {

    public Optional<List<User>> findAll() {
        return Optional.of(DataHolder.users);
    }

    public Optional<User> findByUsername(String username) {
        return DataHolder.users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }

    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return DataHolder.users.stream().filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password)).findFirst();
    }

    public Optional<User> findByNameAndSurname(String name, String surname) {
        return DataHolder.users.stream().filter(user -> user.getName().equals(name) && user.getSurname().equals(surname)).findFirst();
    }

    public User saveOrUpdate(User user) {
        DataHolder.users.removeIf(x -> x.getUsername().equals(user.getUsername()));
        DataHolder.users.add(user);
        return user;
    }

    public void delete(User user) {
        DataHolder.users.removeIf(x -> x.getUsername().equals(user.getUsername()));
    }
}