package Src;
import java.util.Hashtable;

public class Order {
    private Guest guest;
    private Hashtable<String, Double> orders = new Hashtable<String, Double>();
    private int id; 

    public Order(int id, Guest guest) {
        this.guest = guest;
        this.id = id;
    }

    public void addItem(String product, double price) {
        orders.put(product, price);
        guest.getBill().addItem(product, price);
    }

    public void removeItem(String product){
        orders.remove(product);
    }
}
