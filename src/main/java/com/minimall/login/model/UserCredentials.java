//package com.minimall.login.model;
//
//import java.util.Collection;
//
//import javax.validation.constraints.NotBlank;
//
//import org.springframework.data.cassandra.core.mapping.Column;
//import org.springframework.data.cassandra.core.mapping.PrimaryKey;
//import org.springframework.data.cassandra.core.mapping.Table;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import lombok.Data;
//
//@Data
//@Table("user_credintials")
//public class UserCredentials implements UserDetails {
//	
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	@NotBlank
//	private String password;
//	
//	@Column("is_active")
//	private boolean isActive;
//	
//	@Column("activation_code")
//	private String activationCode;
//	
//	@NotBlank
//	@PrimaryKey
//	private String username;
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	
//}