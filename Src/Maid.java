package Src;

public class Maid extends Employees{
    private boolean available = true;

    public Maid(String name, String id, String phoneNo, String location, double salary, boolean available, Hotel hotel) {
        super(name, id, phoneNo, location, salary, hotel);
        this.available = available;
    }
    
    //Implementar métodos de Maid (Llamado a limpieza de habitación, lavandería)

    public void roomCall(){

    }

    public void laundry(){
        
    }
}
