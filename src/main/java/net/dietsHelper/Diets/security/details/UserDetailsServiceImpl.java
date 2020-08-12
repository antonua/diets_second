package net.dietsHelper.Diets.security.details;

import net.dietsHelper.Diets.models.User;
import net.dietsHelper.Diets.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return new
                UserDetailsImpl(usersRepository.findOneByLogin(login)
                .orElseThrow(IllegalArgumentException::new));
    }
}
