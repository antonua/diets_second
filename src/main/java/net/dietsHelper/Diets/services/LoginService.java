package net.dietsHelper.Diets.services;

import net.dietsHelper.Diets.forms.LoginForm;
import net.dietsHelper.Diets.transfer.TokenDto;

public interface LoginService {
    TokenDto login(LoginForm loginForm);
}
