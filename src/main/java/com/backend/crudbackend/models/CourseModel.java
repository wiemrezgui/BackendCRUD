package com.backend.crudbackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="course")
public class CourseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COURSE_ID")
    private Long id;
    private String name;
    private float price;
    @Column(name = "image",length=1000)
	private byte[] image;
    
	public CourseModel() {}

	public CourseModel(String name, float price, byte[] image) {
		super();
		this.name = name;
		this.price = price;
		this.image = image;
	}
    
}
