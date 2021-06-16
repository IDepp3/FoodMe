package com.utn.teamA.clases;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import com.utn.teamA.utils.Helpers;

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

    private String fechaReserva;
    private String fechaEvento;
    private  String idCliente; //
    private StringBuilder horarioLlegada;
    private StringBuilder horarioInicio;
    private StringBuilder horarioFinaliza;
    //private List<Menu> menus = new ArrayList();
    private String menus;
    private String descripcion;
    private double costoTotal;
    private boolean quiereBartender;
    private boolean status;
    private int cantidadPersonasTotal;
    private double precioFinal;


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
    public Reserva(String id){
        this.id = id;
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

    public Reserva(String fechaEvento, String idCliente, String menus,
        String descripcion, boolean quiereBartender) {
        this.id =  UUID.randomUUID().toString().substring(0, 10).replace("-", "g");
        this.fechaReserva = Helpers.fechaActual();
        this.fechaEvento = fechaEvento;
        /* this.horarioLlegada =horarioLlegada;
        this.horarioInicio = horarioInicio;
        this.horarioFinaliza = horarioFinaliza; */
        this.idCliente = idCliente;
        this.menus = menus;
        this.descripcion = descripcion;
        this.quiereBartender = quiereBartender;
        //this.cantidadPersonasTotal = calcularCantPerTotal();
        this.status = true;



    }
    //ESTE CONSTRUCTOR LO USAMOS PARA REGISTRAR UNA RESERVA
    public Reserva(String fechaEvento, String idCliente, StringBuilder horarioLlegada, StringBuilder horarioInicio, StringBuilder horarioFinaliza, String menus, String descripcion, boolean quiereBartender) {

        this.id =UUID.randomUUID().toString().substring(0, 10).replace("-", "g");
        this.fechaReserva = LocalDate.now().toString();
        this.fechaEvento = fechaEvento;
        this.idCliente = idCliente;
        this.horarioLlegada = horarioLlegada;
        this.horarioInicio = horarioInicio;
        this.horarioFinaliza = horarioFinaliza;
        this.menus = menus;
        this.descripcion = descripcion;
        this.quiereBartender = quiereBartender;
        this.status = true;
        //this.cantidadPersonasTotal = calcularCantPerTotal();
    }
    //ESTE CONSTRUCTOR LO USAMOS PARA GUARDAR LOS DATOS COMO VIENEN DEL JSON
    public Reserva(String id, String fechaReserva, String fechaEvento, String idCliente, StringBuilder horarioLlegada, StringBuilder horarioInicio, StringBuilder horarioFinaliza, String menus, String descripcion, Double costoTotal, boolean quiereBartender, boolean status, int cantidadPersonasTotal, double precioFinal) {
        this.id = id;
        this.fechaReserva = fechaReserva;
        this.fechaEvento = fechaEvento;
        this.idCliente = idCliente;
        this.horarioLlegada = horarioLlegada;
        this.horarioInicio = horarioInicio;
        this.horarioFinaliza = horarioFinaliza;
        this.menus = menus;
        this.descripcion = descripcion;
        this.costoTotal = costoTotal;
        this.quiereBartender = quiereBartender;
        this.status = status;
        this.cantidadPersonasTotal = cantidadPersonasTotal;
        this.precioFinal = precioFinal;

    }
    //endregion

    //region   Getters

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public String getFechaEvento() {
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

    public String getMenus() {
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

    public double getPrecioFinal() {
        return precioFinal;
    }
//endregion

    //region Setters

    public void setId(String id) {
        this.id = id;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public void setFechaEvento(String fechaEvento) {
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

    public void setMenus(String menus) {
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

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
//endregion

    //region Mostrar


    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + id + '\'' +
                ", fechaReserva='" + fechaReserva + '\'' +
                ", fechaEvento='" + fechaEvento + '\'' +
                ", idCliente='" + idCliente + '\'' +
                ", horarioLlegada=" + horarioLlegada +
                ", horarioInicio=" + horarioInicio +
                ", horarioFinaliza=" + horarioFinaliza +
                ", menus=" + menus +
                ", descripcion='" + descripcion + '\'' +
                ", costoTotal=" + costoTotal +
                ", quiereBartender=" + quiereBartender +
                ", status=" + status +
                ", cantidadPersonasTotal=" + cantidadPersonasTotal +
                ", precioFinal=" + precioFinal +
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
        return this.id.equals(reserva.getId());
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
    /* public int calcularCantPerTotal() {
        int total = 0;
        for (Menu m : this.menus) {

            total = total + m.getCantPersonas();
        }
        return total;
    } */
    //endregion

    //region Calcular Costo de la Reserva

    /* public double calcularCosto() {

        double costo = 0;
        double costoFinal = 0;
        for(Menu x: this.menus){
            costo = costo + x.calcularCostoTotal();
        }
        if(cantidadPersonasTotal>8){

            if(quiereBartender){
                costo = costo + TipoEmpleado.BARTENDER.sueldo;
            }
            costo = costo  + TipoEmpleado.MOZO.sueldo;

        }else if(cantidadPersonasTotal>25){
            if(quiereBartender){
                costo = costo + TipoEmpleado.BARTENDER.sueldo;
            }
            costo = costo  + TipoEmpleado.MOZO.sueldo + TipoEmpleado.SUSHIMAN.sueldo;

        }else if(cantidadPersonasTotal>40){
            if(quiereBartender){
                costo = costo + TipoEmpleado.BARTENDER.sueldo;
            }
            costo = costo  + (TipoEmpleado.MOZO.sueldo*2) + (TipoEmpleado.SUSHIMAN.sueldo);
        }

        return this.costoTotal ;

    } */

    /* public double calcularPrecionFinal(){
        double IVA = 1.21;
        double ganancia = 0.25;
        double costo = calcularCosto();
        return this.precioFinal= this.costoTotal * IVA / ganancia;
    } */


    //endregion

}