package com.utn.teamA.clases;

public class Menu {

    private int cantReservas;
    private TipoEmpleado a;

    public Menu(){
    }
    public Menu(int cantReservas){
        this.cantReservas = cantReservas;
    }

    public int getCantReservas() {
        return cantReservas;
    }

    public void setCantReservas(int cantReservas) {
        this.cantReservas = cantReservas;
    }

    public TipoEmpleado getA() {
        return a;
    }

    public void setA(TipoEmpleado a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "cantReservas=" + cantReservas +
                '}';
    }
}
