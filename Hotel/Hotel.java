package Hotel;
import java.util.ArrayList;

public class Hotel {
  private Lectura input = new Lectura();
  private String name;
  private String location;
  private int roomsNo;
  private Menu menu;
  
  private ArrayList<Employees> listOfEmployees = new ArrayList<Employees>();
  private ArrayList<Guest> listOfGuests = new ArrayList<Guest>();
  private ArrayList<Guest> listOfAllGuests = new ArrayList<Guest>();
  private ArrayList<Chef> listOfChefs = new ArrayList<Chef>();
  private ArrayList<Maid> listOfMaids = new ArrayList<Maid>();
  private ArrayList<Receptionist> listOfReceptionists = new ArrayList<Receptionist>();
  private ArrayList<Room> listOfOccupiedRooms = new ArrayList<Room>();
  private ArrayList<Room> listOfFreeRooms = new ArrayList<Room>();

  
  public Hotel(String name, String location) {
    this.name = name;
    this.location = location;
  }

  public void selectRoomType() {
    int option = 0;
    
    System.out.println("Menú de habitaciones");
    System.out.println("[1] Habitación sencilla --- 50000");
    System.out.println("[2] Habitación compartida --- 75000");
    System.out.println("[3] Habitación familiar --- 100000");
    System.out.println("[4] Habitación suite --- 200000");
    do {
      option = input.repeatIntValidity("Elige una opción de habitación");
    } while (option > 4 || option < 1);
    switch (option) {
      case 1: 
        selection(50000, "sencilla");
        break;
      case 2: 
        selection(75000, "compartida");
        break;
      case 3: 
        selection(100000, "familiar");
        break;
      case 4:
        selection(200000, "suite");
        break;
    }
  }
  
  private void selection(int price, String type){
    int amountPeople = input.repeatIntValidity("Cuántas personas van a alojarse?");
		System.out.println("\nPor favor haga el diligenciamiento de registro para ingresar al hotel. " + (amountPeople > 1 ? "Inicie por poner el nombre de la persona a cargo" : ""));
    Guest[] guestsInRoom = new Guest[amountPeople];
    
    for (int i = 0; i < amountPeople; i++){
      Guest guest = new Guest();
      guest.checkIn();
      roomsNo++;  //BORRAR DESPUÉS
      listOfGuests.add(guest);
      listOfAllGuests.add(guest);
      guestsInRoom[i] = guest;
      System.out.println("--------------------------------------------------------------");
    }
    listOfOccupiedRooms.add(new Room(roomsNo, price, type, guestsInRoom));
    
    for (Room room : listOfOccupiedRooms){
      System.out.println(room);
    }
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

  public Lectura getInput() {
    return input;
  }

  public ArrayList<Room> getListOfOccupiedRooms() {
    return listOfOccupiedRooms;
  }

  public ArrayList<Room> getListOfFreeRooms() {
    return listOfFreeRooms;
  }

  
}
