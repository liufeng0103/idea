package com.bnade.idea.web;

import java.util.Date;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bnade.spider.forum.Forum;
import com.bnade.spider.forum.Topic;
import com.bnade.spider.forum.nga.NgaForum;
import com.bnade.spider.forum.zkb.ZkbForum;

@Component
public class ScheduledTasks {
	
	private static List<Topic> ngaTopics;
	private static List<Topic> zkbTopics;
	
	@Scheduled(fixedRate = 10000)
    public void runForumSpider() {
        Forum forum = new NgaForum();
        List<Topic> topics = forum.getPage(1).getTopics();
        if (topics != null && topics.size() > 0) {
        	ngaTopics = topics;
        	System.out.println(new Date() + " nga " + ngaTopics.size());
        } else {
        	System.out.println(new Date() + " nga 0");
        }

        forum = new ZkbForum();
        topics = forum.getPage(1).getTopics();
        if (topics != null && topics.size() > 0) {
        	zkbTopics = topics;
        	System.out.println(new Date() + " zkb " + zkbTopics.size());
        } else {
        	System.out.println(new Date() + " zkb 0");
        }
    }

	public static List<Topic> getNgaTopics() {
		return ngaTopics;
	}

	public static List<Topic> getZkbTopics() {
		return zkbTopics;
	}
	
}
