package com.example.demo.ServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Rating;
import com.example.demo.Repository.RatingRepo;
import com.example.demo.Service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	
	@Autowired
	private RatingRepo rr;
	
	@Override
	public Rating Rate(Rating rating) {
		String string = UUID.randomUUID().toString();
		rating.setRatingId(string);
		return rr.save(rating);
	}

	@Override
	public List<Rating> getAll() {
		return rr.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return rr.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return rr.findByHotelId(hotelId);
	}

}
