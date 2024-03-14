package com.example;
import java.util.Scanner;

public class Lectura {
    Scanner sc = new Scanner(System.in);
    
    public int leerInt(String mensaje){
        System.out.println(mensaje+": ");
        int dato = sc.nextInt();
        return dato;
    }

    public String leerString(String mensaje){
        System.out.println(mensaje+ ": ");
        sc.nextLine();
        String dato = sc.next();
        return dato;
    }

    public int validarInt() {
        if (sc.hasNextInt()) {
            int numero = sc.nextInt();
            if (numero > 0) {
                return numero;
            } else {
                System.out.println("El número debe ser positivo");
                return 0;
            }
        } else {
            System.out.println("Debe ser un entero positivo.");
            sc.next();
            return 0;
        }
    }

    public int repetirLectura(String mensaje){
        int numero = 0;
        do {
            System.out.print(mensaje+ ": ");
            numero = validarInt();
        } while (numero == 0);
        return numero;
    }

    public double leerDouble(String mensaje){
        System.out.println(mensaje);
        double dato = sc.nextDouble();
        return dato;
    }
}