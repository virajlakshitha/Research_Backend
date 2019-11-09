package com.tech.ring.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Hard_Disk")
public class Hard_disk {
	
	@Id
	private String id;

	private String name;

	private String speed;

	private String size;

	private String type;

	private String price;

	private String warranty;
	
	private String image;
	
	private String owner;
	
	private String points;
	
	private String user_rating;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getUser_rating() {
		return user_rating;
	}

	public void setUser_rating(String user_rating) {
		this.user_rating = user_rating;
	}

}
