package com.utn.teamA.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Cliente
 *
 * @marco
 */

public class Cliente extends Persona {

    private List<Reserva> reservas;

    //region Constructores

    /**
     * Constructor vacio
     *
     */
    public Cliente(){

    }

    /**
     * Constructor Cliente
     * @param lasReservas
     */
    public Cliente(List<Reserva> lasReservas){
        reservas = lasReservas;
    }

    /**
     * Constructor Cliente + Persona
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @param telefono
     * @param direccion
     * @param dni
     * @param email
     */

    public Cliente(String nombre, String apellido, LocalDate fechaNacimiento, String telefono, String direccion,
                    String dni,String email,List<Reserva> lasReservas){
        super(nombre,apellido,fechaNacimiento,telefono,direccion,dni,email );
        reservas = lasReservas;
    }

    /**
     * Constructor Cliente + Persona + Usuario para el Loguin
     * @param username
     * @param password
     * @param fechaRegistro
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @param telefono
     * @param direccion
     * @param dni
     * @param email
     * @param lasReservas
     */
    public Cliente(String username, String password, LocalDate fechaRegistro,String nombre, String apellido, LocalDate fechaNacimiento,
                   String telefono, String direccion, String dni, String email,List<Reserva> lasReservas){
        super(username, password, fechaRegistro, nombre,  apellido,  fechaNacimiento, telefono, direccion,  dni, email );
        reservas = lasReservas;
    }
    //endregion

    //region To String
    @Override
    public String toString() {
        return "Cliente{" +
                "reservas=" + reservas +
                '}';
    }
    //endregion

    //region Mostrar

    @Override
    public void mostrar() {
        System.out.println(toString());
    }
    //endregion


}
