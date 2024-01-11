package com.backend.crudbackend.services;

import java.util.List;

import com.backend.crudbackend.models.CourseModel;

public interface CourseService {
	public List<CourseModel> getAllCourses();
	public CourseModel update(CourseModel course);
	public void delete(Long id);
	public CourseModel add(CourseModel course);
	public CourseModel findById(Long id);
}
