package com.masaischool.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masaischool.entity.RolesAndAuthority;

public interface RolesAndAuthorityRepository extends JpaRepository<RolesAndAuthority, Integer> {
	Optional<RolesAndAuthority> findByName(String name);	//SELECT r FROM RolesAndAuthority r WHERE name = :name;
}
