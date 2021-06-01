package com.utn.teamA;

import java.util.List;
import java.util.UUID;

public class Plato {

    private String platoId;
    private String nombre;
    private List<Ingrediente> listaDeIngredites;
    private String descripcion;
    private TipoPlato tipo;

    //region constructores

    public Plato() {
        this.platoId = UUID.randomUUID().toString();
    }

    public Plato(String nombre, List<Ingrediente> listaDeIngredites, String descripcion, TipoPlato tipo) {
        this.platoId = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.listaDeIngredites = listaDeIngredites;
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

    public List<Ingrediente> getListaDeIngredites() {
        return listaDeIngredites;
    }

    public void setListaDeIngredites(List<Ingrediente> listaDeIngredites) {
        this.listaDeIngredites = listaDeIngredites;
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


    //endregion


    @Override
    public String toString() {
        return Color.ANSI_BLUE + "\n\t PLATO \n" +
                Color.ANSI_CYAN + "Tipo: " + Color.ANSI_GREEN + tipo + "\n" +
                Color.ANSI_CYAN + "Nombre:" + Color.ANSI_GREEN + nombre + "\n" +
                Color.ANSI_CYAN + "Descripcion: " + Color.ANSI_GREEN + descripcion + "\n\n" +
                Color.ANSI_CYAN + "<<<<< Ingredientes >>>>> " + Color.ANSI_GREEN + "\n" +
                listaDeIngredites + "\n" +
                Color.ANSI_RESET + "\n";
    }
}
