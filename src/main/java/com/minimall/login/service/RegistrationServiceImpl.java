package com.minimall.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.minimall.login.model.ClientsCredentials;
import com.minimall.login.repo.ClientsCredintialsRepo;

@Service
public class RegistrationServiceImpl implements RegistarationService {

	@Autowired
	@Qualifier("passwordEncoder")
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ClientsCredintialsRepo clientsCredintialsRepo;

	@Override
	public void createAdmin(ClientsCredentials clientsCredentials) throws Exception {
				
		if (clientsCredentials.getCompanyName().equals("brand") ) {
			throw new Exception("Cannot create admin for generic brand ");
		}
		String newPass = passwordEncoder.encode(clientsCredentials.getPassword());
		
		clientsCredentials.setPassword(newPass);
		clientsCredentials.setRole("ROLE_ADMIN");

		clientsCredintialsRepo.save(clientsCredentials);
	}
	
//	// create user model
//	
//	@Override
//	public void createUser(ClientsCredentials clientsCredentials) {
//		
//		clientsCredentials.setRole("ROLE_USER");
//		
//		String newPass = passwordEncoder.encode(clientsCredentials.getPassword());
//		
//		clientsCredentials.setPassword(newPass);
//		clientsCredentials.setRole("ROLE_ADMIN");
//
//		clientsCredintialsRepo.save(clientsCredentials);
//		
//		// now we need to set profile for the user in user MS
//		
//		
//	}
	

}
