package net.dietsHelper.Diets.forms;

import lombok.Data;


@Data
public class UserForm {
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String hashPassword;
}
