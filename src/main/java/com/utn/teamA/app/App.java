package com.utn.teamA;

import com.utn.teamA.clases.Vista;
import com.utn.teamA.clases.User;

public class App {
    
    public static void main(String[] args) {

        System.out.println("Hola Mundo");
        
        Vista v = new Vista ();

        v.menuPrincipal();

        v.seleccionOpcion();

        User u = new User();

        u.login();

    }
}
