package com.minimall.login.repo;

import org.springframework.data.repository.CrudRepository;

import com.minimall.login.model.ClientsCredentials;

public interface ClientsCredintialsRepo extends CrudRepository<ClientsCredentials, String>{
	ClientsCredentials findByUsername(String username);
	
	
}	