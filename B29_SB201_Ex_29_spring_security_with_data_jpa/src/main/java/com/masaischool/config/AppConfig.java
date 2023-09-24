package com.masaischool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppConfig {
		@Bean
		public SecurityFilterChain anyMethodName(HttpSecurity http) throws Exception{
			http.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST, "/customers").permitAll().anyRequest().authenticated())
			.csrf(c -> c.disable())
			.formLogin(Customizer.withDefaults())
			.httpBasic(Customizer.withDefaults());
			
			return http.build();
		}
}
