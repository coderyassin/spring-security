package org.yascode.springsecurity.model;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserPrincipal implements UserDetails {

    private final User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = this.user.getAuthorities()
                                                        .stream().map(p -> new SimpleGrantedAuthority(p.getAuthorityName()))
                                                        .collect(Collectors.toList());

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUserName();
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

    /**
     * Check if user is enabled
     * @return true if the user is enabled otherwise false will be returned
     */
    @Override
    public boolean isEnabled() {
        try {
            return this.user.getActive() == 1;
        }catch (Exception e){
            return false;
        }
    }
}
