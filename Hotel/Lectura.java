package Hotel;
import java.util.Scanner;

public class Lectura {
    Scanner input = new Scanner(System.in);

    public String readString(String mensaje){
        System.out.println(mensaje+ ": ");
        String dato = input.next();
        input.nextLine();
        return dato;
    }

    public String readLongString(String mensaje){
        input.reset();
        System.out.print(mensaje+ ": ");
        String dato = input.nextLine();
        return dato;
    }

    public int validateInt() {
        if (input.hasNextInt()) {
            int number = input.nextInt();
            if (number > 0) {
                return number;
            } else {
                System.out.println("El número debe ser positivo");
                return 0;
            }
        } else {
            System.out.println("Debe ser un entero positivo.");
            input.next();
            return 0;
        }
    }

    public int repeatIntValidity(String mensaje){
        int number = 0;
        do {
            System.out.print(mensaje+ ": ");
            number = validateInt();
        } while (number == 0);
        return number;
    }

    public double validateDouble() {
        if (input.hasNextDouble()) {
            double number = input.nextDouble();
            if (number > 0) {
                return number;
            } else {
                System.out.println("El número debe ser positivo");
                return 0;
            }
        } else {
            System.out.println("Debe ser un entero positivo.");
            input.next();
            return 0;
        }
    }

    public double repeatDoubleValidity(String mensaje){
        double number = 0;
        do {
            System.out.print(mensaje+ ": ");
            number = validateDouble();
        } while (number == 0);
        return number;
    }

    public long validateLong() {
        if (input.hasNextLong()) {
            long number = input.nextLong();
            if (number > 0) {
                return number;
            } else {
                System.out.println("El número debe ser positivo");
                return 0;
            }
        } else {
            System.out.println("Debe ser un entero positivo.");
            input.next();
            return 0;
        }
    }

    public long repeatLongValidity(String mensaje){
        long number = 0;
        do {
            System.out.print(mensaje+ ": ");
            number = validateLong();
        } while (number == 0);
        return number;
    }

    public String readChar(String mensaje){
        String dato = input.next().toUpperCase().substring(0, 1);
        return dato;
    }
}