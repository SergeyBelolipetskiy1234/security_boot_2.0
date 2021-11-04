package com.example.securityboot3.dao;


import com.example.securityboot3.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> index() {
        return entityManager.createQuery("select distinct u from User u join fetch u.roles r", User.class).getResultList();
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("delete from User u  where u.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public User getUserByName(String username) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u join fetch u.roles r where u.username=:username",
                User.class).setParameter("username", username);
        return query.getSingleResult();
    }
}
