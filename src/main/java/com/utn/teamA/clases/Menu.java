package com.utn.teamA.clases;

import com.utn.teamA.ConexionDatos.PlatoPersistencia;
import com.utn.teamA.enums.TipoMenu;
import com.utn.teamA.utils.Color;

import java.util.List;
import java.util.UUID;

public class Menu {

    // region atributos

    private String id;
    private TipoMenu tipo;
    private String nombre;
    private String descripcion;
    private List<String> listaDePlatos;
    private double precio;
    private boolean estado;


    //endregion

    //region contructores
    public Menu() {

        this.id = UUID.randomUUID().toString();
        this.estado = true;
    }

    public Menu(TipoMenu tipo, String nombre, String descripcion, List<String> platos, double precio) {
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

    public List<String> getPlatos() {
        return listaDePlatos;
    }

    public void setPlatos(List<String> platos) {
        this.listaDePlatos = platos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    public boolean getEstado(){
        return this.estado;
    }


    //endregion

    @Override
    public String toString() {
        return Color.ANSI_BLUE + "\n\t MENU \n" +
                Color.ANSI_CYAN + "Tipo: " + Color.ANSI_GREEN + tipo + "\n" +
                Color.ANSI_CYAN + "Nombre:" + Color.ANSI_GREEN + nombre + "\n" +
                Color.ANSI_CYAN + "Precio: " + Color.ANSI_GREEN + precio + '\n' +
                Color.ANSI_CYAN + "Descripcion: " + Color.ANSI_GREEN + descripcion + "\n" +
                Color.ANSI_CYAN + "<<<<< Platos >>>>> " + Color.ANSI_GREEN + "\n" +
                this.mostrartPlatos() + "\n" +
                Color.ANSI_RESET + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj instanceof Menu){
            Menu m = (Menu)obj;
            if(this.getId().equals(m.getId()))
                return true;
        }

        return false;
    }


    private String mostrartPlatos(){
        String platos = "";
        PlatoPersistencia platoPersistencia = new PlatoPersistencia();
        List<Plato> listaDePlatos = platoPersistencia.obtenerRegistros();

        if( this.listaDePlatos != null){
            for (String platoId : this.listaDePlatos ) {
                for ( Plato plato : listaDePlatos ) {
                    if(plato.getPlatoId().equals( platoId ) ){
                        platos += plato.mostrarNombre();
                    }
                }
            }
        }

        return platos;
    }


}
