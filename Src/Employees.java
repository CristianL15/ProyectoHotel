package Src;

public class Employees {
  private String name;
  private long id;
  private long phoneNo;
  private String location;
  private double salary;
  private Hotel hotel;

  public Employees(String name, long id, long phoneNo, String location, double salary, Hotel hotel) {
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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(long phoneNo) {
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

  @Override
  public String toString() {
    return "Employees [name=" + name + ", id=" + id + ", phoneNo=" + phoneNo + ", location=" + location + ", salary="
        + salary + "]\n";
  }

  

}
