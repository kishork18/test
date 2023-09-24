package com.masaischool.service;

import org.springframework.stereotype.Service;

import com.masaischool.entity.RolesAndAuthority;
import com.masaischool.repository.RolesAndAuthorityRepository;

@Service
public class RolesAndAuthorityServiceImpl implements RolesAndAuthorityService {

	private RolesAndAuthorityRepository rolesAndAuthorityRepository;
	
	public RolesAndAuthorityServiceImpl(RolesAndAuthorityRepository rolesAndAuthorityRepository) {
		super();
		this.rolesAndAuthorityRepository = rolesAndAuthorityRepository;
	}

	@Override
	public RolesAndAuthority getRolesAndAuthority(String name) {
		return rolesAndAuthorityRepository.findByName(name).get();
	}

}
