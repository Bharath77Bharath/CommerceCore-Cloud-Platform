package com.bharath.Ecommerce.Seed;

import com.bharath.Ecommerce.Entity.Users;
import com.bharath.Ecommerce.Repository.UserRepository;
import com.bharath.Ecommerce.Security.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Value("${admin.name}")
    private String adminName;

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;

    @Override
    public void run(String... args) {

        if(userRepository.findByEmail(adminEmail).isEmpty()) {

            Users admin = new Users();

            admin.setName(adminName);
            admin.setEmail(adminEmail);
            admin.setPassword(
                    passwordEncoder.encode(adminPassword)
            );
            admin.setRole(Role.ADMIN);

            userRepository.save(admin);

            System.out.println("Admin user created");
        }
    }
}