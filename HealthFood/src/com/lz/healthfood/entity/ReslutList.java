package com.lz.healthfood.entity;

import java.util.List;

public class ReslutList<T> {
	private String success;
	private String total;
	private List<T> yi18;
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<T> getYi18() {
		return yi18;
	}
	public void setYi18(List<T> yi18) {
		this.yi18 = yi18;
	}
}
