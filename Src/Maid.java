package Src;

import java.time.LocalDateTime;

public class Maid extends Employees{
    private Hotel hotel;
    private LocalDateTime busyTime;

    public Maid(String name, String id, String phoneNo, String location, double salary, Hotel hotel) {
        super(name, id, phoneNo, location, salary, hotel);
        this.hotel = hotel;
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
        if (hotel.getListOfDirtyRooms().size() > 0 && hotel.getListOfDirtyRooms().size() > hotel.getListOfBusyMaids().size()){
            busyTime = LocalDateTime.now();
            hotel.getListOfBusyMaids().add(this);
            hotel.getListOfMaids().remove(this);
        }
        
        //HISTORIA DE USUARIO 7
        // RESTAR DATOS DE TIEMPO 
    }

    public LocalDateTime getBusyTime() {
        return busyTime;
    }
}
