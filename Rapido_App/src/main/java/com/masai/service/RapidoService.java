package com.masai.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.masai.exception.DuplicateValueException;
import com.masai.exception.NoRideFoundException;
import com.masai.exception.UserNotFoundException;
import com.masai.models.Ride;
import com.masai.models.User;

import jakarta.annotation.PostConstruct;

@Service
public class RapidoService {
	
	private Map<Integer, User> map = new HashMap<>();
	
	private Map<Integer, Ride> rides = new HashMap<>();
	
	@PostConstruct
	public void init() {
		User u1 = new User(1, "Aman", "aman@email.com");
		User u2 = new User(2, "Badri", "badri@email.com");
		User u3 = new User(3, "Chandan", "chandan@email.com");
		
		map.put(u1.getUserId(), u1);
		map.put(u2.getUserId(), u2);
		map.put(u3.getUserId(), u3);
	}
	
	@PostConstruct
	public void initRides() {
		Ride r1 = new Ride(1, 2, "ChurchGate", "Andheri");
		
		rides.put(r1.getRideId(), r1);
	}
	
	public List<User> getAllUsers() {
		return new ArrayList<>(map.values());
	}
	
	public List<Ride> getAllRides() {
		return new ArrayList<>(rides.values());
	}
	
	public Ride bookARide(Ride ride) {
		
		if(!map.containsKey(ride.getUserId())) {
			// throw an exception
			throw new UserNotFoundException("User does not exist with the id: " + ride.getUserId());
		}
		
		rides.put(ride.getRideId(), ride);
		return ride;
	}

	public User addUser (User user) {
		if(map.containsKey(user.getUserId())) {
			// user already exists
			throw new DuplicateValueException("User already exists in the system");
		}
		map.put(user.getUserId(), user);
		return user;
	}
	
	
	public List<Ride> getRideHistory(Integer id) {
		
		if(!map.containsKey(id)) throw new UserNotFoundException("User does not exist with the id: " + id);
		
		List<Ride> ridesByTheUserId = new ArrayList<>();		
		for(Map.Entry<Integer, Ride> ent: rides.entrySet()) {
			if(ent.getValue().getUserId() == id) ridesByTheUserId.add(ent.getValue());
		}		
		if(ridesByTheUserId.size() == 0) throw new NoRideFoundException("No Rides are there in the record for the userId: " + id);
		
		return ridesByTheUserId;
		
	}
	
	
	
	
	
	
	
	
	
}
