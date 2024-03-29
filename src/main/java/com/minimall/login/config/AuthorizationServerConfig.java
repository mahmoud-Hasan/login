package com.minimall.login.config;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


@Configuration
@EnableAuthorizationServer
@EnableGlobalMethodSecurity(securedEnabled=true)
@Order(1)
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    
	@Autowired
	@Qualifier("passwordEncoder")
    private PasswordEncoder passwordEncoder;
	
    @Autowired
    private AuthenticationManager authenticationManager;
	
	@Value("${exp:36000}")
	private int expiration;
	
	@Autowired
    private DataSource dataSource;
	

	@Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtTokenEnhancer());
    }
	@Bean
    public JwtAccessTokenConverter jwtTokenEnhancer() {
    	
        JwtAccessTokenConverter jwt = new JwtAccessTokenConverter();
    	jwt.setSigningKey("signingKEy");
		return jwt;
	}

	@Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    	clients.jdbc(dataSource);
   	
    	System.out.println(" Password :: " + passwordEncoder.encode("password"));
    
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    	TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), jwtTokenEnhancer()));
    	endpoints.tokenStore(tokenStore()).tokenEnhancer(tokenEnhancer());
        endpoints.authenticationManager(authenticationManager);
        endpoints.tokenEnhancer(tokenEnhancerChain);
        
        }
    
  
    
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new CustomTokenEnhancer();
    }
    
    
}
