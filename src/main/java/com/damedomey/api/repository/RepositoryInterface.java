package com.damedomey.api.repository;

import java.util.List;

public interface RepositoryInterface<Model> {
    List<Model> findAll();
    Model findById(int id);
    Model persist(Model user);
    Model persist(Model user, int id);
}
