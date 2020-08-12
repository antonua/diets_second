package net.dietsHelper.Diets.services;

import net.dietsHelper.Diets.forms.LoginForm;
import net.dietsHelper.Diets.models.Token;
import net.dietsHelper.Diets.models.User;
import net.dietsHelper.Diets.repositories.TokensRepository;
import net.dietsHelper.Diets.repositories.UsersRepository;
import net.dietsHelper.Diets.transfer.TokenDto;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public TokenDto login(LoginForm loginForm) {
        Optional<User> userCandidate = usersRepository.findOneByLogin(loginForm.getLogin());

        if(userCandidate.isPresent()){
            User user = userCandidate.get();

            if(passwordEncoder.matches(loginForm.getPassword(), user.getHashPassword())){
                Token token = Token.builder()
                        .user(user)
                        .value(RandomStringUtils.random(10, true, true))
                        .build();

                tokensRepository.save(token);
                return TokenDto.from(token);
            }
        }throw new IllegalArgumentException("User not found");
    }
}
