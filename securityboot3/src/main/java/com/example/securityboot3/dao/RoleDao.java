package com.example.securityboot3.dao;

import com.example.securityboot3.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getRoles();
    void save(Role role);
    void update(Role role);
    void delete(int id);
    Role getRoleByName(String name);
}

