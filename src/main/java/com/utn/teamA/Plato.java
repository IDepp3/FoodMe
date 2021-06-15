package com.utn.teamA;

import java.sql.Array;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Plato {

    private String platoId;
    private String nombre;
    private List<String> ingredientes;
    private String descripcion;
    private TipoPlato tipo;
    private boolean estado;
    private double precio;

    //region constructores

    public Plato() {
        this.platoId = UUID.randomUUID().toString();
        this.estado = true;
    }

    public Plato(String nombre, List<String> listaDeIngredites, String descripcion, TipoPlato tipo, boolean estado) {
        this();
        this.nombre = nombre;
        this.ingredientes = listaDeIngredites;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    //endregion

    //region getters and setters

    public String getPlatoId() {
        return platoId;
    }

    public void setPlatoId(String platoId) {
        this.platoId = platoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getListaDeIngredites() {
        return ingredientes;
    }

    public void setListaDeIngredites(List<String> listaDeIngredites) {
        this.ingredientes = listaDeIngredites;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoPlato getTipo() {
        return tipo;
    }

    public void setTipo(TipoPlato tipo) {
        this.tipo = tipo;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    public boolean getEstado(){
        return this.estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //endregion


    @Override
    public String toString() {
        return Color.ANSI_BLUE + "\n\t PLATO \n" +
                Color.ANSI_CYAN + "Tipo: " + Color.ANSI_GREEN + tipo + "\n" +
                Color.ANSI_CYAN + "Nombre:" + Color.ANSI_GREEN + nombre + "\n" +
                Color.ANSI_CYAN + "Descripcion: " + Color.ANSI_GREEN + descripcion + "\n" +
                Color.ANSI_CYAN + "<<<<< Ingredientes >>>>> " + Color.ANSI_GREEN + "\n" +
                this.mostrartIngredientes() + "\n" +
                Color.ANSI_RESET + "\n";
    }

    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj instanceof Plato){
            Plato p = (Plato)obj;
            if(this.getPlatoId().equals(p.getPlatoId()))
                return true;
        }

        return false;
    }


    private String mostrartIngredientes(){
        String ingredientes = "";
        IngredientePersistencia ingredientePersistencia = new IngredientePersistencia();
        List<Ingrediente> listaDeIngredites = ingredientePersistencia.obtenerRegistros();

        if( this.ingredientes != null){
            for (String ingredienteId : this.ingredientes ) {

                for ( Ingrediente ingrediente : listaDeIngredites ) {
                    if(ingrediente.getId().equals( ingredienteId ) ){
                        ingredientes += ingrediente.mostrarNombre();
                    }
                }
            }
        }

        return ingredientes;
    }
}
