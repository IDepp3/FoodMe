package com.utn.teamA.clases;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
* Clase Reserva
* @Antonela
* 24/5
*   La clase registra  una reserva
 *   Chequea dias disponibles  para tal.
 *
 */

public class Reserva {


    private static final long serialVersionUID = 123456L;
    private String id;
    private String fechaReserva;
    private String fechaEvento;
    private  String idCliente; //
    private List<Menu> menus = new ArrayList();
    private String descripcion;
    private Double costoTotal;
    private boolean quiereBartender;
    private boolean status;
    private int cantidadPersonasTotal;


    //region Constructor

    /**
     * Constructor vacio
     */
    public Reserva() {
        this.fechaReserva = null;
        this.fechaEvento= null;
        this.id =  UUID.randomUUID().toString().substring(0, 10).replace("-", "g");

        status=true;
    }

    /**
     * Constructor completo
     *
     * @param fechaEvento
     * @param idCliente
     * @param menus
     * @param descripcion
     * @param quiereBartender
     */
    public Reserva(String fechaEvento, String idCliente, List<Menu> menus,
        String descripcion, boolean quiereBartender) {
        this.id =  UUID.randomUUID().toString().substring(0, 10).replace("-", "g");
        this.fechaReserva = null;
        this.fechaEvento = fechaEvento;
        this.idCliente = idCliente;
        this.menus = menus;
        this.descripcion = descripcion;
        this.quiereBartender = quiereBartender;
        this.cantidadPersonasTotal = calcularCantPerTotal();
        this.status = true;
    }
    //endregion

    //region   Getters

    public String getId() {
        return id;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public boolean isStatus() {
        return status;
    }

    public int getCantidadPersonasTotal() {
        return cantidadPersonasTotal;
    }
    public List getMenus() {
        return menus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public boolean isQuiereBartender() {
        return quiereBartender;
    }


    public String getCliente() { return idCliente;    }

    public static long getSerialVersionUID() { return serialVersionUID;    }

//endregion

    //region Setters


    public void setId(String orderId) {
        this.id = orderId;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public void setCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setMenus(ArrayList menus) {
        this.menus = menus;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setQuiereBartender(boolean quiereBartender) {
        this.quiereBartender = quiereBartender;
    }


    public void setMenus(List<Menu> menus) { this.menus = menus;
    }

    public void setCostoTotal(Double costoTotal) { this.costoTotal = costoTotal;
    }

    public void setCantidadPersonasTotal(int cantidadPersonasTotal) {
        this.cantidadPersonasTotal = cantidadPersonasTotal;
    }


    //endregion

    //region Mostrar

    @Override
    public String toString() {
        return "Reserva{" +
                " Id=" + id +
                ", fechaReserva=" + fechaReserva +
                ", fechaEvento=" + fechaEvento +
                ", Cliente=" + idCliente+
                ", status=" + status +
                ", menus=" + menus.toString() +
                ", descripcion='" + descripcion + '\'' +
                ", costoTotal=" + costoTotal +
                ", quiereBartender=" + quiereBartender +
                '}';
    }
    public void mostrar(){
        System.out.println(toString());
    }

    //endregion

    //region Equals and HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reserva)) return false;
        Reserva reserva = (Reserva) o;
        return getId().equals(reserva.getId());
    }

    @Override
    public int hashCode() {
        return ( 31  * Objects.hash(getId()));
    }


    public boolean esIgual(Reserva reserva){
        if(this == reserva)
            return true;

        if(this.getId().equals(reserva.getId()))
            return true;

        return false;
    }


    //endregion

    //region Calcular Cantidad de personas que tiene la Lista de reservas en Total
    public int calcularCantPerTotal(){
        int total = 0;
        for (Menu m: this.menus) {

            total = total+ m.getCantReservas();
        }
        return total;
    }
    //endregion

    //region Calcular Costo de la Reserva

    public void calcularCosto(){}

    //endregion

}