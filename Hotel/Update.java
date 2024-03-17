package Hotel;

public class Update {
    private Lectura input = new Lectura();
    int option = 0;
    
    public void start() {
        System.out.println("\nLista de personas");
        System.out.println("[1] Empleados");
        System.out.println("[2] Clientes");
        System.out.println("[3] Salir de la simulación\n");
        do {
            option = input.repeatIntValidity("Ingrese una opcion (1-3)");
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
        System.out.println("[5] Menú inicial");
        do {
            option = input.repeatIntValidity("Ingrese una opcion (1-4)");
        } while(option > 4);

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
        System.out.println("[1]  ");
        System.out.println("[1]  ");
        System.out.println("[1]  ");
        System.out.println("[1]  ");
        
    }

    public void playReceptionists() {
        System.out.println("\nElige la persona");

    }

    public void playMaids() {
        System.out.println("\nElige la persona");
    }

    public void playChefs() {
        System.out.println("\nElige la persona");

    }

    public void playGuests() {
        System.out.println("\nElige la persona");

    }
    
}
