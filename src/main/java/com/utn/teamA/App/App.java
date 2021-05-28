package com.utn.teamA.app;


import com.utn.teamA.clases.Cliente;
import com.utn.teamA.clases.Empleado;
import com.utn.teamA.clases.Persona;
import com.utn.teamA.clases.Usuario;

import java.time.LocalDate;

public class App {
    
    public static void main(String[] args) {

        System.out.println("Bienvenidos a FOODME");
        Usuario unoUsuario = new Cliente("BatMan", "Marble",LocalDate.of(1915,04,17),"2235249636", "Lamadrid 5475","666666666", "batman@hotmail.com",null);
        Persona unoPersona = new Cliente("Wonder", "Woman",LocalDate.of(1941,05,25),"2235249636", "San martin 2475","33333333", "wonderWoman@gmail.com",null );
        unoUsuario.mostrar();
        unoPersona.mostrar();
    }

}

