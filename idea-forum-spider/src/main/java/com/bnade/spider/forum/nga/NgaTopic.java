package com.bnade.spider.forum.nga;

import com.bnade.spider.forum.Topic;

public class NgaTopic implements Topic {

	private int id;
	private String title;
	private String author;
	private String link;
	private int replyCount;
	private long postDate;
	private long replyDate;

	public NgaTopic() {
	}

	public NgaTopic(Integer id, String link, String title, Integer replyCount, String author, Long postDate) {
		this.id = id;
		this.link = link;
		this.title = title;
		this.replyCount = replyCount;
		this.author = author;
		this.postDate = postDate;
	}

	@Override
	public String toString() {
		return "Topic{" + "id=" + id + ", link='" + link + '\'' + ", title='" + title + '\'' + ", replyCount=" + replyCount
				+ ", author='" + author + '\'' + ", postDate=" + postDate + '}';
	}

	public int getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see com.bnade.idea.nga.Topic#getTitle()
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/* (non-Javadoc)
	 * @see com.bnade.idea.nga.Topic#getAuthor()
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see com.bnade.idea.nga.Topic#setTitle(java.lang.String)
	 */
	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	/* (non-Javadoc)
	 * @see com.bnade.idea.nga.Topic#setAuthor(java.lang.String)
	 */
	@Override
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
	
	
}
