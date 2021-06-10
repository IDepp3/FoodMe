package com.utn.teamA.clases;

public enum TipoUsuario {
    
    ADMINISTRADOR("administrador"),
    CLIENTE("cliente");

    protected final String tipo;

    private TipoUsuario(String tipo) {
        this.tipo = tipo;

    }
}
