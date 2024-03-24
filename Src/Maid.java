package Src;

public class Maid extends Employees{
    private boolean available = true;
    private Hotel hotel;

    public Maid(String name, String id, String phoneNo, String location, double salary, boolean available, Hotel hotel) {
        super(name, id, phoneNo, location, salary, hotel);
        this.hotel = hotel;
        this.available = available;
    }
    
    //Implementar métodos de Maid (Llamado a limpieza de habitación, lavandería)

    public void doLaundry(){
        if (hotel.getListOfLaundryOrders().size() > 0) {
            Order order = hotel.getListOfLaundryOrders().get(0);
            hotel.getListOfLaundryOrders().remove(order);
            Guest responsible = order.getRoom().getGuestsInRoom().get(0);
            responsible.getBill().addToBill(order);
        } else {
            System.out.println("No hay órdenes pendientes");
        }
    }

    public void cleanRoom() {
        //HISTORIA DE USUARIO 7
        available = false;
        // RESTAR DATOS DE TIEMPO 
    }
}
