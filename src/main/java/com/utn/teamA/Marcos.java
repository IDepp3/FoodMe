package com.utn.teamA;

public class Marcos {
    
    private String nombre;

    public Marcos(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Marcos [nombre=" + nombre + "]";
    }

    public void saludar(){
        System.out.println("Hola mi nombre es "+this.nombre);
    }

}
