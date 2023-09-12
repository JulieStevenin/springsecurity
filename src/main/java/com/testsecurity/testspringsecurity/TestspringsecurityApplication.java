package com.testsecurity.testspringsecurity;


import com.testsecurity.testspringsecurity.entities.Role;
import com.testsecurity.testspringsecurity.entities.User;
import com.testsecurity.testspringsecurity.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class TestspringsecurityApplication {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	public TestspringsecurityApplication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(TestspringsecurityApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner() {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				User user = new User("Julieadmin", passwordEncoder.encode("julie"));
				user.setRoleList(Arrays.asList(new Role("admin")));
				userRepository.save(user);
			}
		};
	}

}