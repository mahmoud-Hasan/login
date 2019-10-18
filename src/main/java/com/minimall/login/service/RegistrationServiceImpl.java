package com.minimall.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.minimall.login.model.ClientsCredentials;
import com.minimall.login.repo.ClientsCredintialsRepo;

@Service
public class RegistrationServiceImpl implements RegistarationService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ClientsCredintialsRepo clientsCredintialsRepo;

	@Override
	public void createUser(ClientsCredentials clientsCredentials) {
		String newPass = passwordEncoder.encode(clientsCredentials.getPassword());
		
		clientsCredentials.setPassword(newPass);

		clientsCredintialsRepo.save(clientsCredentials);
	}
	
	

}
