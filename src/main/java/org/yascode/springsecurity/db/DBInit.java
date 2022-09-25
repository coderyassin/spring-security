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

@Service
@RequiredArgsConstructor
public class DBInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final AuthoritiesRepository authoritiesRepository;

    @Override
    public void run(String... args) throws Exception {
        this.userRepository.deleteAll();
        User admin = new User();
        admin .setUserName("ahmed");
        admin .setPassword("ahmed123");
        admin .setAge("20");
        admin .setAddress("Hay Rahma Sale");
        admin .setActive(1);
        admin .setRoles(this.roleRepository.findAll());
        admin .setAuthorities(this.authoritiesRepository.findAll());
        userRepository.save(admin );
        /////////////////////////////////////////////////////////////////////////
        User manger = new User();
        manger.setUserName("yaser");
        manger.setPassword("yaser123");
        manger.setAge("25");
        manger.setAddress("Hay Takadoum Rabat");
        manger.setActive(1);
        Role mangerRoles1 = roleRepository.findById(2L).get();
        Role mangerRoles2 = roleRepository.findById(3L).get();
        Authorities mangerAuthorities1 = authoritiesRepository.findById(2L).get();
        Authorities mangerAuthorities2 = authoritiesRepository.findById(3L).get();
        manger.getRoles().add(mangerRoles1);
        manger.getRoles().add(mangerRoles2);
        manger.getAuthorities().add(mangerAuthorities1);
        manger.getAuthorities().add(mangerAuthorities2);
        userRepository.save(manger);
        /////////////////////////////////////////////////////////////////////////
        User user = new User();
        user.setUserName("karim");
        user.setPassword("karim123");
        user.setAge("34");
        user.setAddress("Hay Tacharouk Casablanca");
        user.setActive(1);
        Role userRoles1 = roleRepository.findById(3L).get();
        Authorities userAuthorities1 = authoritiesRepository.findById(3L).get();
        user.getRoles().add(userRoles1);
        user.getAuthorities().add(userAuthorities1);
        userRepository.save(user);
    }
}
