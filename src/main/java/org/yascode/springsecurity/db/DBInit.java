package org.yascode.springsecurity.db;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.yascode.springsecurity.dao.AuthoritiesRepository;
import org.yascode.springsecurity.dao.UserRepository;
import org.yascode.springsecurity.model.Authorities;
import org.yascode.springsecurity.model.User;

@Service
@RequiredArgsConstructor
public class DBInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AuthoritiesRepository authoritiesRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        this.userRepository.deleteAll();
        User admin = new User();
        admin.setUserName("ahmed");
        admin.setPassword(passwordEncoder.encode("ahmed123"));
        admin.setAge("20");
        admin.setAddress("Hay nahda Rabat");
        admin.setActive(1);
        admin.setAuthorities(this.authoritiesRepository.findAll());
        userRepository.save(admin);
        /////////////////////////////////////////////////////////////////////////
        User manger = new User();
        manger.setUserName("yaser");
        manger.setPassword(passwordEncoder.encode("yaser123"));
        manger.setAge("26");
        manger.setAddress("Hay Tacharouk Rabat");
        manger.setActive(1);
        Authorities mangerAuthorities1 = authoritiesRepository.findById(1L).get();
        Authorities mangerAuthorities2 = authoritiesRepository.findById(2L).get();
        manger.getAuthorities().add(mangerAuthorities1);
        manger.getAuthorities().add(mangerAuthorities2);
        userRepository.save(manger);
        /////////////////////////////////////////////////////////////////////////
        User user = new User();
        user.setUserName("karim");
        user.setPassword(passwordEncoder.encode("karim123"));
        user.setAge("30");
        user.setAddress("Hay Inbiaat Rabat");
        user.setActive(1);
        Authorities userAuthorities2 = authoritiesRepository.findById(3L).get();
        user.getAuthorities().add(userAuthorities2);
        userRepository.save(user);
    }
}
