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

  public void generateDailyBalance(){
    System.out.println("Habitaciones ocupadas:");
    for (int i = 0; i < hotel.getListOfOccupiedRooms().size(); i++){
      System.out.println(hotel.getListOfOccupiedRooms().get(i));
    }
    System.out.println("------------------------------------------- \n");
    System.out.println("Habitaciones ocupadas:");
    for (int i = 0; i < hotel.getListOfFreeRooms().size(); i++) {
      System.out.println(hotel.getListOfFreeRooms().get(i));
    }

    System.out.println("------------------------------------------- \n");
    System.out.println("Todas las facturas:");
    double income = 0;
    for (int i = 0; i < hotel.getListOfBills().size(); i++) {
      Bill bill = hotel.getListOfBills().get(i);
      bill.showBill();
      income += bill.getTotalPrice();
      System.out.println("##############################################################");
      System.out.println();
    }
    System.out.println("Ingresos totales en el hotel: $" + income);
  }
  
}
