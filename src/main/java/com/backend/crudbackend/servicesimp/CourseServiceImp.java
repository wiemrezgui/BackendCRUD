package com.backend.crudbackend.servicesimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.crudbackend.models.CourseModel;
import com.backend.crudbackend.repositories.CourseRepository;
import com.backend.crudbackend.services.CourseService;

@Service
public class CourseServiceImp implements CourseService{
@Autowired
private CourseRepository courserepo;
	@Override
	public List<CourseModel> getAllCourses() {
		return courserepo.findAll();
	}

	@Override
	public CourseModel update(CourseModel course) {
		// TODO Auto-generated method stub
		return courserepo.save(course);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		courserepo.deleteById(id);
	}

	@Override
	public CourseModel add(CourseModel course) {
		// TODO Auto-generated method stub
		return courserepo.save(course);
	}

	@Override
	public CourseModel findById(Long id) {
		Optional<CourseModel> courses = courserepo.findById(id);
		return courses.isPresent() ? courses.get() : null;
	}

}
