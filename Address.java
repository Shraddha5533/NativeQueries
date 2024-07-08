package com.nativequeries.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Address 
{
	@Id
	private int id;
	
	private String street;
	
	private String city;
	
	private String state;
	
	
	@OneToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	// Constructors, getters and setters
    public Address(int id, String street, String city, String state, User user) 
    {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.user = user;
    }

    public Address() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
	
	

}
