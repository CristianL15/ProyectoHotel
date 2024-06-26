package Src;
import java.util.Scanner;

public class Lectura {
    Scanner input = new Scanner(System.in);

    public String readString(String mensaje){
        System.out.print(mensaje+ ": ");
        String dato = input.next();
        return dato;
    }

    public String readLongString(String mensaje){
        System.out.print(mensaje+ ": ");
        String dato = input.nextLine();
        return dato;
    }

    public int validateInt() {
        int number = 0;
        if (input.hasNextInt()) {
            try {
                number = input.nextInt();
            } catch (Exception NumberFormatException) {
                System.out.println("No es un número válido");
            }
            if (number > 0) {
                return number;
            } else {
                System.out.println("El número debe ser mayor que cero");
                return 0;
            }
        } else {
            System.out.println("Debe ser un entero positivo.");
            try {
                input.next();
            } catch (NumberFormatException e){
                System.out.println("Número no valido");
            }
            return 0;
        }
    }

    public int repeatIntValidity(String mensaje){
        int number = 0;
        do {
            System.out.print(mensaje+ ": ");
            number = validateInt();
        } while (number == 0);
        input.nextLine();
        return number;
    }

    public double validateDouble() {
        if (input.hasNextDouble()) {
            double number = input.nextDouble();
            if (number > 0) {
                return number;
            } else {
                System.out.println("El número debe ser mayor que cero");
                return 0;
            }
        } else {
            System.out.println("Debe ser un entero positivo.");
            input.next();
            return 0;
        }
    }

    public double repeatDoubleValidity(String mensaje){
        input.nextLine();
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
                System.out.println("El número debe ser mayor que cero");
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
        input.nextLine();
        return number;
    }

    public String readChar(String mensaje){
        String dato = input.next().toUpperCase().substring(0, 1);
        return dato;
    }
}