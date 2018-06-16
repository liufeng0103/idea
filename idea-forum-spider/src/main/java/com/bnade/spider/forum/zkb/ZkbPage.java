package com.bnade.spider.forum.zkb;

import java.util.List;

import com.bnade.spider.forum.Board;
import com.bnade.spider.forum.Page;
import com.bnade.spider.forum.Topic;

public class ZkbPage implements Page {
	
	private Board board;
	
	private int number;
	
	private int totalNumber;
	
	private List<Topic> topics;
	
	public ZkbPage() {}
	
	public ZkbPage(Board board, int number) {
		super();
		this.board = board;
		this.number = number;
	}

	public Board getBoard() {
		return board;
	}

	public int getNumber() {
		return number;
	}

	public int getTotalNumber() {
		return totalNumber;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	
}
