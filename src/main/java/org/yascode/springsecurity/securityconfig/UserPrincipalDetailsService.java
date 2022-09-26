package org.yascode.springsecurity.securityconfig;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.yascode.springsecurity.dao.UserRepository;
import org.yascode.springsecurity.model.User;
import org.yascode.springsecurity.model.UserPrincipal;

@Service
@RequiredArgsConstructor
public class UserPrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username).get();
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }
}
