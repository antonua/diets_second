package net.dietsHelper.Diets.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity{

    private String login;

    private String firstName;

    private String lastName;

    private String email;

    private String hashPassword;

    @Transient
    private String passwordConfirm;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "user")
    List<Token> tokens;

}
