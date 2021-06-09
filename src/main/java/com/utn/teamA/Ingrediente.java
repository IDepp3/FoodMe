package com.utn.teamA;

import java.util.Scanner;
import java.util.UUID;

public class Ingrediente {

    private String id;
    private String nombre;
    private String descripcion;
    private double precio;

    //TODO atributo prooveedor tiene que ser tipo Proveedor
    private String proveedor = "---";

    //region constructores
    public Ingrediente() {
        this.id = UUID.randomUUID().toString();
    }

    public Ingrediente(String nombre, String descripcion, double precio, String proveedor) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.proveedor = proveedor;
    }
    //endregion

    //region getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    //endregion

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj instanceof Ingrediente){
            Ingrediente i = (Ingrediente)obj;
            if(this.getId().equals(i.getId()))
                return true;
        }

        return false;
    }


    @Override
    public String toString() {
        return Color.ANSI_BLUE + "\n\t INGREDIENTE\n" +
                Color.ANSI_CYAN + "Nombre:" + Color.ANSI_GREEN + nombre + '\n' +
                Color.ANSI_CYAN + "Descripcion: " + Color.ANSI_GREEN + descripcion + '\n' +
                Color.ANSI_CYAN + "Precio: " + Color.ANSI_GREEN + precio + '\n' +
                Color.ANSI_CYAN + "Proveedor: " + Color.ANSI_GREEN + proveedor +
                Color.ANSI_RESET + '\n';
    }

    public void crear(){

        Scanner teclado = new Scanner(System.in);

        System.out.println(
                Color.ANSI_BLUE +
                "\n\n" +
                " ----------------------------------------------------\n" +
                "| \t\t N U E V O    I N G R E D I E N T E \t\t |\n" +
                " ----------------------------------------------------" +
                " \n\n" +
                Color.ANSI_RESET);

        System.out.println(Color.ANSI_CYAN + "Ingrese nombre:" + Color.ANSI_RESET);
        this.nombre =  Helpers.nextLine();

        System.out.println(Color.ANSI_CYAN + "Ingrese Descripcion:" + Color.ANSI_RESET);
        this.descripcion =  Helpers.nextLine();

        System.out.println(Color.ANSI_CYAN + "Ingrese precio:" + Color.ANSI_RESET);
        this.precio =  Helpers.validarDouble();

        System.out.println( this );

    }
}
