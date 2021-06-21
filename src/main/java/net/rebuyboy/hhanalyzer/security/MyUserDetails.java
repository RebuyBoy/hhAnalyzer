package net.rebuyboy.hhanalyzer.security;

import net.rebuyboy.hhanalyzer.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {
    private long id;
    private String login;
    private String password;
    private Timestamp regTime;
    private List<Role> roles;
    private String email;
    private String name;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static class MyUserDetailsBuilder {
        private MyUserDetails userDetails;

        public MyUserDetailsBuilder() {
            this.userDetails = new MyUserDetails();
        }

        public MyUserDetailsBuilder setLogin(String login) {
            this.userDetails.setLogin(login);
            return this;
        }

        public MyUserDetailsBuilder setPassword(String password) {
            this.userDetails.setPassword(password);
            return this;
        }

        public MyUserDetailsBuilder setRegTime(Timestamp time) {
            this.userDetails.setRegTime(time);
            return this;
        }

        public MyUserDetailsBuilder setRole(List<Role> roles) {
            this.userDetails.setRoles(roles);
            return this;
        }

        public MyUserDetailsBuilder setId(long id) {
            this.userDetails.setId(id);
            return this;
        }

        public MyUserDetailsBuilder setName(String name) {
            this.userDetails.setName(name);
            return this;
        }

        public MyUserDetailsBuilder setEmail(String email) {
            this.userDetails.setEmail(email);
            return this;
        }

        public MyUserDetails build() {
            return userDetails;
        }

    }
}
