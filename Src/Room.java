package Src;

import java.util.ArrayList;

public class Room {
  static int count = 1;
  private int id;
  private double price;
  private String type;
  private int maxOfPeople;
  private ArrayList<Guest> guestsInRoom;

  public Room(double price, String type, int maxOfPeople) {
    this.id = count++;
    this.price = price;
    this.type = type;
    this.maxOfPeople = maxOfPeople;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public ArrayList<Guest> getGuestsInRoom() {
    return guestsInRoom;
  }

  public void setGuestsRoom(ArrayList<Guest> guestsInRoom) {
    this.guestsInRoom = guestsInRoom;
  }

  public String getType() {
    return type;
  }

  public int getMaxOfPeople() {
    return maxOfPeople;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Room " + id + ", price=" + price + ", type=" + type;
  }
  
}
