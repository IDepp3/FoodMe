package com.utn.teamA.clases;

import java.time.LocalDate;

/**
 * CLASE ABSTRACTA USUARIO
 *
 *
 * @Marco
 */

public abstract class Usuario{
    
    // region ATRIBUTOS

    private String username;
    private String password;
    private String email;
    private String fechaRegistro;
    private String tipoUsuario;

    // endregion
    
    //region Constructores

    /**
     * CONSTRUCTOR VACIO
     */
    public Usuario(){

    }

    /**
     * CONSTRUCTOR COMPLETO
     * @param username
     * @param password
     * @param fechaRegistro
     */
    

    // CONSTRUCTOR PARA QUE NO SE ROMPA

    public Usuario(String username, String password, String fechaRegistro){
        this.username      = username;
        this.password      = password;
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario(String email){
        this.email = email;
    }

    // CONSTRUCTOR USADO PARA LOGUEAR UN USUARIO 
    
    public Usuario(String username, String password){
        this.username = username;
        this.password = password;
    }

    // CONSTRUCTOR USADO PARA CREAR UN USUARIO

    public Usuario(String username, String password, String email, String fechaRegistro, String tipoUsuario){
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

    public String getTipoUsuario(){
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

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setTipoUsuario(String tipoUsuario){
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

    public boolean existeUsuario(Cliente t){
        boolean resp = false;

        if(this.username.equals(t.getUsername()) && this.password.equals(t.getPassword()))
            resp = true;

        return resp;
    }
}
