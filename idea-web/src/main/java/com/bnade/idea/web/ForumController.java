package com.bnade.idea.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnade.spider.forum.Topic;

@RestController
@RequestMapping("/forums")
public class ForumController {

	@GetMapping("/nga/topics")
	public List<Topic> getNgaTopics() {
		return ScheduledTasks.getNgaTopics();
	}
	
	@GetMapping("/zkb/topics")
	public List<Topic> getZkbTopics() {
		return ScheduledTasks.getZkbTopics();
	}

}
