package com.example.demo.ServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.Hotel;
import com.example.demo.Entity.Rating;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepo ur;
	
//	we r doing autowired for rest template to get ratings of the user particularly
	@Autowired
	private RestTemplate restTemplate;
	
	
//	just manually paste two import line at top for logger
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	
	@Override
	public User saveUser(User user) {
//		uinque user id will be generated with the help of this steps
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return ur.save(user);
	}

	@Override
	public User findUserById(String userId) {
//		we just assigned a variable to the line and return the variable we can directly return but for some versatility we r doing
		User user = ur.findById(userId).get();
//		fetch rating of the above user from rating service, we have a controller in rating servcie ("/User/{userId}") which will give the rating of the particular user and url is below:
//		http://localhost:8082/Rating/Users/181f33f3-0968-48da-8ff6-cb32ca2971ce   this is the url which will give the rating of the user, we r using rest template for it
		
//		now after creating a bean in the config package for rest template now we can use various features of rest template
//		we can also just write arraylist <rating> was written to return the rating object without rating also it will run
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-MICROSERVICE/Rating/Users/"+user.getUserId(), Rating[].class);
		
		
		
		logger.info("{}",ratingsOfUser);  //just to check whether the data is coming or not
//		now u can see that in the console we can see the data that is with the help of logger
		
		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		
		
//		now to show hotel we r doing this
		List<Rating> ratingList=ratings.stream().map(rating->{
//			api call to hotel service to get hotel
//			http://HOTEL-MICROSERVICE/Hotel/479bcd42-1091-4cf3-84a6-985f3754c3f8
			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-MICROSERVICE/Hotel/"+rating.getHotelId(), Hotel.class);
			Hotel hotel = forEntity.getBody();
			
//			set the hotel to rating
			rating.setHotel(hotel);
			
			
//			return the rating
			return rating;
		}).collect(Collectors.toList());
		
//		now as we have checked that the data is coming properly now we can set this ratingsOfUser in user.setRatings()
		user.setRatings(ratingList);  //now return user u will get the ratings
		return user;
		
//	****-->important point please 	but here we can see in the postman that even if we r having differnet user its showing the same user in every user rating its bcoz we have static url for rating in .forobject now we have to make it dynamic and the error will be solved even if u change the user to harshil to akhil it will show the rating of harhsil in akhil so now we r making it dynamic,just remove the userId and add +user.getuserId();
	}

	@Override
	public List<User> findAll() {
//		we can implement RAting service call using rest template as we have done above
		return ur.findAll();
	}

	@Override
	public String deleteUser(String userId) {
		User user = ur.findById(userId).get();
		if(user!=null)
		{
			ur.delete(user);
			return "User deleted Successfully!!!!!";
		}
		return "Some error occured!!!!";
	}

	@Override
	public User editUser(User user) {
		return ur.save(user);
	}

}
