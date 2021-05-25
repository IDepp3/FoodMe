package com.utn.teamA;

import java.util.Scanner;
import java.util.UUID;

public class Ingrediente {

    private String id;
    private String nombre;
    private String descripcion;
    private double precio;

    //TODO atributo prooveedor tiene que ser tipo Proveedor
    private String proveedor;

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
    public String toString() {
        return "Ingrediente{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", proveedor='" + proveedor + '\'' +
                '}';
    }

    public void crear(){

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese nombre:");
        this.nombre =  teclado.nextLine();

        System.out.println("Ingrese Descripcion:");
        this.descripcion =  teclado.nextLine();

        System.out.println("Ingrese precio:");
        this.precio =  Helpers.nextDouble();

    }
}
