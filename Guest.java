package com.example;

public class Guest{
	private String name;
	private int Id;
	FoodItems menu = new FoodItems();
	Lectura mu = new Lectura();
	
	public Guest(String name, int Id) {
		this.name = name;
		this.Id = Id;
	}
	
	public int orderFood() {
		menu.showFoodItems();
		int order = mu.repetirLectura("Elegir un número del menú");
		return order;
	}
	
	public String getName() {
		return this.name;
	}
}