package com.backend.crudbackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="course_images")
public class ImageModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IMAGE_ID")
private Long id;
private String name;
private String type;
@Column(length=500000)
private byte[] picByte;
public ImageModel() {}
public ImageModel(String name, String type, byte[] picByte) {
	super();
	this.name = name;
	this.type = type;
	this.picByte = picByte;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public byte[] getPicByte() {
	return picByte;
}
public void setPicByte(byte[] picByte) {
	this.picByte = picByte;
}

}
