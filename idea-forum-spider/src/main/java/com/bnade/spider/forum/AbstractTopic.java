package com.bnade.spider.forum;

import com.bnade.spider.forum.Topic;

public abstract class AbstractTopic implements Topic {

	private int id;
	private String title;
	private String author;
	private String link;
	private int replyCount;
	private long postDate;
	private long replyDate;

	public AbstractTopic() {}
	
	public AbstractTopic(Integer id, String link, String title, Integer replyCount, String author, Long postDate) {
		this.id = id;
		this.link = link;
		this.title = title;
		this.replyCount = replyCount;
		this.author = author;
		this.postDate = postDate;
	}
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getLink() {
		return link;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public long getPostDate() {
		return postDate;
	}

	public long getReplyDate() {
		return replyDate;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setReplyCount(int replies) {
		this.replyCount = replies;
	}

	public void setPostDate(long postDate) {
		this.postDate = postDate;
	}

	public void setReplyDate(long replyDate) {
		this.replyDate = replyDate;
	}

	@Override
	public String toString() {
		return "AbstractTopic [id=" + id + ", title=" + title + ", author=" + author + ", link=" + link
				+ ", replyCount=" + replyCount + ", postDate=" + postDate + ", replyDate=" + replyDate + "]";
	}

}
