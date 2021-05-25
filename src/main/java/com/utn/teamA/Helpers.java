package com.utn.teamA;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Helpers {


    public static String nextLine(){
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    public static char charAt0(){
        Scanner teclado = new Scanner(System.in);
        return teclado.next().charAt(0);
    }

    public static double nextDouble(){

        Scanner teclado = new Scanner(System.in);
        Double numero = 0.0;

        try {
            numero = teclado.nextDouble();
        }catch (InputMismatchException e){
            numero = 0.0;
            System.out.println("El numero ingresado no es valido");
        }

        return numero;
    }

    private boolean isDouble(String numero) {
        try {
            Double.parseDouble(numero);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    public Double validarDouble() {
        Scanner leer = new Scanner(System.in);
        boolean esDouble = false;
        double num = -1;
        do {
            String cadena = leer.nextLine();
            try {
                num = Double.parseDouble(cadena);
                esDouble = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Escriba un numero");
            }
        } while (!esDouble);
        return num;
    }

}
