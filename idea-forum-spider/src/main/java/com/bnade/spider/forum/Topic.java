package com.bnade.spider.forum;

/**
 * 论坛帖子信息
 * 
 * @author liufeng0103
 *
 */
public interface Topic {

	/**
	 * 获取帖子id
	 * 
	 * @return 帖子id
	 */
	int getId();

	/**
	 * 获取帖子标题
	 * 
	 * @return 帖子标题
	 */
	String getTitle();

	/**
	 * 获取帖子发布者用户名
	 * @return 帖子发布者用户名
	 */
	String getAuthor();

	/**
	 * 获取帖子链接
	 * 
	 * @return 帖子链接
	 */
	String getLink();

	/**
	 * 获取回帖数
	 * @return
	 */
	int getReplyCount();

	/**
	 * 获取发帖时间
	 * @return
	 */
	long getPostDate();

	/**
	 * 设置帖子id
	 * 
	 * @param id 帖子id
	 */
	void setId(int id);

	/**
	 * 设置帖子标题
	 * 
	 * @param title 帖子标题
	 */
	void setTitle(String title);

	/**
	 * 设置帖子发布者用户名
	 * @param author 帖子发布者用户名
	 */
	void setAuthor(String author);
	
	/**
	 * 设置帖子链接
	 * @param link 帖子链接
	 */
	void setLink(String link);
	
	/**
	 * 设置回帖数
	 * @param replies 回帖数
	 */
	void setReplyCount(int replyCount);
	
	/**
	 * 设置发帖时间
	 * @param postDate 发帖时间
	 */
	void setPostDate(long postDate);
	
	/**
	 * 设置最新回复时间
	 * @param replyDate 回复时间
	 */
	void setReplyDate(long replyDate);
}