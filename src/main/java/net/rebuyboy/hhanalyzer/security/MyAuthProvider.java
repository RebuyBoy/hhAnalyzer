package net.rebuyboy.hhanalyzer.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class MyAuthProvider extends DaoAuthenticationProvider {
    private MyUserDetailsService detailService;

    public MyAuthProvider(MyUserDetailsService detailService) {
        this.detailService = detailService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        MyUserDetails userDetails = detailService.loadUserByUsername(name);
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}
