package Src;

public class Employees {
  private String name;
  private String id;
  private String phoneNo;
  private String location;
  private double salary;
  private Hotel hotel;
  private boolean working = true;

  public Employees(String name, String id, String phoneNo, String location, double salary, Hotel hotel) {
    this.name = name;
    this.id = id;
    this.phoneNo = phoneNo;
    this.location = location;
    this.salary = salary;
    this.hotel = hotel;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(long salary) {
    this.salary = salary;
  }

  public Hotel getHotel() {
    return hotel;
  }

  public boolean isWorking() {
    return working;
  }

  public void setWorking(boolean working){
    this.working = working;
  }

  @Override
  public String toString() {
    return "Employees [name=" + name + ", id=" + id + ", phoneNo=" + phoneNo + ", location=" + location + ", salary="
        + salary + "]\n";
  }

  

}
