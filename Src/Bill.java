package Src;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Bill {
  private int id = 0;
  static int count = 0;
  private ArrayList<Order> orders = new ArrayList<>();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy"); 

  public Bill() {
    this.id = ++count;
  }

  public void showBill(Guest guest) {
    double totalPrice = 0;
    System.out.println("Factura");
    System.out.println(guest.getHotel().getName() + "             " + guest.getHotel().getlocation());
    System.out.println("Código de factura: " + id + "      " + dtf.format(LocalDateTime.now()));
    System.out.println("Cliente: " + guest.getName() + "          " + guest.getPhoneNo());
    System.out.println("-----------------------------------------------------------------");
    System.err.println();
    System.out.println("Descripción                      Precio");


    for (int i = 0; i < orders.size(); i++) {
      Order order = orders.get(i);
      totalPrice += order.getTotalPrice();
      System.out.println(order.getService() + "                      " + order.getTotalPrice());
    }
    
    System.out.println();
    System.out.println("Subtotal                         " + totalPrice);
    System.out.println("Impuestos IVA (19%)              " + totalPrice * 0.19);
    System.out.println("Total                            " + totalPrice * 1.19);

  }

  public void addToBill(Order order) {
    orders.add(order);
  }

}
