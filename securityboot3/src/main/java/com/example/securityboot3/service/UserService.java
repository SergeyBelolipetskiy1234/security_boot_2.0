package com.example.securityboot3.service;


import com.example.securityboot3.model.User;

import java.util.List;

public interface UserService {
    public List<User> index();
    public User show(int id);
    public void save(User user);
    public void update(int id, User user);
    public void delete(int id);
    User getUserByName(String username);
}
