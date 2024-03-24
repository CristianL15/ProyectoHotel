package Src;
import java.util.ArrayList;
import java.util.Date;

public class Order {
    private Room room;
    private String dateTime;
    private String service;
    private int id;
    private ArrayList<FoodItem> itemsOrdered;
    static int count = 0;
    private double totalPrice = 0;

    public Order(String service, String dateTime, Room room) {
        this.service = service;
        this.dateTime = dateTime;
        this.room = room;
        this.id = ++count;
    }

    public Order(String service, String dateTime, Room room, ArrayList<FoodItem> itemsOrdered) {
        this.service = service;
        this.dateTime = dateTime;
        this.room = room;
        this.itemsOrdered = itemsOrdered;
        this.id = ++count;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public Room getRoom() {
        return room;
    }

    public String getService() {
        return service;
    }
}