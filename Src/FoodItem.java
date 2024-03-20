package Src;

public class FoodItem{
	private String name;
	private long id;
	private double price;

	public FoodItem(String name, long id, double price) {
		this.name = name;
		this.id = id;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "name=" + name + ", id=" + id + ", price=" + price + "\n";
	}
	
}
