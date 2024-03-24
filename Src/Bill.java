package Src;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Bill {
  private int id = 0;
  static int count = 0;
  private Guest responsible;
  private ArrayList<Order> orders = new ArrayList<>();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"); 

  public Bill() {
    this.id = ++count;
  }

  public void showBill() {
    double totalPrice = getTotalPrice();
    System.out.println("Factura");
    System.out.println(responsible.getHotel().getName() + "             " + responsible.getHotel().getlocation());
    System.out.println("Código de factura: " + id + "      " + dtf.format(LocalDateTime.now()));
    System.out.println("Cliente: " + responsible.getName() + "          " + responsible.getPhoneNo());
    System.out.println("-----------------------------------------------------------------");
    System.err.println();
    System.out.println("Descripción               Fecha                  Precio");


    for (int i = 0; i < orders.size(); i++) {
      Order order = orders.get(i);
      System.out.println(order.getService() + "           " + order.getDateTime() + "        " + order.getTotalPrice());
    }

    System.out.println();
    System.out.println("Subtotal                                        " + totalPrice);
    System.out.println("Impuestos IVA (19%)                             " + totalPrice * 0.19);
    System.out.println("Total                                           " + totalPrice * 1.19);

  }

  public Guest getResponsibleGuest() {
    return responsible;
  }

  public void setResponsibleGuest(Guest responsible) {
    this.responsible = responsible;
  }

  public void addToBill(Order order) {
    orders.add(order);
  }

  public double getTotalPrice() {
    double totalPrice = 0;
    for (int i = 0; i < orders.size(); i++) {
      Order order = orders.get(i);
      totalPrice += order.getTotalPrice();
    }
    return totalPrice;
  }

  @Override
  public String toString() {
    return "Bill " + id + " --- totalPrice " + getTotalPrice();
  }

  
}
