package Src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Init {
	Lectura input = new Lectura();
    
    public Hotel initialize() {
		int initOption = 0;
		Hotel hotel;

		System.out.println("¿Cómo desea inicializar los datos?");
		System.out.println("[1] Hacerlo desde cero");
		System.out.println("[2] Archivo predeterminado para testing -------> OPCION NO VALIDA POR EL MOMENTO");  

		do {
			initOption = input.repeatIntValidity("Elige una opción (1 - 2)");
		} while (initOption > 2);

		System.out.println();

		if (initOption == 1){
			hotel = initializeByHand();
		} else {
			hotel = initializeByFile();
		}

		return hotel;
    }

	public Hotel initializeByHand() {
		//Initialize hotel -> ask for hotel attributes
		String hotelName = input.readLongString("¿Cuál es el nombre de su hotel?");
		String hotelLocation = input.readLongString("Ingrese la dirección del hotel");
		Hotel hotel = new Hotel(hotelName, hotelLocation);

		//Initialize rooms in hotel -> Ask for number of room types, their prices
		int amountOfRoomTypes = input.repeatIntValidity("¿Cuántos tipos de habitaciones tiene el hotel?");
		for (int i = 0; i < amountOfRoomTypes; i++){
			String type = input.readString("Ingrese el tipo de la habitación (ej. sencilla, compartida, familiar)");
			double price = input.repeatDoubleValidity("Ingrese el precio por día de este tipo de habitación");

			hotel.getRoomTypes().add(type);
			int thisRoomType = input.repeatIntValidity("¿Cuántas habitaciones hay de este tipo?");
			System.out.println();

			for (int j = 0; j < thisRoomType; j++){
				Room room = new Room(price, type);
				hotel.getListOfFreeRooms().add(room);
			}
		}
        
		//Initilize employees -> Ask for name, id, phoneNo, location, salary, roles
		int numberOfEmployees = input.repeatIntValidity("¿Cuántos empleados tiene?");
		ArrayList<String> roles = new ArrayList<>(Arrays.asList("recepcionista", "mucama", "chef"));

		for (int i = 0; i < numberOfEmployees; i++){
			String employeeName = input.readLongString("¿Cuál es su nombre?");
			long employeeId = input.repeatLongValidity("¿Cuál es su Id de empleado?");
			long employeePhoneNo = input.repeatLongValidity("¿Cuál es su número de celular");
			String employeeLocation = input.readLongString("¿Cuál es su país natal?");
			double employeeSalary = input.repeatDoubleValidity("¿Cuál es su salario mensual?");
			String role = "";
			do {
				role = input.readLongString("Ingrese su rol [recepcionista, mucama, chef]");
			} while (!roles.contains(role));

			System.out.println();

			switch (role) {
				case "recepcionista":
					Receptionist recepcionist = new Receptionist(employeeName, employeeId, employeePhoneNo, employeeLocation, employeeSalary, role, hotel);
					hotel.getListOfEmployees().add(recepcionist);
					hotel.getListOfReceptionists().add(recepcionist);
					break;
				case "mucama":
					Maid maid = new Maid(employeeName, employeeId, employeePhoneNo, employeeLocation, employeeSalary, true, hotel);
					hotel.getListOfEmployees().add(maid);
					hotel.getListOfMaids().add(maid);
					break;
				case "chef":
					Chef chef = new Chef(employeeName, employeeId, employeePhoneNo, employeeLocation, employeeSalary, hotel);
					hotel.getListOfEmployees().add(chef);
					hotel.getListOfChefs().add(chef);
			}
		}

        return hotel;
	}

	
	public Hotel initializeByFile() {
		Hotel hotel = new Hotel(null, null);
		return hotel;
	}
}
