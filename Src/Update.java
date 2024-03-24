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
    
    //HISTORIA DE USUARIO 6
    public void playManager() {
        System.out.println("Como administrador de este hotel, puedes realizar las siguiente funciones:");
        System.out.println("[1] Comprar inventario");
        System.out.println("[2] Programar turno de los empleados");
        System.out.println("[3] Despedir");
        System.out.println("[4] Contratar");
        System.out.println("[5] Menú anterior");

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
            System.out.println("[2] Generar el balance diario"); //FALTA AGREGAR METODO  HISTORIA DE USUARIO 5
            System.out.println("[3] Menú anterior");
            do {
                option = input.repeatIntValidity("Ingrese una opcion (1 - 3)");
            } while(option > 3);
            System.out.println();
    
            if (option == 1){
                receptionist.checkInGuests();
                start();
            } else if (option == 2) {
                receptionist.generateDailyBalance();
                start();
            } else {
                playReceptionists();
            }
        }
        
    }

    //HISTORIA DE USUARIO 7
    public void playMaids() {
        System.out.println("\nElige la persona");
        ArrayList<Maid> allMaids = hotel.getListOfMaids();
        ArrayList<Maid> maids = new ArrayList<>();
        for (int i = 0; i < allMaids.size(); i++) {
            if (allMaids.get(i).isWorking()) {
                maids.add(allMaids.get(i));
            }
        }

        int numberOfMaids = maids.size();
        for (int i = 1; i < numberOfMaids + 1; i++){
            Maid maid = maids.get(i - 1);
            System.out.println("[" + i + "] " + maid.getName() + " --- id: " + maid.getId());
        }
        System.out.println("[" + (numberOfMaids + 1) + "] Menú anterior");
        do {
            option = input.repeatIntValidity("Ingrese una opcion (1 - " + (numberOfMaids + 1) + ")");
        } while(option > numberOfMaids + 1);

        System.out.println();
        if (option == numberOfMaids + 1) {
            playEmployees();
        }

        else {
            Maid maid = maids.get(option - 1);
        
            System.out.println("Como mucama de este hotel, puedes realizar las siguiente funciones:");
            System.out.println("[1] Realizar servicio de lavandería");
            System.out.println("[2] Limpiar habitación"); 
            System.out.println("[3] Menú anterior");
            do {
                option = input.repeatIntValidity("Ingrese una opcion (1 - 3)");
            } while(option > 3);
            System.out.println();
    
            if (option == 1){
                maid.doLaundry();
                start();
            } else if (option == 2) { 
                maid.cleanRoom();
                start();
            } else {
                playMaids();
            }
        }
    }

    public void playChefs() {
        System.out.println("\nElige la persona");
        ArrayList<Chef> allChefs = hotel.getListOfChefs();
        ArrayList<Chef> chefs = new ArrayList<>();
        for (int i = 0; i < allChefs.size(); i++) {
            if (allChefs.get(i).isWorking()) {
                chefs.add(allChefs.get(i));
            }
        }

        int numberOfChefs = chefs.size();
        for (int i = 1; i < numberOfChefs + 1; i++){
            Chef chef = chefs.get(i - 1);
            System.out.println("[" + i + "] " + chef.getName() + " --- id: " + chef.getId());
        }
        System.out.println("[" + (numberOfChefs + 1) + "] Menú anterior");
        do {
            option = input.repeatIntValidity("Ingrese una opcion (1 - " + (numberOfChefs + 1) + ")");
        } while(option > numberOfChefs + 1);

        System.out.println();
        if (option == numberOfChefs + 1) {
            playEmployees();
        }

        else {
            Chef chef = chefs.get(option - 1);
        
            System.out.println("Como chef de este hotel, puedes realizar las siguiente funciones:");
            System.out.println("[1] Recibir orden");
            System.out.println("[2] Menú anterior"); 
            do {
                option = input.repeatIntValidity("Ingrese una opcion (1 - 2)");
            } while(option > 2);
            System.out.println();
    
            if (option == 1){
                chef.takeOrder();
                start();
            } else {
                playEmployees();
            }
        }

        // RECIBIR ORDEN DE COMIDA
    }

    public void playGuests() {
        Guest guest;
        ArrayList<Guest> adultGuests = hotel.getListOfAdultGuests();
        int numberOfAdultGuests = adultGuests.size();
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

            System.out.println("[1] Ordenar");
            System.out.println("[2] Check-out");
            System.out.println("[3] Quejarse");
            System.out.println("[4] Menú anterior");
            do {
                option = input.repeatIntValidity("Ingrese una opcion (1 - 4)");
            } while (option > 4);
            
            System.out.println();

            switch (option) {
                case 1:
                    guest.order();
                    start();
                    break;
                case 2:
                    guest.checkOut();
                    start();
                    break;
                case 3:
                    guest.complain();
                    start();
                    break;
                case 4:
                    playGuests();
                    break;
            }
        }
    }
    
}
