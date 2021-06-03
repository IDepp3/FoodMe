package com.utn.teamA.utils;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            teclado.reset();
        } while (!esInt);
        return num;
    }

    public static String validarTelefono(){
        Scanner teclado = new Scanner(System.in);
        boolean resp = true;
        String cadena;
        do{
            System.out.print(Color.ANSI_GREEN + "Ingrese numero de telefono : " + Color.ANSI_RESET);
            cadena = teclado.nextLine();
            if(cadena.matches("^\\d{10}$"))
                resp = false;
            else
                Vista.opcionIncorrecta("El numero de telefono no es valido", cadena);
        }while(resp);
        return cadena;
    }

    public static boolean validarEmail(String email) {

        Pattern pattern = Pattern.compile(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);

        boolean resp = mather.find();

        if (resp == true) {
            System.out.println("Email ingresado es valido");
        } else {
            System.out.println("El email ingresado no es valido");
        }

        return resp;

    }

    public static boolean validarDni(String dni) {

        Pattern pattern = Pattern.compile("[0-9]{7,8}");
        Matcher mather = pattern.matcher(dni);

        boolean resp = mather.find();

        if (resp == true) {
            System.out.println("El dni ingresado es valido");
        } else {
            System.out.println("El dni es incorrecto");
        }
        return resp;
    }

    public static boolean validarTel(String telefono){

        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher mather = pattern.matcher(telefono);

        boolean resp = mather.find();

        if (resp == true){
            System.out.println("El telefono ingresado es valido");
        }else {
            System.out.println("El telefono es invalido.");
        }

        return resp;
    }

}