package Hotel;

public class Employees {
  private String name;
  private long id;
  private long phoneNo;
  private String location;
  private long salary;
  private String role;

  public Employees(String name, long id, long phoneNo, String location, long salary, String role) {
    this.name = name;
    this.id = id;
    this.phoneNo = phoneNo;
    this.location = location;
    this.salary = salary;
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

  public long getSalary() {
    return salary;
  }

  public void setSalary(long salary) {
    this.salary = salary;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "Employees [name=" + name + ", id=" + id + ", phoneNo=" + phoneNo + ", location=" + location + ", salary="
        + salary + "]\n";
  }

  

}
