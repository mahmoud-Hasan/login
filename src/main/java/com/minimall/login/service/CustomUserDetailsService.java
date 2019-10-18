package com.minimall.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.minimall.login.model.ClientsCredentials;
import com.minimall.login.repo.ClientsCredintialsRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private ClientsCredintialsRepo clientsCredintialsRepo;

	@Override
	public ClientsCredentials loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 return  clientsCredintialsRepo.findByUsername(username);
	
	}

}