package com.pranav.api_security_poc.service;

import com.pranav.api_security_poc.model.User;
import com.pranav.api_security_poc.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        if (userRepository.count() == 0) {

            User alice = new User(
                    "alice",
                    passwordEncoder.encode("alice123"),
                    "USER"
            );

            User bob = new User(
                    "bob",
                    passwordEncoder.encode("bob123"),
                    "USER"
            );

            User admin = new User(
                    "admin",
                    passwordEncoder.encode("admin123"),
                    "ADMIN"
            );

            userRepository.save(alice);
            userRepository.save(bob);
            userRepository.save(admin);

            System.out.println("Security POC users initialized.");
        }
    }
}