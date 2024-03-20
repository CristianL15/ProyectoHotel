package Src;
import java.util.Hashtable;
import java.util.Map;

public class Bill {
  private Hashtable<String, Double> bill = new Hashtable<String, Double>();

  public void showBill() {
    bill.forEach((product, price) -> System.out.println("Product: " + product + " --- price: " + price + "\n"));
  }

  public double getTotalPrice() {
    double totalPrice = 0;
    for (Map.Entry<String, Double> entry : bill.entrySet()) {
      totalPrice += entry.getValue();
    }
    return totalPrice;
  }

  public void addItem(String product, double price) {
    bill.put(product, price);
  }

  public void removeItem(String product){
    bill.remove(product);
  }
}
