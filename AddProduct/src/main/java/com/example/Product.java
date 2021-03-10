package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//@Table(name= "pets", schema = "ecommerce")   

	@Entity  
	@Table(name= "pets")
	public class Product {
	//pass in ID -getters and setters
	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long ID;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private String price;
    @Column(name = "color", nullable = false)
    private String color;
    
    public Product() {
        super();
    }
    
    public Product(long id, String name, String color, String price) {
    	
            this.ID = id;
            this.name = name;
            this.price = price;
            this.color = color;
    }
    

    public long getID() {
    	return this.ID; 
    }
    
    public String getName() {
    	return this.name;
    }
    
    public String getPrice() {
    	return this.price;
    }
    
    public String getColor() {
    	return this.color;
    }
    
    public void setID(long id) { 
    	this.ID = id;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setPrice(String petcost) {
    	this.price = petcost;
    }
    
    public void setColor(String color) {
    	this.color = color;
    }
    
    
}


    
    
