package com.example.demo.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
		
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getCourses(@PathVariable String id) 
	{
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) 
	{
		return courseService.getOneCourse(id);
	}
		
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		
		course.setTopic(new Topic(topicId,"",""));
		courseService.addOneCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId ) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateOneCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value ="/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id) 
	{
		courseService.deleteOneCourse(id);
	}
	
	
}
