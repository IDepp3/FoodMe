package com.utn.teamA;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Helpers {


    public static String nextLine(){
        Scanner teclado = new Scanner(System.in);
        boolean esTextoVacio = false;
        String texto = "";

        do{
            texto = teclado.nextLine();
            if( texto.length() == 0){
                esTextoVacio = true;
                System.out.println(
                    Color.ANSI_RED +
                    "\n\t EL CAMPO NO PUEDE QUEDAR VACIO \n" +
                    Color.ANSI_CYAN +
                    "\nIngrese un dato:"
                );
            } else {
                esTextoVacio = false;
            }
        }while(esTextoVacio);

        return texto;
    }

    public static char charAt0(){
        Scanner teclado = new Scanner(System.in);
        return teclado.next().charAt(0);
    }



    public static double validarDouble() {
        Scanner teclado = new Scanner(System.in);
        boolean esDouble = false;
        double num = 0;
        do {
            String cadena = teclado.nextLine();
            try {
                num = Double.parseDouble(cadena);
                esDouble = true;
            } catch (NumberFormatException nfe) {
                System.out.println(
                    Color.ANSI_RED +
                    "\n\t [[ " + cadena + " ]] NO ES UN DATO VALIDO \n" +
                    Color.ANSI_CYAN +
                    "\nIngrese un numero:"
                );
            }
        } while (!esDouble);
        return num;
    }

    public static int validarInt() {
        Scanner teclado = new Scanner(System.in);
        boolean esInt = false;
        int num = 0;
        do {
            String cadena = teclado.nextLine();
            try {
                num = Integer.parseInt(cadena);
                esInt = true;
            } catch (NumberFormatException nfe) {
                System.out.println(
                        Color.ANSI_RED +
                                "\n\t [[ " + cadena + " ]] NO ES UN DATO VALIDO \n" +
                                Color.ANSI_CYAN +
                                "\nIngrese un numero:"
                );
            }
        } while (!esInt);
        return num;
    }

}