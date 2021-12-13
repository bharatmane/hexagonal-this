package io.github.bharatmane.hexagonalthis.repository.entity;

import io.github.bharatmane.hexagonalthis.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Table(name = "T_User")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class UserEntity {
    @Column(name = "User_ID")
    private int userId;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Email")
    private String email;

    public User toModel() {
        return User.builder().userId(userId).firstName(firstName).lastName(lastName).email(email).build();
    }
}

