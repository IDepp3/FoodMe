package com.utn.teamA.App;

import com.utn.teamA.ConexionDatos.AccesoClientes;
import com.utn.teamA.ConexionDatos.AccesoReservas;
import com.utn.teamA.clases.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
/*
LocalDate fecha = LocalDate.now();
System.out.println(fecha.toString());
Cliente cliente = new Cliente();
cliente.setFechaNacimiento(LocalDate.now());
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


Menu menu = new Menu();
Menu menu1 = new Menu();
        List<Menu>menus = new ArrayList<>();
        menus.add(menu);
        menus.add(menu1);
String descripcion = "sadbhjdas";
boolean quiereBartender = true;

   Reserva reserva = new Reserva(fecha, cliente, menus, descripcion, quiereBartender);
    reserva.mostrar();

        AccesoClientes archReservas;
        AccesoReservas archReserva = new AccesoReservas();
        boolean a = archReserva.agregarRegistro(reserva);

        /*
         * System.out.println("Bienvenidos a FOODME"); Usuario unoUsuario = new
         * Cliente("BatMan", "Marble",LocalDate.of(1915,04,17),"2235249636",
         * "Lamadrid 5475","666666666", "batman@hotmail.com",null); Persona unoPersona =
         * new Cliente("Wonder", "Woman",LocalDate.of(1941,05,25),"2235249636",
         * "San martin 2475","33333333", "wonderWoman@gmail.com",null );
         * unoUsuario.mostrar(); unoPersona.mostrar()
         */
        // TODO Clase Menu y Tipo A trabajar: Jose
         new Empresa().iniciarSistema();
    }

}
