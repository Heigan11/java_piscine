package edu.school21.sockets.services;

import edu.school21.sockets.models.User;
import edu.school21.sockets.repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component("usersService")
public class UsersServiceImpl implements UsersService {

    private PasswordEncoder passwordEncoder;
    private UsersRepository usersRepository;

    public UsersServiceImpl(PasswordEncoder passwordEncoder, UsersRepository usersRepository) {
        this.passwordEncoder = passwordEncoder;
        this.usersRepository = usersRepository;
    }

    @Override
    public boolean signUp(String login, String password) throws SQLException {
        if (usersRepository.findByUsername(login).isPresent()){
            return false;
        }
        String encodedPassword = passwordEncoder.encode(password);
        usersRepository.save(new User(null, login, encodedPassword));
        return true;
    }
}
