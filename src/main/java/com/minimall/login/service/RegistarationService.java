package com.minimall.login.service;

import com.minimall.login.model.ClientsCredentials;

public interface RegistarationService {
	
	void createUser(ClientsCredentials clientsCredentials) throws Exception;

}
