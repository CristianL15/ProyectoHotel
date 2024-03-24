package Src;

public class Receptionist extends Employees{
  Hotel hotel;

  public Receptionist(String name, String id, String phoneNo, String location, double salary, Hotel hotel) {
    super(name, id, phoneNo, location, salary, hotel);
    this.hotel = hotel;
  }

  public void checkInGuests(){
    hotel.selectRoomType();
  }
  
  public void bookRoom(){
    //MÉTODO PARA HACER RESERVACIONES, POR AHORA NO ES NECESARIO
  }
  
  public void generateBill(Guest guest){
  }

  //HISTORIA DE USUARIO 5
  public void generateDailyBalance(){

  }
  
  public void acceptCustomerFeedback(){
    
  }
  
  
}
