package Src;

import java.util.ArrayList;

public class Guest{
	private String name;
	private int edad;
	private String id;
	private String phoneNo;
	private Room room;
	// private entryDate; //BUSCAR ENTRADA DE FECHAS
	private Order order;
	private Bill bill = new Bill();
	private Lectura input = new Lectura();
	private Hotel hotel; 

	public Guest(String name, int edad, Hotel hotel) {
		this(name, edad, "", "");
		this.hotel = hotel;
	}

	public Guest(String name, int edad, String id, String phoneNo){
		this.name = name;
		this.edad = edad; 
		this.id = id;
		this.phoneNo = phoneNo;
	}
	
	//HISTORIA DE USUARIO 3
	public int checkOut(){
		return this.edad;
	}
	
	//HISTORIA DE USUARIO 3
	public void payBill(){
		bill.showBill();
		double totalPrice = bill.getTotalPrice();
		System.out.println("El valor a pagar es de: " + totalPrice);
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

		ArrayList<FoodItem> items = new ArrayList<>();
		if (service == 1){
		}
		if (service == 2) {
			//FALTA CÓDIGO PARA SERVICIO DE LAVANDERÍA
		}
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
	
	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}

	public Bill getBill(){
		return bill;
	}

	@Override
	public String toString() {
		return "Guest [name=" + name + ", edad=" + edad + ", id=" + id + ", phoneNo=" + phoneNo + "]";
	}
	
}