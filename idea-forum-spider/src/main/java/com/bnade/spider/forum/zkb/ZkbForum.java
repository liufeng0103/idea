package com.bnade.spider.forum.zkb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bnade.spider.forum.Board;
import com.bnade.spider.forum.Forum;
import com.bnade.spider.forum.Page;
import com.bnade.spider.forum.Topic;

/**
 * 赚客吧论坛
 * 
 * @author liufeng0103
 *
 */
public class ZkbForum implements Forum {

	private static final String HOST = "http://www.zuanke8.com";

	private Board defaultBoard = ZkbBoard.get(ZkbBoard.DISCOUNT_INFORMATION);
	
	private Board board = defaultBoard;
	
	private int pageNumber = 1;

	/**
	 * 生成页面访问的url
	 * 
	 * @return
	 */
	protected String generateUrl() {
		String url =  HOST + board.getPath().replaceAll("page", "" + pageNumber);
		return url;
	}
	
	protected Page convertUrlToPage() {
		Page page = new ZkbPage(board, pageNumber);
		List<Topic> topics = new ArrayList<>();
		page.setTopics(topics);
		try {
			Document doc = Jsoup
					.connect(generateUrl())
					.get();
			Elements rows = doc.getElementsByTag("tbody");
			for (Element row : rows) {
				if (row.attr("id").indexOf("normalthread_") == 0) {
					int id = Integer.valueOf(row.attr("id").substring("normalthread_".length()));
					String title = row.select(".new a").get(0).text();
					String xw1 = row.select(".new .xw1").text();
					if (xw1.length() > 0) {
						title += " - [阅读权限 " + xw1 + "]";
					}
					String author = row.select(".by a").get(0).text();
					String link = row.select(".new a").attr("href");
					String replies = row.select(".num a").text();
					Topic topic = new ZkbTopic(id, link, title, Integer.valueOf(replies), author,
							0L);
					topics.add(topic);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return page;
	}

	@Override
	public Board getBoard() {
		return board;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public Page getPage(int pageNumber) {
		this.pageNumber = pageNumber;
		return convertUrlToPage();
	}

	@Override
	public Page getPage(int boardId, int pageNumber) {
		this.board = ZkbBoard.get(boardId);
		this.pageNumber = pageNumber;
		return convertUrlToPage();
	}

	@Override
	public void setBoard(Board board) {
		this.board = board;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

}
