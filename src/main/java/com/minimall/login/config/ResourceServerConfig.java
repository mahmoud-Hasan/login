package com.minimall.login.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//        .anyRequest()
//        .authenticated();
		http.cors().and().csrf().disable().
        authorizeRequests()
        .antMatchers("/registration/**").permitAll()
        .anyRequest().authenticated();
	}
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(null);
	}
	
	
}