package com.utn.teamA.clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

/**
 * Clase Empleado
 *
 * @Marco
 */

public class Empleado extends Persona {
    
    private String tipoEmpleado;
    private double sueldo;

    //region Constructores

    /**
     * Constructor vacio
     */
    public Empleado(){

    }

    public Empleado(String nombre, String apellido){
        super(nombre, apellido);
    }

    /**
     *
     * @param String
     * @param sueldo
     */
    public Empleado(TipoEmpleado String, double sueldo){
        this.tipoEmpleado = tipoEmpleado;
        this.sueldo = sueldo;
    }

    /**
     * Constructor empleado + persona
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @param telefono
     * @param direccion
     * @param dni
     * @param email
     * @param tipo
     * @param sueldo
     */
    public Empleado( String nombre, String apellido, String fechaNacimiento,
                   String telefono, String direccion, String dni, String email, TipoEmpleado tipo , Double sueldo,boolean estado){
        super( nombre,  apellido,  fechaNacimiento, telefono, direccion,  dni, email, estado);
        this.tipoEmpleado = tipoEmpleado;
        this.sueldo = sueldo;
    }
    //endregion

    //region Getters
    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }
    //endregion

    //region Setter
    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    //endregion

    //region To String
    @Override
    public String toString() {
        return " Empleado: " + " ID: " + super.getId() + " Nombre: " + super.getNombre() + " Apellido: "
				+ super.getApellido() + " Nacimiento: " + super.getFechaNacimiento() + " Telefono: "
				+ super.getTelefono() + " Direccion: " + super.getDireccion() + " Dni: " + super.getDni() + " Email: "
				+ super.getEmail() + " Tipo: " + this.tipoEmpleado + " Sueldo: " + this.sueldo;
    }
    //endregion


    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj instanceof Empleado) {
            Empleado c = (Empleado) obj;
            if (this.getDni().equals(c.getDni()))
                return true;
        }
        return false;
    }


}
