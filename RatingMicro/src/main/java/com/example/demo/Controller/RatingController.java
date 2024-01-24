package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Rating;
import com.example.demo.Service.RatingService;

@RestController
@RequestMapping("/Rating")
public class RatingController {

	
	@Autowired
	private RatingService rs;
	
	@PostMapping("/rate")
	public ResponseEntity<?> createRating(@RequestBody Rating rate)
	{
		return new ResponseEntity<>(rs.Rate(rate),HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAllRatings()
	{
		return new ResponseEntity<>(rs.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/Users/{userId}")
	public ResponseEntity<?> findByUserId(@PathVariable String userId)
	{
		return new ResponseEntity<>(rs.getRatingByUserId(userId),HttpStatus.OK);
	}
	
	@GetMapping("/Hotels/{hotelId}")
	public ResponseEntity<?> findByHotelId(@PathVariable String hotelId)
	{
		return new ResponseEntity<>(rs.getRatingByHotelId(hotelId),HttpStatus.OK);
	}
}
