package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.Hotel;
import com.example.demo.Repository.HotelRepo;
import com.example.demo.ServiceImpl.HotelServiceImpl;



@SpringBootTest(classes= {ServiceMockitoTest.class})
public class ServiceMockitoTest {

	@Mock
	HotelRepo hr;
	
	@InjectMocks
	HotelServiceImpl hs;
	

	
	public java.util.List<Hotel> myHotels;
	
	@Test
	@Order(1)
	public void test_findAll()
	{
		List<Hotel> myHotels= new ArrayList<Hotel>();
		myHotels.add(new Hotel("1","Taj skyline","Ahmedabad","7star hotel"));
		myHotels.add(new Hotel("2","The Ummed","Ahmedabad","5 star hotel"));
		myHotels.add(new Hotel("3","The Fern","Ahmedabad","3star hotel"));
		when(hr.findAll()).thenReturn(myHotels);
		assertEquals(1,hs.findAll().size());
	}
	
	
	@Test
	@Order(2)
	public void testFindHotelById() {
        // Create a sample hotel
        String hotelId = "1";
        Hotel sampleHotel = new Hotel(hotelId, "Sample Hotel", "Sample Location", "Sample Description");

        // Mock the behavior of the HotelRepository
        Mockito.when(hr.findById(hotelId)).thenReturn(java.util.Optional.of(sampleHotel));

        // Call the service method
        Hotel resultHotel = hs.findHotelById(hotelId);

        // Verify the result
        assertNotNull(resultHotel);
        assertEquals(hotelId, resultHotel.getId());
        assertEquals("Sample Hotel", resultHotel.getName());
        assertEquals("Sample Location", resultHotel.getLocation());
        assertEquals("Sample Description", resultHotel.getAbout());
    }
}
