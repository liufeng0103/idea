package com.bnade.spider.forum.zkb;

import com.bnade.spider.forum.AbstractTopic;
import com.bnade.spider.forum.Topic;

public class ZkbTopic extends AbstractTopic implements Topic {

	public ZkbTopic() {
	}

	public ZkbTopic(Integer id, String link, String title, Integer replyCount, String author, Long postDate) {
		super(id, link, title, replyCount, author, postDate);
	}
	
}
