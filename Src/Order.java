package Src;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private Guest guest;
    private ArrayList<Object> orders = new ArrayList<>();
    private int id;
    static int count = 0;

    public Order(String service, Date FECHA, Guest guest) {
        this.guest = guest;
        this.id = ++count;
    }
    
    public Order(String service, Date FECHA, Guest guest, ArrayList<Object> items) {
        this.guest = guest;
        this.id = ++count;
    }

    public int getId() {
        return id;
    }
}
