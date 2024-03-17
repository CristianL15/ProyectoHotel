package Hotel;

public class Maid extends Employees{
    private boolean available = true;

    public Maid(String name, long id, long phoneNo, String location, long salary, String role, boolean available) {
        super(name, id, phoneNo, location, salary, role);
        this.available = available;
    }
    
}
