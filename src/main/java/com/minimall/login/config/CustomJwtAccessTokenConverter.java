//package com.minimall.login.config;
//
//import java.util.Collection;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
//import org.springframework.stereotype.Component;
//
//import com.minimall.login.model.ClientsCredentials;
//
//@Component
//public class CustomJwtAccessTokenConverter extends JwtAccessTokenConverter{
//	 @Override
//	    public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
//	        OAuth2Authentication authentication = super.extractAuthentication(map);
//	        Authentication userAuthentication = authentication.getUserAuthentication();
//
//	        if (userAuthentication != null) {
//	            LinkedHashMap<?,?> ClientsCredentials = (LinkedHashMap<?, ?>) map.get("user_more");
//	            if (ClientsCredentials != null) {
//
//	                // build your principal here
//	                ClientsCredentials extendedPrincipal = new ClientsCredentials();
//	                extendedPrincipal.setCompanyName(ClientsCredentials.get("companyName").toString());
//	                Collection<? extends GrantedAuthority> authorities = userAuthentication.getAuthorities();
//
//	                userAuthentication = new UsernamePasswordAuthenticationToken(extendedPrincipal,
//	                        userAuthentication.getCredentials(), authorities);
//	            }
//	        }
//	        return new OAuth2Authentication(authentication.getOAuth2Request(), userAuthentication);
//	    }
//	}
//
