package de.wi22sea.demo.cats.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import de.wi22sea.demo.cats.mongodb.UuidIdentifiedEntity;

@Document
public class Cat extends UuidIdentifiedEntity {
    
    @Field("lastName")
    private String lastName;
    
    @Field("firstName")
    private String firstName;
    
    @Field("address")
    @DBRef
    private Address address;

	@Field("color")
	private String color;

	@Field("age")
	private int age;

	public Cat(String lastName, String firstName, Address address, String color, int age) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.color = color;
		this.age = age;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public long getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}