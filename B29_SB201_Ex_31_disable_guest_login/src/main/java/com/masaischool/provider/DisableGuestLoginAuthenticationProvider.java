package com.masaischool.provider;

import java.util.Collection;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.masaischool.entity.Customer;
import com.masaischool.service.CustomerDetailsService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DisableGuestLoginAuthenticationProvider implements AuthenticationProvider {
	private CustomerDetailsService customerDetailsService;
	private PasswordEncoder passwordEncoder;
	
	public DisableGuestLoginAuthenticationProvider(CustomerDetailsService customerDetailsService,
			PasswordEncoder passwordEncoder) {
		super();
		this.customerDetailsService = customerDetailsService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		//get customer from authentication object
		String email = (String)authentication.getPrincipal();
		String password = (String)authentication.getCredentials();
		log.info("username" + email + " password " + password);
		
		//The loadUserByUsername() method will throw exception when no user found for given email
		UserDetails cust = customerDetailsService.loadUserByUsername(email);
		
		//you are here means user with give email exists
		if(!passwordEncoder.matches(password, cust.getPassword())) {
			//you are here means password is mismatched
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		//you are here mean email and password are correct, but this time check for guest account
		//if this is guest account then again throw the exception with message "guest account is diabled"
		Collection<? extends GrantedAuthority> authorities = cust.getAuthorities();
		if(authorities.contains(new SimpleGrantedAuthority("ROLE_GUEST"))) {
			//you are here means this user has guest account
			throw new UsernameNotFoundException("guest account is disabled");
		}
		
		return new UsernamePasswordAuthenticationToken(cust, cust.getPassword(), authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
