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
    private TipoUsuario tipoUsuario;

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
    public Usuario( String username, String password, LocalDate fechaRegistro, TipoUsuario tipoUsuario) {

        this.username = username;
        this.password = password;
        this.fechaRegistro = fechaRegistro;
        this.tipoUsuario   = tipoUsuario;
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

    public TipoUsuario getTipoUsuario(){
        return this.tipoUsuario;
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

    public void setTipoUsuario(TipoUsuario tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }
    //endregion

    //region To String

    @Override
    public String toString() {
        return " User | Fecha registro: " + fechaRegistro.toString() + " Password: " + password + " Username: " + username;
    }
    //endregion

    //region Mostrar
    public abstract void mostrar();
    //endregion
    


}
