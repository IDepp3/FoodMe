package com.utn.teamA.validaciones;

public class Validaciones {
    
    public static boolean validarNombre(String nombre){
        return nombre.matches("^[A-Z]{1}[a-z0-9]{1,}[_-]?[a-z0-9]{2,}$");
    }

    public static boolean validarPassword(String password){
        return password.matches("^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$");
    }
}
