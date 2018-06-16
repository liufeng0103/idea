package com.bnade.spider.forum.nga;

import com.bnade.spider.forum.AbstractTopic;
import com.bnade.spider.forum.Topic;

public class NgaTopic extends AbstractTopic implements Topic {

	public NgaTopic() {
	}

	public NgaTopic(Integer id, String link, String title, Integer replyCount, String author, Long postDate) {
		super(id, link, title, replyCount, author, postDate);
	}

}
