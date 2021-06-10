package com.utn.teamA.clases;

import java.time.LocalDate;

/**
 * Clase Abstracta Usuario
 *
 *
 * @Marco
 */

public abstract class Usuario{
    
    // region ATRIBUTOS

    private String username;
    private String password;
    private String email;
    private LocalDate fechaRegistro;
    private TipoUsuario tipoUsuario;

    // endregion
    
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
    

    // CONSTRUCTOR PARA QUE NO SE ROMPA

    public Usuario(String username, String password, LocalDate fechaRegistro){
        this.username      = username;
        this.password      = password;
        this.fechaRegistro = fechaRegistro;
    }

    // CONSTRUCTOR USADO PARA LOGUEAR UN USUARIO 
    
    public Usuario(String username, String password){
        this.username = username;
        this.password = password;
    }

    // constructor usado para crear un usuario

    public Usuario(String username, String password, String email, LocalDate fechaRegistro, TipoUsuario tipoUsuario){
        this.username      = username;
        this.password      = password;
        this.email         = email;
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

    public String getEmail(){
        return this.email;
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

    public void setEmail(String email){
        this.email = email;
    }
    //endregion

    //region To String

    @Override
    public String toString() {
        return "\nNombre Usuario : " + this.username + "\nEmail : " + this.email + "\nFecha Registro : " + this.fechaRegistro + "\nTipo de Usuario : " + this.tipoUsuario;
    }
    //endregion

}
