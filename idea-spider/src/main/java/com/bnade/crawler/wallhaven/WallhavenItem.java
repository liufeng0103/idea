
package com.bnade.crawler.wallhaven;

public class WallhavenItem {

	private String id;

	private String resolution;

	private int favoriate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public int getFavoriate() {
		return favoriate;
	}

	public void setFavoriate(int favoriate) {
		this.favoriate = favoriate;
	}

	@Override
	public String toString() {
		return "WallhavenItem [id=" + id + ", resolution=" + resolution + ", favoriate=" + favoriate + "]";
	}

}
