package com.utn.teamA;

import java.util.Scanner;

public class Vista {

    // region ATRIBUTOS

    private Scanner scanner;

    // endregion

    public Vista(){
        this.scanner = new Scanner(System.in);
    }

    // region METODOS

    public void menuPrincipalVista(){
        System.out.println("MENU PRINCIPAL");
        System.out.println();
        System.out.println("1- Ver menus");
        System.out.println("2- Login");
        System.out.println("3- Registrarse");
        System.out.println("0- Salir");
    }

    // region VISTAS CLIENTE

    public void menuClientePrincipal(){
        System.out.println("MENU PRINCIPAL");
        System.out.println();
        System.out.println("1- Ver menus");
        System.out.println("2- Hacer reserva");
        System.out.println("3- Informacion personal");
        System.out.println("0- Salir");
    }

    public void menuInformacionPersonal(){
        System.out.println("INFORMACION PERSONAL");
        System.out.println();
        System.out.println("1- Ver informacion personal");
        System.out.println("2- Modificar informacion");
        System.out.println("3- Historial de compras");
        System.out.println("4- Reservas pendientes");
        System.out.println("0- Salir");
    }

    public void menuModificarDatos(){
        System.out.println("MODIFICAR INFORMACION PERSONAL");
        System.out.println();
        System.out.println("1- Modificar contraseña");
        System.out.println("2- Modificar telefono");
        System.out.println("3- Modificar direccion");
        System.out.println("4- Modificar email");
        System.out.println("0- Salir");
    }
    // endregion

    // region METODOS SCANNER

    public int seleccionarOpcion(){
        int opc;
        System.out.print("Ingrese una opcion: ");
        opc = this.scanner.nextInt();
        return opc;
    }

    public String opcionIncorrecta(){
        return "La opcion elegida es incorrecta";
    }

    public String seleccionarNumeros(){
        return "Solo se permite el ingreso de numeros";
    }

    // con este metodo evitamos que explote la app cuando el usuario ingresa letras en vez de numero a la hora de seleccionar una opcion de cualquier menu
    public void saltoLinea(){
        this.scanner.nextLine();
    }

    // endregion
}
