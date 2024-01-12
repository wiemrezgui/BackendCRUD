package com.backend.crudbackend.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
@Entity
@Table(name="course")
public class CourseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COURSE_ID")
    private Long id;
    private String name;
    private float price;
    @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinTable(
    	    name = "images",
    	    joinColumns = @JoinColumn(name = "COURSE_ID"),
    	    inverseJoinColumns = @JoinColumn(name = "IMAGE_ID")
    	)

   private Set<ImageModel> courseImages;
    
	public CourseModel() {}

	public CourseModel(String name, float price, Set<ImageModel> courseImages) {
		super();
		this.name = name;
		this.price = price;
		this.courseImages = courseImages;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Set<ImageModel> getCourseImages() {
		return courseImages;
	}

	public void setCourseImages(Set<ImageModel> courseImages) {
		this.courseImages = courseImages;
	}

	
    
}
