package com.utn.teamA.clases;

public class Menu {

    private int cantReservas;

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

    @Override
    public String toString() {
        return "Menu{" +
                "cantReservas=" + cantReservas +
                '}';
    }
}
