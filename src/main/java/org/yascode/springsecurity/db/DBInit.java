package org.yascode.springsecurity.db;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.yascode.springsecurity.dao.AuthoritiesRepository;
import org.yascode.springsecurity.dao.RoleRepository;
import org.yascode.springsecurity.dao.UserRepository;
import org.yascode.springsecurity.model.Authorities;
import org.yascode.springsecurity.model.Role;
import org.yascode.springsecurity.model.User;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class DBInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthoritiesRepository authoritiesRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUserName("ahmed");
        user.setPassword("ahmed123");
        user.setAge("20");
        user.setAddress("Hay Rahma Sale");
        user.setActive(1);
        user.setRoles(this.roleRepository.findAll());
        user.setAuthorities(this.authoritiesRepository.findAll());
        userRepository.save(user);
    }
}
