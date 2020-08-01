package com.minimall.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@SpringBootApplication
public class LoginApplication {

	private static final CharSequence secret = "HashSecret";	
	
	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}
	
	  @Bean("passwordEncoder")
	    public PasswordEncoder passwordEncoder() {
	        return new Pbkdf2PasswordEncoder(secret);
    }
}
