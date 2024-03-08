package com.example;

public class Chef {
	private String name;
	private int Id;
	private String nationality;
	private int ordenNo;
	private double priceOrder;
	private double overPrice = 1;
	
	public Chef(String name, int Id, String nationality) {
		this.name = name;
		this.Id = Id;
		this.nationality = nationality;
	}
	
	public double TakeOrders(String name, int ordenNo) {
		if (this.nationality == "french") {
			this.overPrice = 1.15;
		}
		if (this.ordenNo == 1) {
			this.priceOrder = 12000 * this.overPrice;
		}
		else if (this.ordenNo == 2) {
			this.priceOrder = 16000 * this.overPrice;
		}
		else if (this.ordenNo == 3) {
			this.priceOrder = 20000 * this.overPrice;
		}
		else if (this.ordenNo == 4) {
			this.priceOrder = 10000 * this.overPrice;
		}
		
		return this.priceOrder;
	}
}