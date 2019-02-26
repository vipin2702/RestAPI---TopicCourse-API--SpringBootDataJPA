package com.example.demo.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>
{
	public List<Course> findByTopicId(String any);  // Topic.id
	//public List<Course> findByName(String any);
	//public List<Course> findByDescription(String any);
}
