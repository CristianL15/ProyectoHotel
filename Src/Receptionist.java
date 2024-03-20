package Src;

public class Receptionist extends Employees{
  Hotel hotel;

  public Receptionist(String name, long id, long phoneNo, String location, double salary, String role, Hotel hotel) {
    super(name, id, phoneNo, location, salary, hotel);
    this.hotel = hotel;
  }

  public void checkInGuests(){
    hotel.selectRoomType();
  }

  public void checkOut(int roomId) {
    hotel.checkOut(roomId);
    /* 
     * Supongamos que nos dan el Id de la habitación
     * Sacar lista de todos los clientes del listado de clientes
     * 
     * Acceder a la lista en guestsInRoom()
     * Acceder al primer Guest de guestsInRoom()
     * Buscar y mostrar Bill del primer guest
     * Hacer pagar el bill al primer Guest
     * Agregar Room a listOfFreeRooms
     * Remover lista de guestsInRoom
     * Remover Guests de listOfGuests
     */

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
