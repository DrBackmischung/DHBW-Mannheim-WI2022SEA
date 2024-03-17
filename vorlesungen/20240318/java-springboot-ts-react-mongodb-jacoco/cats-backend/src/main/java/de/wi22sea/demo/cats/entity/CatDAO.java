package de.wi22sea.demo.cats.entity;

import java.util.UUID;

public class CatDAO {
	
	private String firstName;
	private String lastName;
	private UUID addressID;
	private String color;
	private int age;
	
	public CatDAO(String firstName, String lastName, UUID addressID, String color, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressID = addressID;
		this.color = color;
		this.age = age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public UUID getAddressID() {
		return addressID;
	}
	
	public void setAddressID(UUID addressID) {
		this.addressID = addressID;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

}
