package io.github.bharatmane.hexagonalthis.console;

import io.github.bharatmane.hexagonalthis.domainapi.model.User;
import io.github.bharatmane.hexagonalthis.domainapi.model.port.RequestUser;

import java.util.List;

public class UserResource {

    private final RequestUser requestUser;

    public UserResource(RequestUser requestUser) {
        this.requestUser = requestUser;
    }

    public List<User> getAllUsers(){return this.requestUser.getAllUsers();}
    public void addUser(int userId,String firstName,String lastName, String email) {
        User user = User.builder().userId(userId).firstName(firstName).lastName(lastName).email(email).build();
        requestUser.addUser(user);
    }

}