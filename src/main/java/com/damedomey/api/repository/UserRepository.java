package com.damedomey.api.repository;

import com.damedomey.api.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRepository implements RepositoryInterface<User> {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        return new User(id);
    }

    @Override
    public User persist(User user) {
        return persist(user, 0);
    }

    @Override
    public User persist(User user, int id) {
        return null;
    }
}
