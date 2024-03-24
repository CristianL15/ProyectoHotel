package Src;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Hotel {
  private Lectura input = new Lectura();
  private String name;
  private String location;
  private Menu menu;
  
  private ArrayList<String> listOfId = new ArrayList<>();
  private ArrayList<Guest> listOfGuests = new ArrayList<>();
  private ArrayList<Guest> listOfAdultGuests = new ArrayList<>();
  private ArrayList<Guest> listOfAllGuests = new ArrayList<>();
  
  private ArrayList<Employees> listOfEmployees = new ArrayList<>();
  private ArrayList<Chef> listOfChefs = new ArrayList<>();
  private ArrayList<Maid> listOfMaids = new ArrayList<>();
  private ArrayList<Receptionist> listOfReceptionists = new ArrayList<>();
  
  private ArrayList<String> listOfComplains = new ArrayList<>();

  private ArrayList<String> roomTypes = new ArrayList<>();
  private ArrayList<Room> listOfOccupiedRooms = new ArrayList<>();
  private ArrayList<Room> listOfFreeRooms = new ArrayList<>();

  private ArrayList<Order> listOfFoodOrders = new ArrayList<>();
  private ArrayList<Order> listOfLaundryOrders = new ArrayList<>();
  private ArrayList<Bill> listOfBills = new ArrayList<>();

  public Hotel(String name, String location) {
    this.name = name;
    this.location = location;
  }

  public void selectRoomType() {
    int option = 0;
    
    System.out.println("Menú de habitaciones:");
    for (int i = 1; i < roomTypes.size() + 1; i++){
      String type = roomTypes.get(i - 1);

      //CAMBIAR ACCESO A HABITACIONES DISPONIBLES
      Stream<Room> roomThisType = listOfFreeRooms.stream().filter(room -> room.getType().equalsIgnoreCase(type));
      int maxOfPeople = listOfFreeRooms.stream().filter(room -> room.getType().equalsIgnoreCase(type)).findFirst().get().getMaxOfPeople();
      double priceThisType = listOfFreeRooms.stream().filter(room -> room.getType().equalsIgnoreCase(type)).findFirst().get().getPrice();

      int roomsAvailables = (int)roomThisType.count();
      System.out.println("[" + i + "] Habitación " + type + " --- $" + priceThisType + " --- " + roomsAvailables + " disponibles --- Capacidad máxima de personas: " + maxOfPeople);
    }

    do {
      option = input.repeatIntValidity("Elige una opción de habitación");
    } while (option > roomTypes.size());

    String type = roomTypes.get(option - 1);
    int roomThisType = (int)listOfFreeRooms.stream().filter(room -> room.getType().equalsIgnoreCase(type) && room.isClean()).count();


    if (roomThisType > 0){
      registerGuest(type);
    } else {
      System.out.println("Elige de las habitaciones disponibles");
      selectRoomType();
    }
  }
  
  private void registerGuest(String type){
    Room roomBeingReserved = listOfFreeRooms.stream().filter(room -> room.getType().equalsIgnoreCase(type) && room.isClean()).findFirst().orElse(null);
    int amountPeople = input.repeatIntValidity("Cuántas personas van a alojarse?");
    if (amountPeople > roomBeingReserved.getMaxOfPeople()) {
      System.out.println();
      System.out.println("El tipo de habitación solo permite " + roomBeingReserved.getMaxOfPeople() + " de personas");
      System.out.println("Elige de nuevo la habitción");
      System.out.println();
      selectRoomType();
    }
    int nights = input.repeatIntValidity("¿Cuántas noches se van a quedar?");
		System.out.println("\nPor favor haga el diligenciamiento de registro para ingresar al hotel. " + (amountPeople > 1 ? "Ponga primero el nombre de la persona a quien se le va a facturar" : ""));
    ArrayList<Guest> guestsInRoom = new ArrayList<Guest>();
    
    for (int i = 0; i < amountPeople; i++){
      String name;
      int edad;
      String id;
      String phoneNo;

      name = input.readString("Ingrese su nombre completo");
      edad = input.repeatIntValidity("Ingrese su edad");

      while (i == 0 && 18 > edad) {
        System.out.println("Ingresa a un mayor de edad responsable primero");
        name = input.readString("Ingrese su nombre completo");
        edad = input.repeatIntValidity("Ingrese su edad");
      }
      
      if (edad > 18) {
        do {
          id = input.readLongString("Ingrese su cédula o número de identficación (sin espacios)");
          if (listOfId.contains(id)){
            System.out.println("Este número de identificación ya está registrado");
          }
        } while(listOfId.contains(id));
        phoneNo = input.readLongString("Ingrese su número de celular (sin espacios)");
      } else {
        id = "";
        phoneNo = "";
      }

      Guest guest = new Guest(name, edad, id, phoneNo, this);
      guest.setNights(nights); 
      guest.setRoom(roomBeingReserved);

      listOfGuests.add(guest);
      listOfAllGuests.add(guest);
      guestsInRoom.add(guest);
      if (edad >= 18) {
        listOfAdultGuests.add(guest);
        listOfId.add(id);
      }

      System.out.println("--------------------------------------------------------------");
    }

    listOfOccupiedRooms.add(roomBeingReserved);
    listOfFreeRooms.remove(roomBeingReserved);
    roomBeingReserved.setGuestsRoom(guestsInRoom);
  }

  //HISTORIA DE USUARIO 3
  public void checkOut(int roomId) {
    Room roomGuestsLeaving = listOfOccupiedRooms.stream().filter(room -> room.getId() == roomId).findFirst().orElse(null);
    Guest responsible = roomGuestsLeaving.getGuestsInRoom().get(0);
    Bill bill = responsible.getBill();
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

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  public void setlocation(String location) {
    this.location = location;
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
  
  public ArrayList<String> getListOfComplains() {
    return listOfComplains;
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

  public ArrayList<Order> getListOfFoodOrders(){
    return listOfFoodOrders;
  }
  
  public ArrayList<Bill> getListOfBills() {
    return listOfBills;
  }


  public ArrayList<Order> getListOfLaundryOrders() {
    return listOfLaundryOrders;
  }

  @Override
  public String toString() {
    return "Hotel [input= " + input + "\n name= " + name + "\n location= " + location + "\n listOfGuests= " + listOfGuests
        + "\n listOfAdultGuests= " + listOfAdultGuests + "\n listOfAllGuests= " + listOfAllGuests + "\n listOfEmployees= "
        + listOfEmployees + "\n listOfChefs= " + listOfChefs + "\n listOfMaids= " + listOfMaids + "\n listOfReceptionists= "
        + listOfReceptionists + "\n roomTypes= " + roomTypes + "\n Menu=" + menu + "\n listOfOccupiedRooms= "
        + listOfOccupiedRooms + "\n listOfFreeRooms= " + listOfFreeRooms + "\n listOfFoodOrders= " + listOfFoodOrders
        + "\n listOfLaundryOrders= " + listOfLaundryOrders + "]";
  }
  
}
