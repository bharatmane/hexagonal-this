package io.github.bharatmane.hexagonalthis.domainapi.model;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserTest {

    @Test
    @org.junit.jupiter.api.Test
    @DisplayName("should build the user model")
    void shouldBuildTheUserModel(){

        //Given
        User user = User.builder().userId(1).firstName("Robert").lastName("Martin").email("robert.martin@somedomain.com").build();;

        //When

        //Then
        assertThat(user.getFirstName()).isEqualTo("Robert");

    }
}
