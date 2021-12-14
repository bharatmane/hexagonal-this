package io.github.bharatmane.hexagonalthis.repository.entity;

import io.github.bharatmane.hexagonalthis.domainapi.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name = "t_user", schema = "cruddemo")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public User toModel() {
        return User.builder().userId(id).firstName(firstName).lastName(lastName).email(email).build();
    }
}

