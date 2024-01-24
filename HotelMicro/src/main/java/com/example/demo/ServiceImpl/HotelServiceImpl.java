package com.example.demo.ServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Hotel;
import com.example.demo.Repository.HotelRepo;
import com.example.demo.Service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	
	@Autowired
	private HotelRepo hr;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hr.save(hotel);
	}

	@Override
	public Hotel findHotelById(String id) {
		return hr.findById(id).get();
	}

	@Override
	public List<Hotel> findAll() {
		return hr.findAll();
	}

	@Override
	public String deleteHotel(String id) {
		Hotel hotel = hr.findById(id).get();
		if(hotel!=null)
		{
			hr.delete(hotel);
			return "Hotel deleted Successfully!!!!";
		}
		return "Some error occured";
	}

	@Override
	public Hotel editHotel(Hotel hotel) {
		return hr.save(hotel);
	}

}
