package com.masaischool.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Customer implements UserDetails, CredentialsContainer {
	@Column(unique = true, nullable = false)
	private String email;	//this is my username
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String address;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "customer_authorities",
		joinColumns = @JoinColumn(referencedColumnName = "id", name = "customer_id"),
		inverseJoinColumns = @JoinColumn(referencedColumnName = "id",  name = "role_and_authority_id")
	)
	private Set<RolesAndAuthority> authoritiesSet = new HashSet<>();
	
	public Customer(String email, String password, String name, String address, Set<RolesAndAuthority> authoritiesSet) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.address = address;
		this.authoritiesSet = authoritiesSet;
	}

	@Override
	public void eraseCredentials() {
		this.password = null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> set = new HashSet<>();
		for(RolesAndAuthority roles: authoritiesSet) {
			set.add(new SimpleGrantedAuthority(roles.getName()));
		}
		return set;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
