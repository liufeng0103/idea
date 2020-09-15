package com.bnade.crawler.wallhaven;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WallhavenClient {

	public List<WallhavenItem> getPage(int page, String type) {
		List<WallhavenItem> items = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://wallhaven.cc/" + type + "?page=" + page).get();
			Elements pageItems = doc.select("figure.thumb");
			for (Element pageItem : pageItems) {
				WallhavenItem item = new WallhavenItem();
				item.setId(pageItem.attr("data-wallpaper-id"));
				item.setResolution(pageItem.select(".wall-res").get(0).text());
				item.setFavoriate(Integer.valueOf(pageItem.select(".wall-favs").text()));
				items.add(item);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return items;
	}

	public String getThumbUrl(String id) {
		return "https://th.wallhaven.cc/small/" + id.substring(0, 2) + "/" + id + ".jpg";
	}

	public String getFullUrl(String id) {
		try {
			Document doc = Jsoup.connect("https://wallhaven.cc/w/" + id).get();
			Element imgEle = doc.getElementById("wallpaper");
			return imgEle.attr("src");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public List<WallhavenItem> getLatestPage(int page) {
		return getPage(page, "latest");
	}

	public List<WallhavenItem> getToplistPage(int page) {
		return getPage(page, "toplist");
	}

	public static void main(String[] args) {
		new WallhavenClient().getToplistPage(1);
		System.out.println(new WallhavenClient().getThumbUrl("39dypd"));
	}

}
