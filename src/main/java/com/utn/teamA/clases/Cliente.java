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

    public Cliente(String nombre, String apellido){
        super(nombre, apellido);
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
                    String dni,String email,Boolean estado,List<Reserva> lasReservas){
        super(nombre,apellido,fechaNacimiento,telefono,direccion,dni,email,estado );
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
                   String telefono, String direccion, String dni, String email,boolean estado,List<Reserva> lasReservas){
        super(username, password, fechaRegistro, nombre,  apellido,  fechaNacimiento, telefono, direccion,  dni, email,estado );
        reservas = lasReservas;
    }
    //endregion

    //endregion

    // region Getters && Setters

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    // endregion

    //region To String
    @Override
    public String toString() {
        return super.toString() +
                "Cliente{" +
                "reservas=" + reservas +
                '}';
    }
    //endregion

    //region Equals
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        
        if(obj instanceof Cliente){
            Cliente c = (Cliente)obj;
            if(this.getId().equals(c.getId()))
                return true;
        }

        return false;
    }

    public boolean esIgual(Cliente cliente){
        if(this == cliente)
            return true;
        
        if(this.getNombre().equals(cliente.getNombre()) && this.getApellido().equals(cliente.getApellido()))
            return true;

        return false;
    }
    //endregion

    //region Mostrar

    @Override
    public void mostrar() {
        System.out.println(toString());
    }
    //endregion


}

