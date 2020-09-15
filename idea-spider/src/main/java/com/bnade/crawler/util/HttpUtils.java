package com.bnade.crawler.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtils {

	public static void download(String urlStr, File target) {
		try {
			URL url = new URL(urlStr);
			URLConnection con = url.openConnection();
			// 设置超时，防止网络不好时阻塞线程
			con.setConnectTimeout(5000);
			con.setReadTimeout(5000);
			// Request Headers
			con.setRequestProperty("Accept",
					"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			con.setRequestProperty("Accept-Encoding", "gzip, deflate, sdch, br");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4");
			con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

			try (InputStream is = con.getInputStream(); FileOutputStream os = new FileOutputStream(target, true)) {
				byte[] bs = new byte[1024];
				int len;

				while ((len = is.read(bs)) != -1) {
					os.write(bs, 0, len);
				}
				System.out.println("下载完成 " + urlStr);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
