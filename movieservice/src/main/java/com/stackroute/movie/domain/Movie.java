package com.stackroute.movie.domain;

//import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//@JsonSerialize
//@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Movie extends ResourceSupport {
	private String Poster;
	private String Title;
	private String Year;
	@Id //for mongo
	//@Id for sql
	private String imdbID;
	private String Description;
	//public Movie(){}
//	public Movie(String Poster, String Title, String Year, String imdbID){
//		this.Poster=Poster;
//		this.Title=Title;
//		this.Year=Year;
//		this.imdbID=imdbID;
//	}
	@JsonProperty("imdbID")
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	@JsonProperty("Poster")
	public String getPoster() {
		return Poster;
	}
	public void setPoster(String poster) {
		Poster = poster;
	}
	@JsonProperty("Title")
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	@JsonProperty("Year")
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	@JsonProperty("Description")
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	

}
