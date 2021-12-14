package io.github.bharatmane.hexagonalthis.domain;

import io.github.bharatmane.hexagonalthis.domainapi.model.User;
import io.github.bharatmane.hexagonalthis.domainapi.model.port.ObtainUser;
import io.github.bharatmane.hexagonalthis.domainapi.model.port.RequestUser;

import java.util.List;
import java.util.Optional;

public class UserDomain implements RequestUser {

    private final ObtainUser obtainUser;

    public UserDomain(ObtainUser obtainUser) {
        this.obtainUser = obtainUser;
    }

    @Override
    public List<User> getAllUsers() {
        return obtainUser.getAllUsers();
    }

    @Override
    public Optional<User> getUserById(int userId) {
        return obtainUser.getUserById(userId);
    }

    @Override
    public void addUser(User user) {
        obtainUser.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        //TBD
    }

    @Override
    public void deleteUserById(int userId) {
        //TBD
    }
}
