package com.demotest.wepprogramming.repository;

import com.demotest.wepprogramming.bootstrap.DataHolder;
import com.demotest.wepprogramming.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryUserRepository {

    /**
     * Find all the users in the in-memory db
     *
     * @return
     */
    public Optional<List<User>> findAll() {
        return Optional.of(DataHolder.users);
    }

    /**
     * Find the user from the username parameter
     *
     * @param username
     * @return
     */
    public Optional<User> findByUsername(String username) {
        return DataHolder.users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }

    /**
     * Find the user from the username and password parameters
     *
     * @param username
     * @param password
     * @return
     */
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return DataHolder.users.stream().filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password)).findFirst();
    }

    /**
     * Find the user by the name and surname from the parameters
     *
     * @param name
     * @param surname
     * @return
     */
    public Optional<User> findByNameAndSurname(String name, String surname) {
        return DataHolder.users.stream().filter(user -> user.getName().equals(name) && user.getSurname().equals(surname)).findFirst();
    }

    /**
     * Save or update the user in the in-memory db
     *
     * @param user
     * @return
     */
    public User saveOrUpdate(User user) {
        DataHolder.users.removeIf(x -> x.getUsername().equals(user.getUsername()));
        DataHolder.users.add(user);
        return user;
    }

    /**
     * Delete the user from the in-memory db
     *
     * @param user
     */
    public void delete(User user) {
        DataHolder.users.removeIf(x -> x.getUsername().equals(user.getUsername()));
    }
}