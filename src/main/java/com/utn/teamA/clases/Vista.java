package com.utn.teamA.modelo;

import java.util.Scanner;

public class Vista {
    
    // region ATTRIBUTES

    private Scanner sc;

    // endregion

    // region CONSTRUCTORS

    public Vista(){
        this.sc = new Scanner(System.in);
    }

    // endregion
    
    // region METHODS


    // region VISTAS

    public void menuPrincipal(){
        System.out.println("----- FoodMe -----");
        System.out.println("");
        System.out.println("1- Ver Menus disponibles");
        System.out.println("2- Loguearse");
        System.out.println("3- Salir");
    }

    public Usuario login(){
        Usuario usuario = new Usuario();
        System.out.println("----- LOGIN -----");
        System.out.println("");
        System.out.print("Nombre de Usuario : ");
        usuario.setNombre(this.sc.next());
        System.out.print("Contraseña        : ");        
        usuario.setPass(this.sc.next());

        return usuario;
    }

    // endregion


    public int seleccionOpcion(){
        System.out.print("Ingrese una opcion: ");
        int op = this.sc.nextInt();
        sc.reset();
        return op;
    }

    public void resetScanner(){
        this.sc.nextLine();
    }

    public Usuario datosUsuario(){
        return new Usuario(this.sc.next().trim(), this.sc.next().trim());
    }
}
