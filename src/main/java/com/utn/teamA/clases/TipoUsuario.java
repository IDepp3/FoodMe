package com.utn.teamA.clases;

public enum TipoUsuario {
    
    ADMINISTRADOR("administrador",1),
    CLIENTE("cliente",2);

    public final String tipo;
    public final int identificador;

    private TipoUsuario(String tipo,int identificador) {
        this.tipo = tipo;
        this.identificador=identificador;

    }
}
