package io.github.bharatmane.hexagonalthis.domain;

import io.github.bharatmane.hexagonalthis.domainapi.exception.UserNotFoundException;
import io.github.bharatmane.hexagonalthis.domainapi.model.User;
import io.github.bharatmane.hexagonalthis.domainapi.model.port.ObtainUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserDomainTest {

    private UserDomain requestUser;

    @BeforeEach
    public void init() {
        /*
       RequestUser    - left side port
       UserDomain     - hexagon (domain)
       ObtainUser     - right side port
        */

        ObtainUser obtainUser = new ObtainUserTestImpl();
        this.requestUser = new UserDomain(obtainUser); // the example is hard coded
    }

    @Test
    @DisplayName("should be able to get users when asked for users from stub users")
    void getUsersFromStub() {

        //Given
        var users = requestUser.getAllUsers();

        //When

        //Then
        assertThat(users).isNotNull();
        assertThat(users)
                .filteredOn("firstName", "Robert")
                .isNotEmpty();
    }


    @Test
    @DisplayName("should be able to get user when asked for user by id from stub")
    void getUserByIdFromStub() {
        // Given
        int userIdToSearch = 1;

        // When
        var user = requestUser.getUserById(userIdToSearch).get();

        //Then
        assertThat(user)
                .isNotNull();
        assertThat(user.getFirstName()).isEqualTo("Robert");


    }

    @Test
    @DisplayName("should throw exception when asked for user by id that does not exists from stub")
    void getExceptionWhenAskedUserByIdThatDoesNotExist() {
        // Given
        int userIdToSearch = 4;

        // When

        // Then
        assertThatThrownBy(() -> requestUser.getUserById(userIdToSearch))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessageContaining("User with id " + userIdToSearch + " does not exist");
    }

    @Test
    @DisplayName("should delete user when user is deleted by id from stub")
    void deleteUserFromStub() {
        // Given
        int userIdToDelete = 1;

        // When
        requestUser.deleteUserById(userIdToDelete);

        // Then
        assertThatThrownBy(() -> requestUser.getUserById(userIdToDelete))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessageContaining("User with id " + userIdToDelete + " does not exist");
    }

    @Test
    @DisplayName("should delete user when user is deleted by id from stub")
    void updateUserFromStub() {
        // Given
        User user = User.builder().userId(1).firstName("Uncle").lastName("Bob").email("uncle.bob@somedomain.com").build();


        // When
        requestUser.updateUser(user);

        // Then
        assertThat(user)
                .isNotNull();
        assertThat(user.getFirstName()).isEqualTo("Uncle");
        assertThat(user.getLastName()).isEqualTo("Bob");
        assertThat(user.getEmail()).isEqualTo("uncle.bob@somedomain.com");
    }
}
