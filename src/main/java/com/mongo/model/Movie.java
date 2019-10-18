package com.mongo.model;

import org.springframework.data.annotation.Id;

public class Movie {
    @Id
    public String id;
    
    public String title;
    
    public String year;
    
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
}
