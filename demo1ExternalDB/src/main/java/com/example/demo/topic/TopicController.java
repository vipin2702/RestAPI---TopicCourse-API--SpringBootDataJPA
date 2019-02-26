package com.example.demo.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicservice;
		
	@RequestMapping("/topics")
	public List<Topic> getTopics() 
	{
		return topicservice.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) 
	{
		return topicservice.getTopic(id);
	}
		
	/*
	 * @RequestMapping("/topics/{foo}") public Topic getTopic1(@PathVariable("foo")
	 * String id) { return topicservice.getOneTopic(id); }
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicservice.addOneTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id ) {
		topicservice.updateOneTopic(topic,id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value ="/topics/{id}")
	public void deleteTopic(@PathVariable String id) 
	{
		topicservice.deleteOneTopic(id);
	}
	
	
}
