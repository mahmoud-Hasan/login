package com.minimall.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minimall.login.model.ClientsCredentials;
import com.minimall.login.repo.ClientsCredintialsRepo;
import com.minimall.login.service.RegistarationService;

@RestController
@RequestMapping("/registration")
public class RegisterationController {

	@Autowired
	private ClientsCredintialsRepo clientsCredintialsRepo;

	@Autowired
	private RegistarationService registarationService;
	@PostMapping("/create")
	public void createAdmin(@RequestBody ClientsCredentials clientsCredentials) throws Exception {
		registarationService.createAdmin(clientsCredentials);

	}
//	@PostMapping("/user")
//	public void createUser(@RequestBody ClientsCredentials clientsCredentials) {
//		registarationService.createUser(clientsCredentials);
//
//	}
	@GetMapping("/get/all")
	public List<ClientsCredentials> getUsers(){
		return (List<ClientsCredentials>) clientsCredintialsRepo.findAll();
	}
}