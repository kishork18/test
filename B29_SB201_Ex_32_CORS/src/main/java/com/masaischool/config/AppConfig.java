package com.masaischool.config;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CorsConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class AppConfig {
	Logger logger = LoggerFactory.getLogger("AppConfig.class");
	@Bean
	public SecurityFilterChain getChain(HttpSecurity http) throws Exception{
		CorsConfigurationSource ccs = request -> {
			//request is an object of HttpServletRequest
		  CorsConfiguration cc = new CorsConfiguration();
		  cc.setAllowedOriginPatterns(Arrays.asList("*"));	//Access-Control-Allow-Origin: *
		  cc.setAllowedMethods(Arrays.asList("PUT", "GET"));	//Access-Control-Allow-Method: PUT, GET
		  cc.setMaxAge(3600L);
		  return cc;
		};
		
		Customizer<CorsConfigurer<HttpSecurity>> corsConfigurer = cc -> cc.configurationSource(ccs);
		
		
		http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
		.csrf(c -> c.disable())
		.cors(corsConfigurer)
		.httpBasic(Customizer.withDefaults())
		.formLogin(Customizer.withDefaults());
		logger.info("Inside logger of AppConfig");
		return http.build();
	}
}
