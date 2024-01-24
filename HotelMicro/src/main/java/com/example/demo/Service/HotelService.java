package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Hotel;

public interface HotelService {

	
	public Hotel createHotel(Hotel hotel);
	
	public Hotel findHotelById(String id);
	
	public List<Hotel>findAll();
	
	public String deleteHotel(String id);
	
	public Hotel editHotel(Hotel hotel);
	
}
