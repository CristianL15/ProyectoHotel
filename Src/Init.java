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
		System.out.println("[2] Ya inicializados");
		System.out.println("[3] Por archivo -------> OPCION NO VALIDA POR EL MOMENTO");

		do {
			initOption = input.repeatIntValidity("Elige una opción (1 - 3)");
		} while (initOption > 3);

		System.out.println();

		if (initOption == 1){
			hotel = initializeByHand();
		} else if (initOption == 2) {
			hotel = initilizeByDefault();
		} else {
			hotel = initializeByFile();
		}

		return hotel;
    }

	public Hotel initializeByHand() {
		//INITIALIZE HOTEL
		String hotelName = input.readLongString("¿Cuál es el nombre de su hotel?");
		String hotelLocation = input.readLongString("Ingrese la dirección del hotel");
		Hotel hotel = new Hotel(hotelName, hotelLocation);

		//INITIALIZE ROOMS IN HOTEL
		int amountOfRoomTypes = input.repeatIntValidity("¿Cuántos tipos de habitaciones tiene el hotel?");
		for (int i = 0; i < amountOfRoomTypes; i++){
			String type = input.readString("Ingrese el tipo de la habitación (ej. sencilla, compartida, familiar)");
			double price = input.repeatDoubleValidity("Ingrese el precio por día de este tipo de habitación");
			int maxOfPeople = input.repeatIntValidity("Ingrese la cantidad máxima de personas permitidas en la habitación");

			hotel.getRoomTypes().add(type);
			int thisRoomType = input.repeatIntValidity("¿Cuántas habitaciones hay de este tipo?");
			System.out.println();

			for (int j = 0; j < thisRoomType; j++){
				Room room = new Room(price, type, maxOfPeople);
				hotel.getListOfFreeRooms().add(room);
			}
		}
        
		//INITIALIZE EMPLOYEES
		int numberOfEmployees = input.repeatIntValidity("¿Cuántos empleados tiene?");
		ArrayList<String> roles = new ArrayList<>(Arrays.asList("recepcionista", "mucama", "chef"));

		for (int i = 0; i < numberOfEmployees; i++){
			String employeeName = input.readLongString("¿Cuál es su nombre?");
			String employeeId = input.readString("¿Cuál es su Id de empleado?");
			String employeePhoneNo = input.readString("¿Cuál es su número de celular");
			String employeeLocation = input.readLongString("¿Cuál es su país natal?");
			double employeeSalary = input.repeatDoubleValidity("¿Cuál es su salario mensual?");
			String role = "";
			do {
				role = input.readLongString("Ingrese su rol [recepcionista, mucama, chef]");
			} while (!roles.contains(role));

			System.out.println();

			switch (role) {
				case "recepcionista":
					Receptionist recepcionist = new Receptionist(employeeName, employeeId, employeePhoneNo, employeeLocation, employeeSalary, hotel);
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

	public Hotel initilizeByDefault() {
		//INITIALIZE HOTEL
		Hotel hotel = new Hotel("Palmira Nueva", "221B Baker Street, Londres, Reino Unido");

		//INITIALIZE ROOMS IN HOTEL
		for (int i = 0; i < 20; i++) {
			Room room = new Room(75000, "sencilla", 1);
			hotel.getListOfFreeRooms().add(room);
		}
		
		for (int i = 0; i < 15; i++) {
			Room room = new Room(110000, "compartida", 2);
			hotel.getListOfFreeRooms().add(room);
		}
		
		for (int i = 0; i < 10; i++) {
			Room room = new Room(140000, "familiar", 6);
			hotel.getListOfFreeRooms().add(room);
		} 

		for (int i = 0; i < 2; i++) {
			Room room = new Room(200000, "suite", 10);
			hotel.getListOfFreeRooms().add(room);
		}

		hotel.getRoomTypes().add("sencilla");
		hotel.getRoomTypes().add("compartida");
		hotel.getRoomTypes().add("familiar");
		hotel.getRoomTypes().add("suite");

		//INITIALIZE EMPLOYEES
		Manager manager = new Manager("Diana Margot López", "123456789", "3006114621", "Colombia", 12000000, hotel);
		
		Receptionist receptionist1 = new Receptionist("Manuela Gomez", "1209324893", "3041238934", "Colombia", 2500000, hotel);
		Receptionist receptionist2 = new Receptionist("Sara Perez", "1044374284", "3248912938032", "Venezuela" , 2000000, hotel);
		Receptionist receptionist3 = new Receptionist("Luis Arias", "903248327", "3213429829", "Ecuador", 2500000, hotel);
		Receptionist receptionist4 = new Receptionist("Gabriela Pineda", "1029348348", "3113857843", "España", 2500000, hotel);
		
		Chef chef1 = new Chef("Federico Fernandez", "1028932844", "3137248594", "España", 4000000, hotel);
		Chef chef2 = new Chef("Jorge Rausch", "903289324", "3233858892", "Colombia", 4200000, hotel);
		Chef chef3 = new Chef("Gordon Ramsay", "3248912389", "2583492384", "Reino Unido", 4200000, hotel);
		Chef chef4 = new Chef("Jean Picard", "328324984", "3891237491", "Francia", 4200000, hotel);
		Chef chef5 = new Chef("Roux François", "234983243", "3428934289", "Francia", 4200000, hotel);

		Maid maid1 = new Maid("Juan Andres Sevilla", "2349873249", "3289789324", "España", 2000000, false, hotel);
		Maid maid2 = new Maid("Luciana Gutierrez", "5438721387", "8787878954", "Venezuela", 2000000, false, hotel);
		Maid maid3 = new Maid("Valentina Tobón", "4578345439", "934587345873", "Colombia", 2000000, false, hotel);
		Maid maid4 = new Maid("Teofilo Torres", "8754387234", "73425873248", "Peru", 2000000, false, hotel);

		hotel.getListOfEmployees().add(manager);
		hotel.getListOfEmployees().add(receptionist1);
		hotel.getListOfEmployees().add(receptionist2);
		hotel.getListOfEmployees().add(receptionist3);
		hotel.getListOfEmployees().add(receptionist4);
		hotel.getListOfEmployees().add(chef1);
		hotel.getListOfEmployees().add(chef2);
		hotel.getListOfEmployees().add(chef3);
		hotel.getListOfEmployees().add(chef4);
		hotel.getListOfEmployees().add(chef5);
		hotel.getListOfEmployees().add(maid1);
		hotel.getListOfEmployees().add(maid2);
		hotel.getListOfEmployees().add(maid3);
		hotel.getListOfEmployees().add(maid4);
		hotel.getListOfReceptionists().add(receptionist1);
		hotel.getListOfReceptionists().add(receptionist2);
		hotel.getListOfReceptionists().add(receptionist3);
		hotel.getListOfReceptionists().add(receptionist4);
		hotel.getListOfChefs().add(chef1);
		hotel.getListOfChefs().add(chef2);
		hotel.getListOfChefs().add(chef3);
		hotel.getListOfChefs().add(chef4);
		hotel.getListOfChefs().add(chef5);
		hotel.getListOfMaids().add(maid1);
		hotel.getListOfMaids().add(maid2);
		hotel.getListOfMaids().add(maid3);
		hotel.getListOfMaids().add(maid4);		

		//INITIALIZE MENU
		Menu menu = new Menu();

		menu.addFoodItem(new FoodItem("Huevos con arepa", 8000));
		menu.addFoodItem(new FoodItem("4 Pancakes con frutos rojos", 15000));
		menu.addFoodItem(new FoodItem("5 Patacones con queso", 12000));
		menu.addFoodItem(new FoodItem("Quesadillas", 18000));
		menu.addFoodItem(new FoodItem("2 Sanduches de atún y queso", 8000));
		menu.addFoodItem(new FoodItem("Jugo de naranja", 4000));
		menu.addFoodItem(new FoodItem("Leche con chocolate", 4000));
		menu.addFoodItem(new FoodItem("Bandeja paisa", 28000));
		menu.addFoodItem(new FoodItem("Cazuela de mariscos", 24000));
		menu.addFoodItem(new FoodItem("Cerdo al curry picante", 22000));
		menu.addFoodItem(new FoodItem("Pescado blanco al Papillote", 30000));
		menu.addFoodItem(new FoodItem("Rissotto di mare", 25000));
		menu.addFoodItem(new FoodItem("Carbonada flamenca", 24000));
		menu.addFoodItem(new FoodItem("Jugo natural", 4000));
		menu.addFoodItem(new FoodItem("Spaghetti con albóndigas", 21000));
		menu.addFoodItem(new FoodItem("Ensalada griega", 17000));
		menu.addFoodItem(new FoodItem("Pizza de pepperoni mediana",25000));
		menu.addFoodItem(new FoodItem("Hamburguesa de pollo", 18000));
		menu.addFoodItem(new FoodItem("Crema de zanahoria con pan", 16000));
		menu.addFoodItem(new FoodItem("4 Alitas de pollo", 12000));
		menu.addFoodItem(new FoodItem("Limonada", 4000));
		menu.addFoodItem(new FoodItem("Gaseosa", 4000));

		hotel.setMenu(menu);

		return hotel;
	}

	public Hotel initializeByFile() {
		Hotel hotel = new Hotel(null, null);
		return hotel;
	}
}
