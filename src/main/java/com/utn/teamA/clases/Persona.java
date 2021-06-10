package com.utn.teamA.clases;

import java.util.UUID;

/**
 * Clase Abstracta Persona
 * Registra los datos de las personas
 * Cada vez que se intancia la clase se genera el id de la persona.
 *
 * @marco
 */

public abstract class Persona extends Usuario {

    // region ATRIBUTOS

    private String id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String telefono;
    private String direccion;
    private String dni;
    private boolean estado;

    // endregion

    //region Constructores

    /**
     * Constructor Vacio
     */
    public Persona(){

        this.id = UUID.randomUUID().toString().substring(0, 10).replace("-", "g");
        this.estado = true;
    }

    public Persona(String nombreUsuario, String password){
        super(nombreUsuario, password);
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
    public Persona( String nombre, String apellido, String fechaNacimiento, String telefono, String direccion, String dni,
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
    public Persona(String username, String password, String fechaRegistro,String nombre, String apellido, String fechaNacimiento,
                   String telefono, String direccion, String dni,
                   String email, boolean estado){
        super( username, password, fechaRegistro);
        this.id = UUID.randomUUID().toString().substring(0, 10).replace("-", "g");
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dni = dni;
        this.estado = true;
    }

    // constructor usado para el registro

    public Persona(String id, String username, String password, String email, String fechaRegistro, String tipoUsuario, boolean estado){
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
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

    @Override
    public String toString() {
        return "ID : " + this.id + "\nNombre : " + this.nombre + "\nApellido : " + this.apellido + "\nFecha Nacimiento : " + this.fechaNacimiento + "\nTelefono : " + this.telefono + "\nDireccion : " + this.direccion + "\nDNI : " + this.dni + "\nEstado : " + ((this.estado) ? "Activo" : "Inactivo") + super.toString();
    }


    public void mostrar(){
        System.out.println(toString());
    }
}
