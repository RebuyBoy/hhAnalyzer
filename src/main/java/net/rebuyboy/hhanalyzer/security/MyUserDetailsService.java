package net.rebuyboy.hhanalyzer.security;

import net.rebuyboy.hhanalyzer.model.User;
import net.rebuyboy.hhanalyzer.service.UserService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    private UserService userService;

    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public MyUserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.getUserByLogin(login);
        System.out.println(user.getName());
        System.out.println(user.getId());
        return mapUserDetails(user);
    }

    private MyUserDetails mapUserDetails(User user) {
        return new MyUserDetails.MyUserDetailsBuilder()
                .setId(user.getId())
                .setLogin(user.getLogin())
                .setPassword(user.getPassword())
                .setRegTime(user.getTimestamp())
                .setRole(user.getRoles())
                .setName(user.getName())
                .setEmail(user.getEmail())
                .build();
    }
}
