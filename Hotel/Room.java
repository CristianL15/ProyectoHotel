package Hotel;

import java.util.Arrays;

public class Room {
  private int id;
  private double price;
  private String type;
  private Guest[] guestsInRoom;
  private boolean available = true;
  private boolean clean = true;

  public Room(int id, double price, String type, Guest[] guestsInRoom) {
    this.id = id;
    this.price = price;
    this.type = type;
    this.guestsInRoom = guestsInRoom;
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

  public Guest[] getGuestsInRoom() {
    return guestsInRoom;
  }

  public void setGuestsRoom(Guest[] guestsInRoom) {
    this.guestsInRoom = guestsInRoom;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "Room [id=" + id + ", price=" + price + ", type=" + type + ", guestsInRoom=" + Arrays.toString(guestsInRoom)
        + "]";
  }
  
}
