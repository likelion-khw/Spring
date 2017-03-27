package com.khw.bakery;

import org.springframework.stereotype.Component;

@Component
public class OrderHistoryVO {
	String userid;
	int bakeryid;
	int amount;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getBakeryid() {
		return bakeryid;
	}
	public void setBakeryid(int bakeryid) {
		this.bakeryid = bakeryid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
