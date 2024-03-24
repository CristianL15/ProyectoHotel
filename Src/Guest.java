package Src;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Guest{
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"); 
	private String name;
	private int edad;
	private String id;
	private String phoneNo;
	private Room room;
	private String entryDate;
	private Order order;
	private Bill bill = new Bill();
	private Lectura input = new Lectura();
	private Hotel hotel; 
	private int nights; 

	public Guest(String name, int edad, Hotel hotel) {
		this(name, edad, "", "", hotel);
		this.hotel = hotel;
		entryDate = dtf.format(LocalDateTime.now());
	}

	public Guest(String name, int edad, String id, String phoneNo, Hotel hotel){
		this.name = name;
		this.edad = edad; 
		this.id = id;
		this.phoneNo = phoneNo;
		this.hotel = hotel;
		entryDate = dtf.format(LocalDateTime.now());
	}
	
	//HISTORIA DE USUARIO 3
	public void checkOut(){
		for (Guest guest : room.getGuestsInRoom()){
			if (guest.getEdad() >= 18){
				hotel.getListOfAdultGuests().remove(guest);
			}
			hotel.getListOfGuests().remove(guest);
		}
		Order order = new Order("habitación", dtf.format(LocalDateTime.now()), room);
		order.setTotalPrice(room.getPrice() * nights);
		bill.addToBill(order);
		payBill();
		room.setClean(false);
		room.setGuestsRoom(null);		
	}
	
	//HISTORIA DE USUARIO 3
	public void payBill(){
		Guest responsible = room.getGuestsInRoom().get(0);
		bill.showBill(responsible);
		System.out.println("Pagado");
	}
	
	public void order(){
		System.out.println("[1] Ordenar comida");
		System.out.println("[2] Ordenar servicio de lavandería");
		int service = 3;
		while (service > 2) { 
			service = input.repeatIntValidity("¿Qué servicio desea ordenar");
		}
		System.out.println();

		if (service == 1){
			orderFood();
		}
		if (service == 2) {
			orderLaundry();  //FALTA CÓDIGO PARA SERVICIO DE LAVANDERÍA
		}
	}

	public void orderFood() {
		Menu menu = hotel.getMenu();
		menu.showMenu();
		ArrayList<FoodItem> itemsOrdered = new ArrayList<>();
		System.out.println();
		System.out.println("¿Qué desea ordenar?");
		String keepOrdering = "si";
		int totalPrice = 0;
		while (!keepOrdering.equalsIgnoreCase("no")){
			int itemOption = input.repeatIntValidity("Elija el número del item");
			FoodItem foodItem = menu.getMenu().get(itemOption - 1);
			int itemAmount = input.repeatIntValidity("Ingrese la cantidad a pedir de este platillo");
			totalPrice += foodItem.getPrice() * itemAmount;
			for (int i = 0; i < itemAmount; i++){
				itemsOrdered.add(foodItem);
			}
			keepOrdering = input.readString("¿Desea ordenar algo más? si/no");
		}
		Order order = new Order("comida", dtf.format(LocalDateTime.now()), room, itemsOrdered);
		order.setTotalPrice(totalPrice);
		hotel.getListOfFoodOrders().add(order);
	}

	public void orderLaundry() {
		//FALTA CÓDIGO PARA SERVICIO DE LAVANDERÍA
		Order order = new Order("lavandería", dtf.format(LocalDateTime.now()), room);
		order.setTotalPrice(50000);
		hotel.getListOfLaundryOrders().add(order);
	}
	
	public void complain(){
		String complain = input.readString("Por favor ingrese su queja y siendo lo más amable posible");
		hotel.getListOfComplains().add(complain);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad() {
		this.edad = edad;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getNights() {
		return nights;
	}

	public void setNights(int nights) {
		this.nights = nights;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}

	public Bill getBill(){
		return bill;
	}

	public Hotel getHotel() {
		return hotel;
	}

	@Override
	public String toString() {
		return "Guest [name=" + name + ", edad=" + edad + ", id=" + id + ", phoneNo=" + phoneNo + "]";
	}
	
}