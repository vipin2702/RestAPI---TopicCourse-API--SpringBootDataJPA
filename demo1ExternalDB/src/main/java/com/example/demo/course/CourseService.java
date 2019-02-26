package com.example.demo.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId)
	{
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}

	public Course getOneCourse(String id) {
		return courseRepository.findById(id).orElse(null);
		
	}

	public void addOneCourse(Course course) {
		courseRepository.save(course);
	}


	public void updateOneCourse(Course course) 
	{
		courseRepository.save(course);
		
	}

	public void deleteOneCourse(String id) {

		courseRepository.deleteById(id);
	}

	
}
