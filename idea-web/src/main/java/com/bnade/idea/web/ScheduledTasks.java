package com.bnade.idea.web;

import java.util.Date;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bnade.spider.forum.Forum;
import com.bnade.spider.forum.Topic;
import com.bnade.spider.forum.nga.NgaForum;

@Component
public class ScheduledTasks {
	
	private static List<Topic> topics;
	
	@Scheduled(fixedRate = 10000)
    public void runForumSpider() {
        Forum forum = new NgaForum();
        topics = forum.getPage(1).getTopics();
        System.out.println(new Date() + " " + topics.size());
    }

	public static List<Topic> getTopics() {
		return topics;
	}

	
	
}
