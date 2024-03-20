package Src;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

public class Hotel {
  private Lectura input = new Lectura();
  private String name;
  private String location;
  private Menu menu;

  private ArrayList<Guest> listOfGuests = new ArrayList<Guest>();
  private ArrayList<Guest> listOfAdultGuests = new ArrayList<Guest>();
  private ArrayList<Guest> listOfAllGuests = new ArrayList<Guest>();
  
  private ArrayList<Employees> listOfEmployees = new ArrayList<Employees>();
  private ArrayList<Chef> listOfChefs = new ArrayList<Chef>();
  private ArrayList<Maid> listOfMaids = new ArrayList<Maid>();
  private ArrayList<Receptionist> listOfReceptionists = new ArrayList<Receptionist>();

  private ArrayList<String> roomTypes = new ArrayList<>();
  private ArrayList<Room> listOfOccupiedRooms = new ArrayList<Room>();
  private ArrayList<Room> listOfFreeRooms = new ArrayList<Room>();
  private ArrayList<Order> listOfOrders = new ArrayList<Order>();

  
  public Hotel(String name, String location) {
    this.name = name;
    this.location = location;
  }

  public void selectRoomType() {
    int option = 0;
    
    System.out.println("Menú de habitaciones");
    for (int i = 1; i < roomTypes.size() + 1; i++){
      String type = roomTypes.get(i - 1);

      //CAMBIAR ACCESO A HABITACIONES DISPONIBLES
      Stream<Room> roomThisType = listOfFreeRooms.stream().filter(room -> room.getType().equals(type));
      System.out.println("[" + i + "] Habitación " + type + " --- " + roomThisType.findAny().get().getPrice());
      // System.out.println("[" + i + "] Habitación " + type + " --- " + roomThisType.findFirst().get().getPrice() + " --- " + roomThisType.count() + " disponibles");
    }

    do {
      option = input.repeatIntValidity("Elige una opción de habitación");
    } while (option > roomTypes.size());

    String type = roomTypes.get(option - 1);
    int roomThisType = (int)listOfFreeRooms.stream().filter(room -> room.getType().equals(type)).filter(roomClean -> roomClean.isClean() == true).count();


    if (roomThisType > 0){
      registerGuest(type);
    } else {
      System.out.println("Elige de las habitaciones disponibles");
      registerGuest(type);
    }
  }
  
  private void registerGuest(String type){
    int amountPeople = input.repeatIntValidity("Cuántas personas van a alojarse?");
		System.out.println("\nPor favor haga el diligenciamiento de registro para ingresar al hotel. " + (amountPeople > 1 ? "Ponga primero el nombre de la persona a quien se le va a facturar" : ""));
    ArrayList<Guest> guestsInRoom = new ArrayList<Guest>();
    Room roomBeingReserved = listOfFreeRooms.stream().filter(room -> room.getType().equals(type)).findFirst().orElse(null);
    int roomId = roomBeingReserved.getId();
    
    for (int i = 0; i < amountPeople; i++){
      String name;
      int edad;
      long id;
      long phoneNo;

      name = input.readString("Ingrese su nombre completo");
      edad = input.repeatIntValidity("Ingrese su edad");

      while (i == 0 && 18 > edad) {
        System.out.println("Ingresa a un mayor de edad responsable primero");
        name = input.readString("Ingrese su nombre completo");
        edad = input.repeatIntValidity("Ingrese su edad");
      }

      id = input.repeatLongValidity("Ingrese su cédula o número de identficación (sin espacios)");
      phoneNo = input.repeatLongValidity("Ingrese su número de celular (sin espacios)");

      Guest guest = new Guest(name, edad, id, phoneNo);
      guest.setRoomId(roomId);

      listOfGuests.add(guest);
      listOfAllGuests.add(guest);
      guestsInRoom.add(guest);
      if (edad >= 18) {
        listOfAdultGuests.add(guest);
      }

      System.out.println("--------------------------------------------------------------");
    }

    listOfOccupiedRooms.add(roomBeingReserved);
    listOfFreeRooms.remove(roomBeingReserved);
    roomBeingReserved.setGuestsRoom(guestsInRoom);
  }

  public void checkOut(int id) {
    Room roomGuestsLeaving = listOfOccupiedRooms.stream().filter(room -> room.getId() == id).findFirst().orElse(null);
    Guest responsible = roomGuestsLeaving.getGuestsInRoom().get(0);
    Bill bill = responsible.getBill();
    bill.showBill();
    responsible.payBill();

    /* 
     * Supongamos que nos dan el Id de la habitación
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getlocation() {
    return location;
  }

  public void setlocation(String location) {
    this.location = location;
  }

  public Menu getMenu() {
    return menu;
  }

  public ArrayList<Employees> getListOfEmployees() {
    return listOfEmployees;
  }

  public ArrayList<Guest> getListOfGuests() {
    return listOfGuests;
  }

  public ArrayList<Guest> getListOfAdultGuests() {
    return listOfAdultGuests;
  }

  public ArrayList<Guest> getListOfAllGuests() {
    return listOfAllGuests;
  }

  public ArrayList<Chef> getListOfChefs() {
    return listOfChefs;
  }

  public ArrayList<Maid> getListOfMaids() {
    return listOfMaids;
  }

  public ArrayList<Receptionist> getListOfReceptionists() {
    return listOfReceptionists;
  }

  public ArrayList<Room> getlistOfOccupiedRooms() {
    return listOfOccupiedRooms;
  }

  public ArrayList<Room> getListOfOccupiedRooms() {
    return listOfOccupiedRooms;
  }

  public ArrayList<Room> getListOfFreeRooms() {
    return listOfFreeRooms;
  }

  public ArrayList<String> getRoomTypes() {
    return roomTypes;
  }

  public ArrayList<Order> getListOfOrders(){
    return listOfOrders;
  }

  @Override
  public String toString() {
    return "Hotel [name=" + name + ", location=" + location + ", menu=" + menu + ", listOfGuests="
        + listOfGuests + ", listOfAllGuests=" + listOfAllGuests + ", listOfOccupiedRooms=" + listOfOccupiedRooms
        + ", listOfFreeRooms=" + listOfFreeRooms + ", listOfOrders" + listOfOrders + "]";
  }

  
  
  
  
}
