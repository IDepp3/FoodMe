package com.utn.teamA;

import java.time.LocalDate;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private LocalDate Nacimiento;
    private String telefono;
    private String direccion;
    private String dni;
    private String email;

    public Persona(int id, String nombre, String apellido, LocalDate Nacimiento, String telefono, String direccion, String dni,
            String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Nacimiento = Nacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dni = dni;
        this.email = email;
    }

    public Persona(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDate getNacimiento() {
        return Nacimiento;
    }

    public void setNacimiento(LocalDate Nacimiento) {
        this.Nacimiento = Nacimiento;
    }

    public String getTelefono(){
        return telefono;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona ID: " + id + " Nombre: " + nombre + " Apellido: " + apellido + " Nacimiento: " + Nacimiento
                + " Telefono: " + telefono + " Direccion: " + direccion + " DNI: " + dni + "Email: "+ email;
    }

    

}
