package de.wi22sea.demo.cats.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import de.wi22sea.demo.cats.mongodb.UuidIdentifiedEntity;

@Document
public class Address extends UuidIdentifiedEntity {
    
    @Field("street")
    private String street;
    
    @Field("houseNr")
    private String houseNr;
    
    @Field("city")
    private String city;
    
    @Field("zip")
    private String zip;

	public Address(String street, String houseNr, String city, String zip) {
		super();
		this.street = street;
		this.houseNr = houseNr;
		this.city = city;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNr() {
		return houseNr;
	}

	public void setHouseNr(String houseNr) {
		this.houseNr = houseNr;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
