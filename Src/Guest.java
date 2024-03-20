package Src;
import java.util.Date;

public class Guest{
	private String name;
	private int edad;
	private long id;
	private long phoneNo;
	private int roomId;
	private Date entryDate;
	private Order order;
	private Bill bill = new Bill();
	private Lectura input = new Lectura();
	private Hotel hotel;

	public Guest(String name, int edad, Hotel hotel) {
		this(name, edad, 0, 0);
		this.hotel = hotel;
	}

	public Guest(String name, int edad, long id, long phoneNo){
		this.name = name;
		this.edad = edad; 
		this.id = id;
		this.phoneNo = phoneNo;
	}
	
	public int checkOut(){
		return this.roomId;
	}
	
	public void payBill(){
		bill.showBill();
		double totalPrice = bill.getTotalPrice();
		System.out.println("El valor a pagar es de: " + totalPrice);
		System.out.println("Pagado");
	}
	
	public void orderFood(){
		hotel.getMenu().showMenu();
		int id = input.repeatIntValidity("Ingrese el id de la comida que quiera");
		hotel.getListOfOrders().add(new Order(id, this));
	}

	public void orderMaid(){
		
	}
	
	public String submitFeedback(){
		return input.readString("");
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
	
	public long getPhoneNo() {
		return phoneNo;
	}
	
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public int getroomId() {
		return roomId;
	}
	
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public Bill getBill(){
		return bill;
	}

	@Override
	public String toString() {
		return "Guest [name=" + name + ", edad=" + edad + ", id=" + id + ", phoneNo=" + phoneNo + "]";
	}
	
}