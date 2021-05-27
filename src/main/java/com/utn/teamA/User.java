package com.utn.teamA;

import java.time.LocalDate;

public class User extends Persona{
    
    private String username;
    private String password;
    private LocalDate fechaRegistro;

    public User(int id, String nombre, String apellido, LocalDate fechaNacimiento, String telefono, String direccion,
            String dni, String email, String username, String password, LocalDate fechaRegistro) {
        super(id, nombre, apellido, fechaNacimiento, telefono, direccion, dni, email);
        this.username = username;
        this.password = password;
        this.fechaRegistro = fechaRegistro;
    }
    
    public User(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return " User | Fecha registro: " + fechaRegistro + " Password: " + password + " Username: " + username;
    }

    
    


}
