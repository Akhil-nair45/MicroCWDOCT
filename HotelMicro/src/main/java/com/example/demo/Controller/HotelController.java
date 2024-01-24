package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Hotel;
import com.example.demo.Service.HotelService;

@RestController
@RequestMapping("/Hotel")
public class HotelController {

	@Autowired
	private HotelService hs;
	
	@PostMapping("/create")
	public ResponseEntity<?> addHotel(@RequestBody Hotel hotel)
	{
		return new ResponseEntity<>(hs.createHotel(hotel),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getHotelById(@PathVariable String id)
	{
		return new ResponseEntity<>(hs.findHotelById(id),HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> getAll()
	{
		return new ResponseEntity<>(hs.findAll(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteHotel(@PathVariable String id)
	{
		return new ResponseEntity<>(hs.deleteHotel(id),HttpStatus.OK);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<?> editHotel(@RequestBody Hotel hotel)
	{
		return new ResponseEntity<>(hs.editHotel(hotel),HttpStatus.OK);
	}
}
