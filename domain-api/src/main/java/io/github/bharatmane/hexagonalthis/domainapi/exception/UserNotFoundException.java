package io.github.bharatmane.hexagonalthis.domainapi.exception;

public class UserNotFoundException extends  RuntimeException{
    public UserNotFoundException(int userId) {
        super("User with id " + userId + " does not exist");
    }
}
