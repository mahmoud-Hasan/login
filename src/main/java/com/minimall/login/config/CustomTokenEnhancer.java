package com.minimall.login.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.minimall.login.model.ClientsCredentials;

public class CustomTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();
        ClientsCredentials cc = (ClientsCredentials) authentication.getUserAuthentication().getPrincipal();
        additionalInfo.put("user_more", cc.getCompanyName());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
                
        return accessToken;
    }
}