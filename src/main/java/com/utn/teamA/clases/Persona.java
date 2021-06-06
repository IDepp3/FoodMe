package com.utn.teamA.clases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Clase Abstracta Persona
 * Registra los datos de las personas
 * Cada vez que se intancia la clase se genera el id de la persona.
 *
 * @marco
 */

public abstract class Persona extends Usuario {

    private String id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String direccion;
    private String dni;
    private boolean estado;

    //region Constructores

    /**
     * Constructor Vacio
     */
    public Persona(){
        fechaNacimiento = LocalDate.now();
        this.id = UUID.randomUUID().toString().substring(0, 10).replace("-", "g");
        this.estado = true;
    }

    public Persona(String nombre, String apellido){
        this.id = UUID.randomUUID().toString().substring(0, 10).replace("-", "g");
        this.nombre   = nombre;
        this.apellido = apellido;
        LocalDate.now();
        this.estado = true;
    }

    /**
     * Constructor Persona
     *
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @param telefono
     * @param direccion
     * @param dni
     */
    public Persona( String nombre, String apellido, LocalDate fechaNacimiento, String telefono, String direccion, String dni,
            String email, boolean estado) {
        this.id = UUID.randomUUID().toString().substring(0, 10).replace("-", "g");
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dni = dni;
        this.estado = true;
    }

    /**
     * Constructor de Persona y Usuario para usar el Loguin
     * @param username
     * @param password
     * @param fechaRegistro
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @param telefono
     * @param direccion
     * @param dni
     */
    public Persona(String username, String password, LocalDate fechaRegistro,String nombre, String apellido, LocalDate fechaNacimiento,
                   String telefono, String direccion, String dni,
                   String email, boolean estado){
        super( username, password, email, fechaRegistro);
        this.id = UUID.randomUUID().toString().substring(0, 10).replace("-", "g");
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dni = dni;
        this.estado = true;
    }

    public Persona(String id, String username, String password, String email, LocalDate fechaRegistro, TipoUsuario tipoUsuario, boolean estado){
        super(username, password, email, fechaRegistro, tipoUsuario);
        this.id     = id;
        this.estado = estado;
    }
    //endregion

    //region Getters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    public boolean getEstado(){
        return this.estado;
    }

    //endregion

    //region Setters

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    //endregion

    //region To String
    // Si usamos usuario ahi si vamos a tener que poner  "Super.toString +" en el return
    @Override
    public String toString() {
        return  "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento.toString() +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }


    //endregion

    //region Mostrar
    public abstract void mostrar();
    //endregion


}
