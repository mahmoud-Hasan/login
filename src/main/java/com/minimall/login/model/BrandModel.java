package com.minimall.login.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "brand")
public class BrandModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String brandName;
	
	@OneToMany(mappedBy = "brandModel", cascade = CascadeType.ALL)
	private Set<ClientsCredentials> clients;
	
	
}
