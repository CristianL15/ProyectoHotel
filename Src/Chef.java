package Src;

public class Chef extends Employees{
	private Hotel hotel;
	private String location;

	public Chef(String name, String id, String phoneNo, String location, double salary, Hotel hotel) {
		super(name, id, phoneNo, location, salary, hotel);
		this.hotel = hotel;
		this.location = location;
	}

	public void takeOrder(){
		if (hotel.getListOfFoodOrders().size() > 0){
			Order order = hotel.getListOfFoodOrders().get(0);
			if (location.equalsIgnoreCase("Francia")){
				double totalPrice = order.getTotalPrice();
				order.setTotalPrice(totalPrice * 1.15);
			}
			hotel.getListOfFoodOrders().remove(order);
			Guest responsible = order.getRoom().getGuestsInRoom().get(0);
			responsible.getBill().addToBill(order);
		} else {
			System.out.println("No hay órdenes pendientes");
		}
	}

}