package io.github.bharatmane.hexagonalthis.domain.port;
import java.util.List;
import java.util.Optional;

import io.github.bharatmane.hexagonalthis.domain.model.User;
import lombok.NonNull;

public interface ObtainUser {
    default List<User> getAllUsers() {
        User example =
                User.builder()
                        .userId(1)
                        .firstName("Robert")
                        .lastName("Martin")
                        .lastName("robert.martin@somedomain.com")
                        .build();
        return List.of(example);
    }

    default Optional<User> getUserById(@NonNull int userId) {
        return Optional.of(
                User.builder()
                        .userId(1)
                        .firstName("Robert")
                        .lastName("Martin")
                        .lastName("robert.martin@somedomain.com")
                        .build());
    }

    void addUser(User user);
    void updateUser(User user);
    void deleteUserById(int userId);
}
