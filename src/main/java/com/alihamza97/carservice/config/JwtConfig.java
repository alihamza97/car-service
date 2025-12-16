package com.alihamza97.carservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.*;

@Configuration
public class JwtConfig {

    @Value("${keyvault.tenant.id}")
    String tenant;

    @Bean
    JwtDecoder jwtDecoder() {


        NimbusJwtDecoder decoder = NimbusJwtDecoder
                .withJwkSetUri("https://login.microsoftonline.com/" + tenant + "/discovery/keys")
                .build();

        decoder.setJwtValidator(
                JwtValidators.createDefaultWithIssuer("https://sts.windows.net/" + tenant + "/")
        );

        return decoder;
    }
}
