package com.utn.teamA.clases;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase Empleado
 *
 * @Marco
 */

public class Empleado extends Persona {
    
    private TipoEmpleado tipoEmpleado;
    private int sueldo;

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
     * Constructor Empleado
     * @param tipoEmpleado
     * @param sueldo
     */
    public Empleado(TipoEmpleado tipoEmpleado, int sueldo){
        this.tipoEmpleado = tipoEmpleado;
        this.sueldo = sueldo;
    }

    /**
     * Constructor Empleado completo + Persona
     * @param id
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @param telefono
     * @param direccion
     * @param dni
     * @param email
     * @param tipoEmpleado
     * @param sueldo
     */
    public Empleado(String nombre, String apellido, String fechaNacimiento, String telefono,
            String direccion, String dni, String email, TipoEmpleado tipoEmpleado, int sueldo) {
        super( nombre, apellido, fechaNacimiento, telefono, direccion, dni, email);
        this.tipoEmpleado = tipoEmpleado;
        this.sueldo = sueldo;
    }

    /**
     * Constructor completo Empleado + Persona + Usuario para el Loguin
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
    public Empleado(String username, String password, LocalDate fechaRegistro, String nombre, String apellido, String fechaNacimiento,
                   String telefono, String direccion, String dni, String email, List<Reserva> lasReservas){
        super(username, password, fechaRegistro, nombre,  apellido,  fechaNacimiento, telefono, direccion,  dni, email );
        this.tipoEmpleado = tipoEmpleado;
        this.sueldo = sueldo;
    }


    //endregion

    //region Getters
    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public int getSueldo() {
        return sueldo;
    }
    //endregion

    //region setter
    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
    //endregion

    //region To String
    @Override
    public String toString() {
        return  "[Empleado |ID: " + super.getId() + " |Nombre: " + super.getNombre() + " |Apellido: "
				+ super.getApellido() + " |Nacimiento: " + super.getFechaNacimiento() + " |Telefono: "
				+ super.getTelefono() + " |Direccion: " + super.getDireccion() + " |Dni: " + super.getDni() + " |Email: "
				+ super.getEmail() + " |Tipo: " + this.tipoEmpleado + " |Sueldo: " + this.sueldo + "]";
    }
    //endregion

    public boolean esIgual(Empleado empleado){
        if(this == empleado)
            return true;
        
        if(this.getNombre().equals(empleado.getNombre()) && this.getApellido().equals(empleado.getApellido()))
            return true;

        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        
        if(obj instanceof Empleado){
            Empleado e = (Empleado)obj;
            if(this.getNombre().equals(e.getNombre()) && (this.getApellido().equals(e.getApellido())));
                return true;
        }

        return false;
    }

    //region Mostrar
    @Override
    public void mostrar() {
        System.out.println(toString());
    }
    //endregion

}
