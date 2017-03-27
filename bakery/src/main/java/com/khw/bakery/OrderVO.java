package com.khw.bakery;

public class OrderVO {
	
	String bakeryname;
	int price;
	int amount;
	String orderdate;
	int pay;
	int money;
	
	@Override
	public String toString() {
		return "OrderVO [bakeryname=" + bakeryname + ", price=" + price + ", amount=" + amount + ", orderdate="
				+ orderdate + ", pay=" + pay + ", money=" + money + "]";
	}
	public String getBakeryname() {
		return bakeryname;
	}
	public void setBakeryname(String bakeryname) {
		this.bakeryname = bakeryname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	

}
