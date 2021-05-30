package com.utn.teamA.clases;

import java.time.LocalDate;

/**
 * Clase Abstracta Usuario
 *
 *
 * @Marco
 */

public abstract class Usuario{
    
    private String username;
    private String password;
    private LocalDate fechaRegistro;

    //region Constructores

    /**
     * Constructor vacio
     */
    public Usuario(){

    }

    /**
     * Constructor completo
     * @param username
     * @param password
     * @param fechaRegistro
     */
    public Usuario( String username, String password, LocalDate fechaRegistro) {

        this.username = username;
        this.password = password;
        this.fechaRegistro = LocalDate.now();
    }
    //endregion

    //region Getters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    //endregion

    //region Setters
    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    //endregion

    //region To String

    @Override
    public String toString() {
        return " User | Fecha registro: " + fechaRegistro + " Password: " + password + " Username: " + username;
    }
    //endregion

    //region Mostrar
    public abstract void mostrar();
    //endregion
    


}
