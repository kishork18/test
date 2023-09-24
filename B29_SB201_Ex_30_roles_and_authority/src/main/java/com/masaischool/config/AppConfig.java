package com.masaischool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppConfig {
		@Bean
		public SecurityFilterChain anyMethodName(HttpSecurity http) throws Exception{
			http.authorizeHttpRequests(
					auth -> auth.requestMatchers(HttpMethod.POST, "/customers").permitAll()
					.requestMatchers(HttpMethod.GET, "/for-admin-only").hasRole("ADMIN")
					.requestMatchers("/for-user-and-guest-only").hasAnyRole("USER", "GUEST")
					.requestMatchers("/for-user-only").hasRole("USER")
					.requestMatchers("/for-can-update").hasAuthority("CAN_UPDATE")
					.requestMatchers("/for-can-read-or-write").hasAnyAuthority("CAN_READ", "CAN_WRITE")
					.anyRequest().authenticated())
			.csrf(c -> c.disable())
			.formLogin(Customizer.withDefaults())
			.httpBasic(Customizer.withDefaults());
			
			return http.build();
		}
		
		//this method is to configure the password encoder
		@Bean
		public PasswordEncoder getPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}
}
