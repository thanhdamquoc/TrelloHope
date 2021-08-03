package com.codegym.trello.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class UserPrincipal implements UserDetails {
    private Long id;

    private String username;

    private String password;

    private String image;

    private String nickname;

    private Collection<? extends GrantedAuthority> roles;

    public UserPrincipal(Long id, String username, String password, String image, String nickname,
                         Collection<? extends GrantedAuthority> roles){
        this.id = id;
        this.username = username;
        this.password = password;
        this.image = image;
        this.nickname = nickname;
        this.roles = roles;
    }

    public static UserPrincipal build(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Roles roles : user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(roles.getName()));
        }

        return new UserPrincipal(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getImage(),
                user.getNickname(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
}
