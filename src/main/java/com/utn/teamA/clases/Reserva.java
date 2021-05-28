package com.utn.teamA.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
* Clase Reserva
* @Antonela
* 24/5
*   La clase registra  una reserva
 *   Chequea dias disponibles  para tal.
 *
 */

public class Reserva {

    private static int idClase = 1;
    private int orderId;
    private LocalDate fechaReserva; // Lo puedo hacer String
    private LocalDate fechaEvento; // Lo puedo hacer String
    private int idUsuario;
    private String nombreCliente;
    private boolean status;
    private int cantidadPersonasVegetariano;
    private int cantidadPersonasClasico;
    private int cantidadPersonasVegano;
    private int cantidadPersonasDiabetico;
    private int cantidadPersonasTotal;
    private ArrayList menus;
    private String descripcion;
    private Double costoTotal;
    private boolean quiereBartender;
    private boolean quiereSushiman; // no es necesario porque nole preguntamos al cliente


    //region Constructor

    /**
     * Constructor vacio
     */
    public Reserva() {

    }

    /**
     * Constructor completo
     *
     * @param fechaEvento
     * @param idUsuario
     * @param nombreCliente
     * @param cantidadPersonasVegetariano
     * @param cantidadPersonasClasico
     * @param cantidadPersonasVegano
     * @param cantidadPersonasDiabetico
     * @param menus
     * @param descripcion
     * @param quiereBartender
     */
    public Reserva(LocalDate fechaEvento, int idUsuario, String nombreCliente, int cantidadPersonasVegetariano,
<<<<<<< HEAD:src/main/java/com/utn/teamA/clases/Reserva.java
        int cantidadPersonasClasico, int cantidadPersonasVegano, int cantidadPersonasDiabetico, ArrayList menus,
        String descripcion, boolean quiereBartender) {
=======
                   int cantidadPersonasClasico, int cantidadPersonasVegano, int cantidadPersonasDiabetico, ArrayList menus,
                   String descripcion, boolean quiereBartender) {
>>>>>>> Anto:src/main/java/com/utn/teamA/Modelo/Reserva.java

        this.fechaEvento = fechaEvento;
        this.idUsuario = idUsuario;
        this.nombreCliente = nombreCliente;
        this.cantidadPersonasVegetariano = cantidadPersonasVegetariano;
        this.cantidadPersonasClasico = cantidadPersonasClasico;
        this.cantidadPersonasVegano = cantidadPersonasVegano;
        this.cantidadPersonasDiabetico = cantidadPersonasDiabetico;
        this.menus = menus;
        this.descripcion = descripcion;
        this.quiereBartender = quiereBartender;
    }
    //endregion

    //region   Getters
    public static int getIdClase() {
        return idClase;
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public LocalDate getFechaEvento() {
        return fechaEvento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public boolean isStatus() {
        return status;
    }

    public int getCantidadPersonasVegetariano() {
        return cantidadPersonasVegetariano;
    }

    public int getCantidadPersonasClasico() {
        return cantidadPersonasClasico;
    }

    public int getCantidadPersonasVegano() {
        return cantidadPersonasVegano;
    }

    public int getCantidadPersonasDiabetico() {
        return cantidadPersonasDiabetico;
    }

    public int getCantidadPersonasTotal() {
        return cantidadPersonasTotal;
    }

    public ArrayList getMenus() {
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

    public boolean isQuiereSushiman() {
        return quiereSushiman;
    }
    //endregion

    //region Setters

    public static void setIdClase(int idClase) {
        Reserva.idClase = idClase;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCantidadPersonasVegetariano(int cantidadPersonasVegetariano) {
        this.cantidadPersonasVegetariano = cantidadPersonasVegetariano;
    }

    public void setCantidadPersonasClasico(int cantidadPersonasClasico) {
        this.cantidadPersonasClasico = cantidadPersonasClasico;
    }

    public void setCantidadPersonasVegano(int cantidadPersonasVegano) {
        this.cantidadPersonasVegano = cantidadPersonasVegano;
    }

    public void setCantidadPersonasDiabetico(int cantidadPersonasDiabetico) {
        this.cantidadPersonasDiabetico = cantidadPersonasDiabetico;
    }

    public void setCantidadPersonasTotal(int cantidadPersonasTotal) {
        this.cantidadPersonasTotal = cantidadPersonasTotal;
    }

    public void setMenus(ArrayList menus) {
        this.menus = menus;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public void setQuiereBartender(boolean quiereBartender) {
        this.quiereBartender = quiereBartender;
    }

    public void setQuiereSushiman(boolean quiereSushiman) {
        this.quiereSushiman = quiereSushiman;
    }

    //endregion

    //region Mostrar

    @Override
    public String toString() {
        return "Reserva{" +
                "orderId=" + orderId +
                ", fechaReserva=" + fechaReserva +
                ", fechaEvento=" + fechaEvento +
                ", idUsuario=" + idUsuario +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", status=" + status +
                ", cantidadPersonasVegetariano=" + cantidadPersonasVegetariano +
                ", cantidadPersonasClasico=" + cantidadPersonasClasico +
                ", cantidadPersonasVegano=" + cantidadPersonasVegano +
                ", cantidadPersonasDiabetico=" + cantidadPersonasDiabetico +
                ", cantidadPersonasTotal=" + cantidadPersonasTotal +
                ", menus=" + menus +
                ", descripcion='" + descripcion + '\'' +
                ", costoTotal=" + costoTotal +
                ", quiereBartender=" + quiereBartender +
                ", quiereSushiman=" + quiereSushiman +
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
        return getOrderId() == reserva.getOrderId() && getIdUsuario() == reserva.getIdUsuario() && isStatus() == reserva.isStatus() && getCantidadPersonasVegetariano() == reserva.getCantidadPersonasVegetariano() && getCantidadPersonasClasico() == reserva.getCantidadPersonasClasico() && getCantidadPersonasVegano() == reserva.getCantidadPersonasVegano() && getCantidadPersonasDiabetico() == reserva.getCantidadPersonasDiabetico() && getCantidadPersonasTotal() == reserva.getCantidadPersonasTotal() && isQuiereBartender() == reserva.isQuiereBartender() && isQuiereSushiman() == reserva.isQuiereSushiman() && Objects.equals(getFechaReserva(), reserva.getFechaReserva()) && Objects.equals(getFechaEvento(), reserva.getFechaEvento()) && getNombreCliente().equals(reserva.getNombreCliente()) && getMenus().equals(reserva.getMenus()) && getDescripcion().equals(reserva.getDescripcion()) && getCostoTotal().equals(reserva.getCostoTotal());
    }

    @Override
    public int hashCode() {
        return ( 31  * Objects.hash(getOrderId(), getFechaReserva(), getFechaEvento(), getIdUsuario(), getNombreCliente(), isStatus(), getCantidadPersonasVegetariano(), getCantidadPersonasClasico(), getCantidadPersonasVegano(), getCantidadPersonasDiabetico(), getCantidadPersonasTotal(), getMenus(), getDescripcion(), getCostoTotal(), isQuiereBartender(), isQuiereSushiman()));
    }




    //endregion
}