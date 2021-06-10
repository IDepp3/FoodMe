package com.utn.teamA.clases;

public class Menu {

    private int cantPersonas;
    private double precioPorUnidad; // se calcula segun los ingredientes
    private double costoTotal;
    private TipoEmpleado a;

    public Menu(){
    }
    public Menu(int cantPersonas){
        this.cantPersonas = cantPersonas;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public TipoEmpleado getA() {
        return a;
    }

    public double getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setA(TipoEmpleado a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "cantReservas=" + cantPersonas +
                '}';
    }

    public double calcularCostoTotal(){
        return precioPorUnidad*cantPersonas;
    }
}
