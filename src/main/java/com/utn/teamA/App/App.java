package com.utn.teamA.App;

import com.google.gson.Gson;
import com.utn.teamA.clases.*;

import java.time.LocalDate;


public class App {
    public static void main(String[] args) {


        Gson dos = new Gson();

        Empleado empleado = new Empleado();

        //empleado.mostrar();
        //System.out.println(dos.toJson(empleado));
        LocalDate fecha = LocalDate.now();
        System.out.println(fecha);

         Reserva reserva = new Reserva();
         reserva.mostrar();
         System.out.println(dos.toJson(reserva));



        //  Persona uno = new Cliente();
        //System.out.println(uno);

       // new Empresa().iniciarSistema();
    }

}
