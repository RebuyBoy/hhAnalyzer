package net.rebuyboy.hhanalyzer.service;

import net.rebuyboy.hhanalyzer.model.User;
import net.rebuyboy.hhanalyzer.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public User save(User user) {
       return userRepository.save(user);
    }
}
