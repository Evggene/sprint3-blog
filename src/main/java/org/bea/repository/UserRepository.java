package org.bea.repository;

import org.bea.model.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    User save(User user);

    void deleteById(Long id);
}
