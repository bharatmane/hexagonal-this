package io.github.bharatmane.hexagonalthis.domainapi.model.port;

import io.github.bharatmane.hexagonalthis.domainapi.model.User;

import java.util.List;
import java.util.Optional;

public interface RequestUser {
    List<User> getAllUsers();
    Optional<User> getUserById(int userId);
    void addUser(User user);
    void updateUser(User user);
    void deleteUserById(int userId);
}
