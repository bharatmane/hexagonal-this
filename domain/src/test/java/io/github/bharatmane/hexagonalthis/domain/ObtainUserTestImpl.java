package io.github.bharatmane.hexagonalthis.domain;

import io.github.bharatmane.hexagonalthis.domainapi.exception.UserNotFoundException;
import io.github.bharatmane.hexagonalthis.domainapi.model.User;
import io.github.bharatmane.hexagonalthis.domainapi.model.port.ObtainUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ObtainUserTestImpl implements ObtainUser {

    private final List<User> users = new ArrayList<>(Arrays.asList(
            User.builder().userId(1).firstName("Robert").lastName("Martin").email("robert.martin@somedomain.com").build(),
            User.builder().userId(2).firstName("Martin").lastName("Fowler").email("martin.fowler@somedomain.com").build()
    ));


    @Override
    public List<User> getAllUsers() {
        return this.users;
    }

    @Override
    public Optional<User> getUserById(int userId) {
        return Optional.ofNullable(findUser(userId));
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }

    @Override
    public void updateUser(User user) {
        User userToBeUpdated = findUser(user.getUserId());
        if(userToBeUpdated != null){
        this.users.set( this.users.indexOf(userToBeUpdated) , user);
        }

    }

    private User findUser(int userId){
        var user = this.users.stream()
                .filter(u -> u.getUserId() == userId)
                .findAny();
        return user.orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Override
    public void deleteUserById(int userId) {
        User userToBeDeleted = findUser(userId);
        if(userToBeDeleted != null){
            this.users.remove(userToBeDeleted);
        }
    }
}
