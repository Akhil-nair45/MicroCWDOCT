package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entities.Rating;

public interface RatingService {

//	create 
	public Rating Rate(Rating rating);
	
//	getAll
	public List<Rating> getAll();
	
//	getAllratingdonebyusers
	public List<Rating> getRatingByUserId(String userId);
	
//	getAllratingdonebyhotel
	public List<Rating> getRatingByHotelId(String hotelId);
}
