package com.minimall.login.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import lombok.Data;

@Data
@Entity
@Table(name = "clients_credentials")
public class ClientsCredentials implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name ="user_name",length = 225)
	private String username;
	
	@NotNull
    @NotEmpty
	private String password;
	
	@Column(name ="is_active")
	private boolean isActive;
	
	@Column(name ="company_name")
	private String companyName;
	
	@Column(name ="authorities")
	private String role;
	
	@Email
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "clients")
	private BrandModel brandModel;
	
	
//	@NotNull
//	@NotEmpty
//	private List<String> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        list.add(new SimpleGrantedAuthority(role));

        return list;
		//return null;
	}

	

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
