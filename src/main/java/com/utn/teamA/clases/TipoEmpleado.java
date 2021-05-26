package com.utn.teamA.clases;

public enum TipoEmpleado {
    MOZO("mozo",1500),
    BARTENDER("bartender",2200),
    SUSHIMAN("sushiman",3610);

    protected final int sueldo;
    protected final String tipo;
    private TipoEmpleado(String tipo, int sueldo) {
        this.tipo = tipo;
        this.sueldo = sueldo;
        
    }

    

    
}