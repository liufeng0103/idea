package com.bnade.spider.forum.nga;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.bnade.spider.forum.Page;

public class Test {

	public static void main(String[] args) throws Exception {
		Page page = new NgaForum().getPage(1);
		System.out.println(page.getTopics());
		
//		Document doc = Jsoup
//				.connect("http://bbs.nga.cn/thread.php?fid=570")
////				.cookie("ngaPassportUid", "guest05b1d443166810")
////				.cookie("UM_distinctid", "163ea527822276-01399fcf6cb382-47e1e39-306000-163ea52782379d")
////				.cookie("CNZZDATA30043604", "cnzz_eid%3D811291261-1528643894-http%253A%252F%252Fbbs.nga.cn%252F%26ntime%3D1528643894")
////				.cookie("CNZZDATA30039253", "cnzz_eid%3D408647732-1528641648-http%253A%252F%252Fbbs.nga.cn%252F%26ntime%3D1528641648")
////				.cookie("bbsmisccookies", "%7B%7D")
////				.cookie("Hm_lvt_5adc78329e14807f050ce131992ae69b", "1528644683")
////				.cookie("lastpath", "/thread.php?fid=570")
////				.cookie("Hm_lpvt_5adc78329e14807f050ce131992ae69b", "1528644957")
////				.cookie("__uid", "5be1ba8067f921349b09a6edc56d62dd")
////				.cookie("guestJs", "1528644657")
////				.cookie("lastvisit", "1528644951")
//				.header("Cookie", "ngaPassportUid=guest05b1e921ae1580; guestJs=1528730138; UM_distinctid=163ef6ad07164e-0db83e7057d71b-47e1e39-306000-163ef6ad0726de; "
//						+ "CNZZDATA30043604=cnzz_eid%3D673032606-1528724921-http%253A%252F%252Fbbs.nga.cn%252F%26ntime%3D1528724921; "
//						+ "CNZZDATA30039253=cnzz_eid%3D1359631632-1528724895-http%253A%252F%252Fbbs.nga.cn%252F%26ntime%3D1528724895; "
//						+ "lastvisit=1528730140; lastpath=/thread.php?fid=570&lite=xml; bbsmisccookies=%7B%7D; "
//						+ "Hm_lvt_5adc78329e14807f050ce131992ae69b=1528730147; Hm_lpvt_5adc78329e14807f050ce131992ae69b=1528730147")
//				.get();
		// UM_distinctid=161712b526c64c-0bfb9f821214c38-4c322e7d-306000-161712b526d509; CNZZDATA30043604=cnzz_eid%3D1565245894-1518020734-%26ntime%3D1528730321; CNZZDATA30039253=cnzz_eid%3D385345807-1518020702-%26ntime%3D1528730338; bbsmisccookies=%7B%22insad_refreshid%22%3A%7B0%3A%22/fde1b360305582663de71386%22%2C1%3A1518626921%7D%2C%22pv_count_for_insad%22%3A%7B0%3A-41%2C1%3A1518109282%7D%2C%22insad_views%22%3A%7B0%3A1%2C1%3A1518109282%7D%7D; __utma=16065253.138215663.1518023440.1518023440.1518023440.1; __utmz=16065253.1518023440.1.1.utmccn=(direct)|utmcsr=(direct)|utmcmd=(none); lastvisit=1528730920; ngaPassportUid=guest05b1e9528e6643; guestJs=1528730920; __uid=709689bd9b842856ef509afde6ebfed1
//		System.out.println(doc);
		// CNZZDATA30043604
		formatTime(1528730321);
		
		formatTime(1528730338);
		formatTime(1528730920);
		formatTime(1528724921);
		formatTime(1528730138);
	}
	
	public static void formatTime(long time) {
		DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(formater.format(new Date(time * 1000)));
	}
}

