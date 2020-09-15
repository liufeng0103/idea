package com.bnade.crawler.wallhaven;

import java.io.File;
import java.util.List;

import com.bnade.crawler.util.HttpUtils;

public class WallhavenCrawler {

	public static void main(String[] args) {
		WallhavenClient client = new WallhavenClient();
		int page = 1;
		while (true) {
			List<WallhavenItem> items = client.getLatestPage(page);
			System.out.println("开始下载第 " + page + " 页，共 " + items.size() + " 个图片");
			for (WallhavenItem item : items) {
				String id = item.getId();

				if (isFileExist(id)) {
					System.out.println("文件已存在 " + id);
					continue;
				}

				if (isShutDown()) {
					System.out.println("关闭下载");
					return;
				}

				String fullUrl = client.getFullUrl(id);
				String target = "D://wallpaper/full/" + id.substring(0, 2) + "/" + id
						+ fullUrl.substring(fullUrl.lastIndexOf("."));
				System.out.println("下载 " + item + "到" + target);
				File file = new File(target);
				file.getParentFile().mkdirs();
				HttpUtils.download(client.getFullUrl(id), file);
			}
			// 最后一页停止
			if (items.size() != 24) {
				break;
			}
			page++;
		}
	}

	public static boolean isFileExist(String id) {
		String pre = "D://wallpaper/full/" + id.substring(0, 2) + "/" + id;
		return new File(pre + ".jpg").exists() || new File(pre + ".png").exists();
	}

	public static boolean isShutDown() {
		return new File("shutdown").exists();
	}
}
