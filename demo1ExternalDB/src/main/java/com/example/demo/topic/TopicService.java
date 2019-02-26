package com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
		
	
	@Autowired
	private TopicRepository topicRepository;
	
	/*
	 * List<Topic> topics = new ArrayList<Topic>( Arrays.asList( new
	 * Topic("spring","spring framework","spring framework description"), new
	 * Topic("java","java framework","java framework description"), new
	 * Topic("javaScript","javascript framework","javascript framework description")
	 * ));
	 */
	
	public List<Topic> getAllTopics()
	{
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}


	public Topic getTopic(String id) {
		return topicRepository.findById(id).orElse(null);
		
		
		//return topics.stream().filter(t-> t.getId().equalsIgnoreCase(id)).findFirst().get();
	}


	public void addOneTopic(Topic topic) {
		topicRepository.save(topic);
		//topics.add(topic);
		
	}


	public void updateOneTopic(Topic topic, String id) 
	{
		topicRepository.save(topic);
		
		
		
		/*
		 * for(int i=0;i<topics.size();i++) {
		 * 
		 * Topic t = topics.get(i); if(t.getId().equalsIgnoreCase(id)) { topics.set(i,
		 * topic); return; } }
		 */
	}


	public void deleteOneTopic(String id) {

		topicRepository.deleteById(id);
		
		//topics.removeIf(t->t.getId().equalsIgnoreCase(id));
	}

	
}
