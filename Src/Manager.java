package Src;

public class Manager extends Employees {
    Hotel hotel;
    public Manager(String name, String id, String phoneNo, String location, double salary, Hotel hotel) {
        super(name, id, phoneNo, location, salary, hotel);

        this.hotel = hotel;
    }

    //Implementar funcionalidad para manager (manejo de inventario)
    
}
