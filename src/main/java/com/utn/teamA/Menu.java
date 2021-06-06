package com.utn.teamA;

import java.util.List;
import java.util.UUID;

public class Menu {

    // region atributos

    private String id;
    private TipoMenu tipo;
    private String nombre;
    private String descripcion;
    private List<Plato> listaDePlatos;
    private double precio;

    //endregion

    //region contructores
    public Menu() {
        this.id = UUID.randomUUID().toString();
    }

    public Menu(TipoMenu tipo, String nombre, String descripcion, List<Plato> platos, double precio) {
        this();
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaDePlatos = platos;
        this.precio = precio;
    }
    //endregion

    //region getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoMenu getTipo() {
        return tipo;
    }

    public void setTipo(TipoMenu tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Plato> getPlatos() {
        return listaDePlatos;
    }

    public void setPlatos(List<Plato> platos) {
        this.listaDePlatos = platos;
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
        return Color.ANSI_BLUE + "\n\t MENU \n" +
                Color.ANSI_CYAN + "Tipo: " + Color.ANSI_GREEN + tipo + "\n" +
                Color.ANSI_CYAN + "Nombre:" + Color.ANSI_GREEN + nombre + "\n" +
                Color.ANSI_CYAN + "Descripcion: " + Color.ANSI_GREEN + descripcion + "\n\n" +
                //TODO buscar y agregar platos al plato
                //Color.ANSI_CYAN + "<<<<< Platos >>>>> " + Color.ANSI_GREEN + "\n" +
                //listaDePlatos + "\n" +
                Color.ANSI_RESET + "\n";
    }

    
}
