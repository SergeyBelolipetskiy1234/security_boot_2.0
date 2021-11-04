package com.example.securityboot3.service;

import com.example.securityboot3.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    void save(Role role);
    void update(Role role);
    void delete(int id);
    Role getRoleByName(String name);
}
