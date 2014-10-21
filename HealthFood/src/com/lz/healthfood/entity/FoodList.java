package com.lz.healthfood.entity;

public class FoodList {

	private String name;
	/** 图片 */
	private String img;
	/** 食品 主要的疗效 */
	private String menu;
	/** 食品 主要的功能 */
	private String bar;
	/** 浏览次数 */
	private String count;
	private String fcount;
	private String rcount;
	/** 食品ID */
	private String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getBar() {
		return bar;
	}
	public void setBar(String bar) {
		this.bar = bar;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getFcount() {
		return fcount;
	}
	public void setFcount(String fcount) {
		this.fcount = fcount;
	}
	public String getRcount() {
		return rcount;
	}
	public void setRcount(String rcount) {
		this.rcount = rcount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
