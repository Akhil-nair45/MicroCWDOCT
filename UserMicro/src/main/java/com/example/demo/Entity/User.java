package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "micro_users")
public class User {

	@Id
	@Column(name = "ID")
	private String userId;
	
	@Column(name = "Name", length=20)
	private String name;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "About")
	private String about;
	
	@Transient  // transient is used to let the compiler know that this shouldnot be stored in db
	private List<Rating> ratings = new ArrayList<>(); //array list is written just to get data in square bracket without it the output was null u can see it by removing the arraylist
	
}
