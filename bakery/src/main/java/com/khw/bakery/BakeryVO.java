package com.khw.bakery;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class BakeryVO {
	int bakeryid;
	String bakeryname;
	double price;
	int balance;
	MultipartFile file;
	String image ="resources/image/";
	
	public int getBakeryid() {
		return bakeryid;
	}
	public void setBakeryid(int bakeryid) {
		this.bakeryid = bakeryid;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
		this.image = this.image + file.getOriginalFilename();
	}
	public String getBakeryname() {
		return bakeryname;
	}
	public void setBakeryname(String bakeryname) {
		this.bakeryname = bakeryname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
