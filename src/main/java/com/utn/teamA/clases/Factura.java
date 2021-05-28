package com.utn.teamA.clases;

import com.utn.teamA.clases.Cliente;

import java.time.LocalDate;

/**
 *  Clase Factura
 */
public class Factura {
    private int idFactura;
    private LocalDate fechaPago;
    private Cliente cliente;
    private Double precioFinal;
    private Empresa empresa;
    private List<Menu> listaMenusSeleccionados;

    //region Constructores
    /**
     * Contructor de la clase Factura vacio
     */

   public Factura(){

    }

    /**
     * Constructor de la clase Factura
     * @param cliente
     * @param empresa
     * @param listaMenusSeleccionados
     */
    public Factura(Cliente cliente, Empresa empresa, List<Menu> listaMenusSeleccionados) {
        this.cliente = cliente;
        this.empresa = empresa;
        this.listaMenusSeleccionados = listaMenusSeleccionados;
    }
    //endregion

    //region Getters

    public int getIdFactura() {
        return idFactura;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public List<Menu> getListaMenusSeleccionados() {
        return listaMenusSeleccionados;
    }

    //endregion

    //region Setters

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setListaMenusSeleccionados(List<Menu> listaMenusSeleccionados) {
        this.listaMenusSeleccionados = listaMenusSeleccionados;
    }

    //endregion

    //region Mostrar

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura=" + idFactura +
                ", fechaPago=" + fechaPago +
                ", cliente=" + cliente +
                ", precioFinal=" + precioFinal +
                ", empresa=" + empresa +
                ", listaMenusSeleccionados=" + listaMenusSeleccionados +
                '}';
    }

    public void mostrar(){
        System.out.println(toString());
    }

    //endregion

}
