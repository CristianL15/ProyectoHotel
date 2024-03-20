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
        System.out.println("[3] Salir de la simulación\n");
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
            option = input.repeatIntValidity("Ingrese una opcion (1 - 4)");
        } while(option > 5);

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
        System.out.println("[1] Registrar quejas");
        System.out.println("[2] Programar turno de los empleados");
        System.out.println("[3] Despedir");
        System.out.println("[4]  Contratar");

        //CONDICIONALES PARA CADA MÉTODO
    }

    public void playReceptionists() {
        System.out.println("\nElige la persona");
        ArrayList<Receptionist> receptionists = hotel.getListOfReceptionists();
        for (int i = 1; i < receptionists.size() + 1; i++){
            Receptionist receptionist = receptionists.get(i - 1);
            System.out.println("[" + i + "]  " + receptionist.getName() + " --- id: " + receptionist.getId());
        }
        do {
            option = input.repeatIntValidity("Ingrese una opcion (1 - " + receptionists.size() + ")");
        } while(option > receptionists.size());

        System.out.println();
        Receptionist receptionist = receptionists.get(option - 1);

        System.out.println("Como recepcionista de este hotel, puedes realizar las siguiente funciones:");
        System.out.println("[1] Check-In a clientes");
        System.out.println("[2] Generar el balance diario"); //FALTA AGREGAR METODO
        do {
            option = input.repeatIntValidity("Ingrese una opcion (1 - 2)");
        } while(option > 2);

        if (option == 1){
            receptionist.checkInGuests();
            hotel.toString();
            start();
        } else {
            receptionist.generateDailyBalance();
            start();
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
        //SOLO PUEDEN ACTUAR CON PERSONAS MAYORES DE EDAD
        System.out.println("\nElige la persona");
        ArrayList<Guest> adultGuests = hotel.getListOfAdultGuests();
        for (int i = 1; i < adultGuests.size() + 1; i++){
            Guest guest= adultGuests.get(i - 1);
            System.out.println("[" + i + "]  " + guest.getName() + " --- id: " + guest.getId());
            
            /*
             * ORDER
             * CHECK OUT
             * COMPLAIN
             */
        }
    }
    
}
