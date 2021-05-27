package com.utn.teamA;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/*
* Clase Reserva
* @Antonela
* 24/5
*   La clase crea una reserva y calcula el costo de esa reserva
* en funcion al los menu seleccionados y cantidad de personas por menu. Ademas calcula el costo de mano de obra + IVA y
* Rentabilidad al %25.
* *
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
    //CREAR CONSTANTE IVA
    //CREAR CONSTANTE RENTABILIDAD

    //region Constructor
    public Reserva() {


    }

    public Reserva(LocalDate fechaEvento, Usuario usuario, int cantPerVeget, int cantPerClasico, int cantPerVegano, int cantPerDiab, ArrayList menu, String descripcion, boolean quiereBartender) {

        this.orderId = idClase++;
        fechaReserva = LocalDate.now();
        fechaEvento = new fechaEvento;
        idUsuario = usuario.getId();
        nombreCliente = usuario.getNombre();
        status = true;// por defecto
        cantidadPersonasVegetariano = cantPerVeget;
        cantidadPersonasClasico = cantPerClasico;
        cantidadPersonasVegano = cantPerVegano;
        cantidadPersonasDiabetico = cantPerDiab;
        menu = menu;
        descripcion = descripcion;
        quiereBartender = quiereBartender;
        costoTotal = calcularCostoTotal(menu);

        //quiereSushiMan. el cliente no lo decide asi que aca lo omito.

    }
//endregion

    //region Calcular Costo Total de la Reserva
    public Double calcularCostoTotal(ArrayList menuSeleccionados) {

        Double precioVeg = (0.00);
        Double precioCla = (0.00);
        Double precioVega = (0.00);
        Double precioDiab = (0.00);

        for (Menu x : menuSeleccionados) {
            if (x.getTipo().equals("Vegetariano")) {
                precioVeg = +x.getPrecio();

            }
            if (x.getTipo().equals("Clasico")) {
                precioCla = +x.getPrecio();
            }
            if (x.getTipo().equals("Vegano")) {
                precioVega = +x.getPrecio();
            }
            if (x.getTipo().equals("Diabetico")) {
                precioDiab = +x.getPrecio();
            }

        };

        int cantidadPersonasTotal = cantidadPersonasVegetariano + cantidadPersonasClasico + cantidadPersonasVegano + cantidadPersonasDiabetico;
        if (cantidadPersonasTotal < 3) {
            System.out.println("No hacemos reservas para menos de 4 personas");
        } else if (cantidadPersonasTotal > 3 && cantidadPersonasTotal <= 16){
             costoTotal =+ TipoEmpleado.MOZO;}
            if (cantidadPersonasTotal > 16  && cantidadPersonasTotal <= 32) {
                 costoTotal =+ TipoEmpleado.MOZO + TipoEmpleado.SUSHIMAN;
            } else if (cantidadPersonasTotal >32 && cantidadPersonasTotal <=55){
                     costoTotal=+ (TipoEmpleado.MOZO*2) + (TipoEmpleado.SUSHIMAN*2);
            }else if (cantidadPersonasTotal> 50){
                System.out.println("No estamos haciendo catering de mas de 50 personas, disculpe");
             }else{
                System.out.println("Ubo algun error, verifique con el programador: Antonela");
            }

            if(quiereBartender == true){
                costoTotal += TipoEmpleado.BARTENDER;
            }
            // costo + IVA y RENTABILIDAD al %25
           return costoTotal = (costoTotal * 0.21 / 0.25);
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