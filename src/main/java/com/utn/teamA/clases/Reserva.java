package com.utn.teamA.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Clase Reserva
 *
 * @Antonela 24/5
 * La clase registra  una reserva
 * Chequea dias disponibles  para tal.
 */

public class Reserva {


    private static final long serialVersionUID = 123456L;
    private String id;
    private LocalDate fechaReserva;
    private LocalDate fechaEvento;
    private StringBuilder horarioLlegada;
    private StringBuilder horarioInicio;
    private StringBuilder horarioFinaliza;
    private String idCliente; //
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
        this.id = UUID.randomUUID().toString().substring(0, 10).replace("-", "g");
        this.fechaReserva = LocalDate.now();
        status = true;
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
    public Reserva(LocalDate fechaEvento, StringBuilder horarioLlegada, StringBuilder horarioInicio ,StringBuilder horarioFinaliza, String idCliente, List<Menu> menus,
                   String descripcion, boolean quiereBartender) {
        this.id = UUID.randomUUID().toString().substring(0, 10).replace("-", "g");
        this.fechaReserva = LocalDate.now();
        this.fechaEvento = fechaEvento;
        this.horarioLlegada =horarioLlegada;
        this.horarioInicio = horarioInicio;
        this.horarioFinaliza = horarioFinaliza;
        this.idCliente = idCliente;
        this.menus = menus;
        this.descripcion = descripcion;
        this.quiereBartender = quiereBartender;
        this.cantidadPersonasTotal = calcularCantPerTotal();
        this.status = true;
    }
    //endregion

    //region   Getters

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public LocalDate getFechaEvento() {
        return fechaEvento;
    }

    public StringBuilder getHorarioLlegada() {
        return horarioLlegada;
    }

    public StringBuilder getHorarioInicio() {
        return horarioInicio;
    }

    public StringBuilder getHorarioFinaliza() {
        return horarioFinaliza;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public List<Menu> getMenus() {
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

    public boolean isStatus() {
        return status;
    }

    public int getCantidadPersonasTotal() {
        return cantidadPersonasTotal;
    }


    //endregion

    //region Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public void setHorarioLlegada(StringBuilder horarioLlegada) {
        this.horarioLlegada = horarioLlegada;
    }

    public void setHorarioInicio(StringBuilder horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public void setHorarioFinaliza(StringBuilder horarioFinaliza) {
        this.horarioFinaliza = horarioFinaliza;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setMenus(List<Menu> menus) {
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

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCantidadPersonasTotal(int cantidadPersonasTotal) {
        this.cantidadPersonasTotal = cantidadPersonasTotal;
    }


    //endregion

    //region Mostrar


    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + id + '\'' +
                ", fechaReserva=" + fechaReserva +
                ", fechaEvento=" + fechaEvento +
                ", horarioLlegada=" + horarioLlegada +
                ", horarioInicio=" + horarioInicio +
                ", horarioFinaliza=" + horarioFinaliza +
                ", idCliente='" + idCliente + '\'' +
                ", menus=" + menus +
                ", descripcion='" + descripcion + '\'' +
                ", costoTotal=" + costoTotal +
                ", quiereBartender=" + quiereBartender +
                ", status=" + status +
                ", cantidadPersonasTotal=" + cantidadPersonasTotal +
                '}';
    }

    public void mostrar() {
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
        return (31 * Objects.hash(getId()));
    }


    public boolean esIgual(Reserva reserva) {
        if (this == reserva)
            return true;

        if (this.getId().equals(reserva.getId()))
            return true;

        return false;
    }


    //endregion

    //region Calcular Cantidad de personas que tiene la Lista de reservas en Total
    public int calcularCantPerTotal() {
        int total = 0;
        for (Menu m : this.menus) {

            total = total + m.getCantReservas();
        }
        return total;
    }
    //endregion

    //region Calcular Costo de la Reserva

    public void calcularCosto() {
    }

    //endregion

}