package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.models.Ride;
import com.masai.models.User;
import com.masai.service.RapidoService;

import jakarta.validation.Valid;

@RestController
public class RapidoController {

	@Autowired
	private RapidoService rapidService;
	
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getAllUsers () {
		return new ResponseEntity<>(rapidService.getAllUsers(), HttpStatus.FOUND);
	}	
	
	@GetMapping(value = "/rides")
	public ResponseEntity<List<Ride>> getAllRides () {
		return new ResponseEntity<>(rapidService.getAllRides(), HttpStatus.FOUND);
	}
	
	
	@PostMapping(value = "/rides")
	public ResponseEntity<Ride> bookARide (@RequestBody Ride ride) {
		return new ResponseEntity<>(rapidService.bookARide(ride), HttpStatus.CREATED);
	}
	
	
	
	@PostMapping(value = "/users")
	public ResponseEntity<User> addUser (@Valid @RequestBody User user) {
		return new ResponseEntity<>(rapidService.addUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/rides/{id}")
	public ResponseEntity<List<Ride>> getRideHistory(@PathVariable Integer id) {		
		return new ResponseEntity(rapidService.getRideHistory(id), HttpStatus.FOUND);		
	}
	
	
	
	
	
}
