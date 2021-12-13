package io.github.bharatmane.hexagonalthis.domain.port;

import io.github.bharatmane.hexagonalthis.domain.model.User;

import java.util.List;

public interface RequestUser {
    List<User> getAllUsers();
    User getUserById(int userId);
    void addUser(User user);
    void updateUser(User user);
    void deleteUserById(int userId);
}
