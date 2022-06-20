package com.slabstech.revive.server.dropwizard.db;

import com.slabstech.revive.server.dropwizard.core.User;
import io.dropwizard.hibernate.AbstractDAO;

import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class UserDAO extends AbstractDAO<User> {
    public UserDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public User create(User user) {
        return persist(user);
    }

    public List<User> findAll() {
        return list(namedTypedQuery("com.slabstech.revive.server.dropwizard.core.User.findAll"));
    }
}