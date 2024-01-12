package com.backend.crudbackend.controllers;

import java.awt.PageAttributes;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.crudbackend.models.CourseModel;
import com.backend.crudbackend.models.ImageModel;
import com.backend.crudbackend.services.CourseService;

@CrossOrigin("*")
@RestController
//meme path que le service
@RequestMapping("api/task")
public class CourseController {
	@Autowired
	private CourseService courseserv;
	@GetMapping
	public List<CourseModel> getAllCourses() {
		return courseserv.getAllCourses();
	}
	@PutMapping("/update")
	public CourseModel updateCourse(@RequestBody CourseModel course) {
		return courseserv.update(course);
	}

	@DeleteMapping("delete/{id}")
	public void deleteCourse(@PathVariable Long id) {
		courseserv.delete(id);
	}

	@PostMapping(value={"/create"},consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
	public CourseModel addCourse(@RequestPart("course") CourseModel course,
			@RequestPart("imageFile")MultipartFile [] file) {
		
		//return courseserv.add(course);
		try {
			Set<ImageModel> images =uploadImage(file);
			course.setCourseImages(images);
			return courseserv.add(course);
		} catch(Exception e ) {
			return null;
		}
	}
	public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
		  Set<ImageModel> imageModels = new HashSet<>();

		  for (MultipartFile file : multipartFiles) {
		    ImageModel imageModel = new ImageModel(
		      file.getOriginalFilename(),
		      file.getContentType(),
		      file.getBytes()
		    );
		    imageModels.add(imageModel);
		  }
		  return imageModels;
		}
	@GetMapping("/{id}")
	public CourseModel getCourseById(@PathVariable Long id) {
		return courseserv.findById(id);
	}
}
