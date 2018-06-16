package com.bnade.spider.forum.zkb;

import java.util.HashMap;
import java.util.Map;

import com.bnade.spider.forum.Board;

/**
 * ZKB版块
 * 
 * @author liufeng0103
 *
 */
public class ZkbBoard implements Board {
	
	public final static String PAGE = "/forum-@-page.html";

	public final static int DISCOUNT_INFORMATION = 15;
	
	private static Map<Integer, Board> boardMap;
	
	static {
		boardMap = new HashMap<>();
		boardMap.put(DISCOUNT_INFORMATION, new ZkbBoard(DISCOUNT_INFORMATION, "赚客大家谈", PAGE.replaceAll("@", "" + DISCOUNT_INFORMATION)));
	}
	
	public static Board get(int id) {
		return boardMap.get(id);
	}
	
	private int id;

	private String name;
	
	private String path;

	public ZkbBoard(int id, String name, String path) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ZkbBoard [id=" + id + ", name=" + name + ", path=" + path + "]";
	}

}
