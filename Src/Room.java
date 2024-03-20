package Src;

import java.util.ArrayList;

public class Room {
  static int count = 1;
  private int id;
  private double price;
  private String type;
  private ArrayList<Guest> guestsInRoom;
  private boolean clean = true;

  public Room(double price, String type) {
    this.id = count++;
    this.price = price;
    this.type = type;
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

  public void setType(String type) {
    this.type = type;
  }

  public boolean isClean() {
    return clean;
  }

  public void setClean(boolean clean) {
    this.clean = clean;
  }

  @Override
  public String toString() {
    return "Room [id=" + id + ", price=" + price + ", type=" + type + ", guestsInRoom=" + guestsInRoom + ", clean=" + clean + "]";
  }

  
}
