package com.utn.teamA;

import java.time.LocalDate;

import com.utn.teamA.Persona;

public class Usuario extends Persona{

    private int idUsuario;
    private String nombreUsuario;
    private String contraseña;
    private LocalDate fechaRegistro;

    public Usuario(int id, String nombre, String apellido, LocalDate Nacimiento, String telefono, String direccion,
            String dni, String email, int idUsuario, String nombreUsuario, String contraseña, LocalDate fechaRegistro) {
        super(id, nombre, apellido, Nacimiento, telefono, direccion, dni, email);
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.fechaRegistro = fechaRegistro;
    }
    
    public Usuario() {
        
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return " Usuario | Id usuario: " + idUsuario + " Nombre usuario: " + nombreUsuario + " Contraseña: " + contraseña
                + " Fecha registro: " + fechaRegistro;
    }

    

    
   
    

    


}