package com.minimall.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService customUserDetailsService;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		http
//		.requestMatchers()
//		.antMatchers("/contactList/lol").and()
//       .authorizeRequests()
//        .antMatchers("/user/registration")
//        .permitAll()
//        .anyRequest()
//        .authenticated();
		
		 http.cors().and().csrf().disable().
         authorizeRequests()
         .antMatchers("/registration/**").permitAll()
         .anyRequest().authenticated()
//         .and()
//         .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//         .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         ;
	}
	
	@Override
	  public void configure(WebSecurity web) throws Exception {
	
	  	web.ignoring().antMatchers(HttpMethod.GET,"/registration/**");
	  }
	
	
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {

       auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);;
	 }
	 
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
