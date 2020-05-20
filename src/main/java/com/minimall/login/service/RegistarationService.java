package com.minimall.login.service;

import com.minimall.login.model.ClientsCredentials;

public interface RegistarationService {
	//to create admin
	void createAdmin(ClientsCredentials clientsCredentials) throws Exception;
	

}
