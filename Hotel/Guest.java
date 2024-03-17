package Hotel;

public class Guest{
	private String name;
	private int edad;
	private long id;
	private long phoneNo;
	private int roomNo;
	private Order order;
	private Bill bill;
	private Lectura input = new Lectura();

	public Guest() {
	}

	public Guest(String name, int edad, long id, long phoneNo){
		this.name = name;
		this.edad = edad;
		if (edad >= 18) {
			this.id = id;
			this.phoneNo = phoneNo;
		}
	}
	
	public void checkIn(){
		
		 //Falta asignación de habitaciones -> Llamar a receptionist.checkRoomAvailability y receptionist.bookRoom()
		name = input.readLongString("Ingrese su nombre completo");
		edad = input.repeatIntValidity("Ingrese su edad");
		if (edad >= 18){
			id = input.repeatLongValidity("Ingrese su cédula o número de identficación (sin espacios)");
			phoneNo = input.repeatLongValidity("Ingrese su número de celular (sin espacios)");
		}
	}
	
	public String checkOut(){

		/*
		* envío de Bill()
		* Liberar habitación room.available
		*/
		
		this.payBill();
		String feedback = this.submitFeedback();
		// registrar cobro de 
		return feedback;
	}
	
	public void payBill(){
		//Solicitar cuenta total de Bill()
	}
	
	public void orderFood(){
		
	}
	
	public String submitFeedback(){
		return input.readLongString("Le gustaría dejar una reserña sobre el hotel?");
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
	
	public int getRoomNo() {
		return roomNo;
	}
	
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public Bill getBill() {
		return bill;
	}
	
	public void setBill(Bill bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "Guest [name=" + name + ", edad=" + edad + ", id=" + id + ", phoneNo=" + phoneNo + "]";
	}
	
}