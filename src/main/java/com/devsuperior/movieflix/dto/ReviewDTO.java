package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import com.devsuperior.movieflix.entities.Review;



public class ReviewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;	
	
	private String text;	

	private UserDTO user;	

	private MovieDTO movie;
	
	public ReviewDTO() {
		
	}

	public ReviewDTO(Long id, String text) {		
		this.id = id;
		this.text = text;
	}
	
	public ReviewDTO(Review entity) {
		this.id = entity.getId();
		this.text = entity.getText();
//		if(getFullData) {
//			this.movie.setId(entity.getMovie().getId());
//		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}	
	

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public MovieDTO getMovie() {
		return movie;
	}

	public void setMovie(MovieDTO movie) {
		this.movie = movie;
	}

}
