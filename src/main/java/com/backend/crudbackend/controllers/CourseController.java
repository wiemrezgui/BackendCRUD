package com.backend.crudbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.crudbackend.models.CourseModel;
import com.backend.crudbackend.services.CourseService;

@CrossOrigin("*")
@RestController
//meme path que le service
@RequestMapping("api/task")
public class CourseController {
	@Autowired
	private CourseService courseserv;
	@GetMapping
	public List<CourseModel> getAllMatches() {
		return courseserv.getAllCourses();
	}
	@PutMapping("/update")
	public CourseModel updateMatch(@RequestBody CourseModel course) {
		return courseserv.update(course);
	}

	@DeleteMapping("delete/{id}")
	public void deleteMatch(@PathVariable Long id) {
		courseserv.delete(id);
	}

	@PostMapping("/create")
	public CourseModel addMatch(@RequestBody CourseModel course) {
		return courseserv.add(course);
	}

	@GetMapping("/{id}")
	public CourseModel getMatchById(@PathVariable Long id) {
		return courseserv.findById(id);
	}
}
