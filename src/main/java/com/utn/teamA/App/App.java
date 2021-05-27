package com.utn.teamA.App;


import com.utn.teamA.Modelo.Reserva;

public class App {
    
    public static void main(String[] args) {
        String anto = "anto";
        Reserva uno = new Reserva(anto);
        System.out.println(anto);
        System.out.println(uno.orderId);
        Reserva dos = new Reserva(anto);
        System.out.println(anto);
        System.out.println(dos.orderId);
        Reserva tres = new Reserva(anto);
        System.out.println(anto);
        System.out.println(tres.orderId);


    }
}
