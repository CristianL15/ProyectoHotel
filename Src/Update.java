package Src;

import java.util.ArrayList;

public class Update {
    private Lectura input = new Lectura();
    int option = 0;
    Hotel hotel;

    public Update(Hotel hotel){
        this.hotel = hotel;
    }
    
    public void start() {
        System.out.println("\nLista de personas");
        System.out.println("[1] Empleados");
        System.out.println("[2] Clientes");
        System.out.println("[3] Salir de la simulación");
        do {
            option = input.repeatIntValidity("Ingrese una opcion (1 - 3)");
        } while(option > 3);

        switch (option) {
            case 1:
                playEmployees();
                break;
            case 2:
                playGuests();
                break;
            case 3:
                Runtime.getRuntime().exit(0);
                break;
        }
    }

    public void playEmployees() {
        System.out.println("\nElige el rol");
        System.out.println("[1] Administrador");
        System.out.println("[2] Recepcionistas");
        System.out.println("[3] Mucamas");
        System.out.println("[4] Chefs");
        System.out.println("[5] Menú anterior");
        do {
            option = input.repeatIntValidity("Ingrese una opcion (1 - 5)");
        } while(option > 5);
        System.out.println();

        switch (option) {
            case 1:
                playManager();
                break;
            case 2:
                playReceptionists();
                break;
            case 3:
                playMaids();
                break;
            case 4:
                playChefs();
                break;
            case 5:
                start();
                break;
        }
    }
    
    public void playManager() {
        System.out.println("Como administrador de este hotel, puedes realizar las siguiente funciones:");
        System.out.println("[1] Comprar inventario");
        System.out.println("[2] Programar turno de los empleados");
        System.out.println("[3] Despedir");
        System.out.println("[4] Contratar");
        System.out.println("[5] Menú anterior");

        //CONDICIONALES PARA CADA MÉTODO
        do {
            option = input.repeatIntValidity("Ingrese una opcion (1 - 5)");
        } while(option > 5);
        System.out.println();

        if (option == 1){
            hotel.toString();
            start();
        } if (option == 2) {
            start();
        } if (option == 3) {
            start();
        } if (option == 4) {
            start();
        } else {
            start();
        }
    }

    public void playReceptionists() {

        System.out.println("\nElige la persona");
        ArrayList<Receptionist> allReceptionists = hotel.getListOfReceptionists();
        ArrayList<Receptionist> receptionists = new ArrayList<>();
        for (int i = 0; i < allReceptionists.size(); i++) {
            if (allReceptionists.get(i).isWorking()) {
                receptionists.add(allReceptionists.get(i));
            }
        }

        int numberOfReceptionist = receptionists.size();
        for (int i = 1; i < numberOfReceptionist + 1; i++){
            Receptionist receptionist = receptionists.get(i - 1);
            System.out.println("[" + i + "] " + receptionist.getName() + " --- id: " + receptionist.getId());
        }
        System.out.println("[" + (numberOfReceptionist + 1) + "] Menú anterior");
        do {
            option = input.repeatIntValidity("Ingrese una opcion (1 - " + (numberOfReceptionist + 1) + ")");
        } while(option > numberOfReceptionist + 1);

        System.out.println();
        if (option == numberOfReceptionist + 1) {
            playEmployees();
        } 

        else {
            Receptionist receptionist = receptionists.get(option - 1);
    
            System.out.println("Como recepcionista de este hotel, puedes realizar las siguiente funciones:");
            System.out.println("[1] Check-In a clientes");
            System.out.println("[2] Generar el balance diario"); //FALTA AGREGAR METODO
            System.out.println("[3] Menú anterior");
            do {
                option = input.repeatIntValidity("Ingrese una opcion (1 - 3)");
            } while(option > 3);
            System.out.println();
    
            if (option == 1){
                receptionist.checkInGuests();
                hotel.toString();
                start();
            } else if (option == 2) {
                receptionist.generateDailyBalance();
                start();
            } else {
                playReceptionists();
            }
        }
        
    }

    public void playMaids() {
        System.out.println("\nElige la persona");
        ArrayList<Maid> maids = hotel.getListOfMaids();
        for (int i = 1; i < maids.size() + 1; i++){
            Maid maid = maids.get(i - 1);
            System.out.println("[" + i + "]  " + maid.getName() + " --- id: " + maid.getId());
        }

        //FALTAN METODO
        // [1] LIMPIEZA DE HABITACION
        // [2] LAVANDERIA
    }

    public void playChefs() {
        System.out.println("\nElige la persona");
        ArrayList<Chef> chefs = hotel.getListOfChefs();
        for (int i = 1; i < chefs.size() + 1; i++){
            Chef chef = chefs.get(i - 1);
            System.out.println("[" + i + "]  " + chef.getName() + " --- id: " + chef.getId());
        }

        /*
         * RECIBIR ORDEN DE COMIDA
         * ALTERAR 
         */
    }

    public void playGuests() {
        Guest guest;
        ArrayList<Guest> adultGuests = hotel.getListOfAdultGuests();
        int numberOfAdultGuests = adultGuests.size();
        //SOLO PUEDEN ACTUAR CON PERSONAS MAYORES DE EDAD
        System.out.println("\nElige la persona");
        for (int i = 1; i < adultGuests.size() + 1; i++){
            Guest guests = adultGuests.get(i - 1);
            System.out.println("[" + i + "]  " + guests.getName() + " --- id: " + guests.getId());
        }

        System.out.println("[" + (numberOfAdultGuests + 1) + "] Menú anterior");

        do {
            option = input.repeatIntValidity("Ingrese una opcion (1 - " + (numberOfAdultGuests + 1) + ")");
        } while(option > numberOfAdultGuests + 1);

        System.out.println();
        if (option == numberOfAdultGuests + 1) {
            start();
        } 
        else {
            guest = adultGuests.get(option - 1);

            System.out.println("[1] Order");
            System.out.println("[2] Check-out");
            System.out.println("[3] Quejarse");
            System.out.println("[4] Menú anterior");
            do {
                option = input.repeatIntValidity("Ingrese una opcion (1 - 4");
            } while (option > 4);
            
            switch (option) {
                case 1:
                    guest.order();
                    break;
                case 2:
                    guest.checkOut();
                    break;
                case 3:
                    guest.complain();
                    break;
                case 4:
                    playGuests();
                    break;
            }
        }

        

        /*
         * ORDER
         * CHECK OUT
         * COMPLAIN
         */

         

    }
    
}
