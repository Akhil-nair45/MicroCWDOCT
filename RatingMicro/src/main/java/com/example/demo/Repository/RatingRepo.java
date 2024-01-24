package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Rating;

@Repository
public interface RatingRepo extends JpaRepository<Rating, String>{

	
//	custom finder methods to find getallratingby

//	findBycommon for user write in camelcase and for hotel write in camel case thats it
	List<Rating> findByUserId(String userId);
	
	List<Rating> findByHotelId(String hotelId);
	
}
