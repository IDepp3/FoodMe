package com.utn.teamA.clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Clase Empresa
 */

public class Empresa {

    private String nombre;
    private String direccion;
    private String CUIT;
    private LocalDate nacimiento;
    private String localidad;

    private List<Usuario> listaUsuarios;
    private List<Reserva> listaReservas;
    private List<Menu> listaMenus;
    private List<Empleado> listaEmpleados;
    // private List<Venta>listaHistorialVentas;

    // region Constructor

    /**
     * Constructor de la clase vacio
     *
     */
    public Empresa() {

    }

    /**
     *
     * @param elNombre
     * @param laDireccion
     * @param elCUIT
     * @param elNacimiento
     * @param unaLocalidad
     */

    public Empresa(String elNombre, String laDireccion, String elCUIT, LocalDate elNacimiento, String unaLocalidad) {
        nombre = elNombre;
        direccion = laDireccion;
        CUIT = elCUIT;
        nacimiento = elNacimiento;
        localidad = unaLocalidad;
        listaUsuarios = new ArrayList<Usuario>();
        listaReservas = new ArrayList<Reserva>();
        listaEmpleados = new ArrayList<Empleado>();
        listaMenus = new ArrayList<Menu>();
    }

    /**
     *
     * @param nombre
     * @param direccion
     * @param CUIT
     * @param nacimiento
     * @param localidad
     * @param listaUsuarios
     * @param listaReservas
     * @param listaMenus
     * @param listaEmpleados
     */

    public Empresa(String nombre, String direccion, String CUIT, LocalDate nacimiento, String localidad,
            List<Usuario> listaUsuarios, List<Reserva> listaReservas, List<Menu> listaMenus,
            List<Empleado> listaEmpleados) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.CUIT = CUIT;
        this.nacimiento = nacimiento;
        this.localidad = localidad;
        this.listaUsuarios = listaUsuarios;
        this.listaReservas = listaReservas;
        this.listaMenus = listaMenus;
        this.listaEmpleados = listaEmpleados;
    }
    // endregion

    // region Getters

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCUIT() {
        return CUIT;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public String getLocalidad() {
        return localidad;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public List<Menu> getListaMenus() {
        return listaMenus;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    // endregion

    // region Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public void setListaMenus(List<Menu> listaMenus) {
        this.listaMenus = listaMenus;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    // endregion

    // region Mostrar

    @Override
    public String toString() {
        return "Empresa{" + "nombre='" + nombre + '\'' + ", direccion='" + direccion + '\'' + ", CUIT='" + CUIT + '\''
                + ", nacimiento=" + nacimiento + ", localidad='" + localidad + '\'' + ", listaUsuarios=" + listaUsuarios
                + ", listaReservas=" + listaReservas + ", listaMenus=" + listaMenus + ", listaEmpleados="
                + listaEmpleados + '}';
    }

    public void mostrar() {
        System.out.println(toString());
    }

    // endregion

    // region Iniciar Sistema

    /**
     * iniciarSistema() Deberia cargar los archivos en los listas y mediante un menu
     * se puede accder al menu del administrador o al del cliente cuando elije la
     * opcion Salir se deberia persistir en archivo todo lo trabajado
     */
    public void iniciarSistema() {

        @SuppressWarnings("resource") // el scanner no se cerro close.
        Scanner entradaEscaner = new Scanner(System.in);
        String seguir = "si";
        while (seguir.equals("si")) {
            System.out.println("1- Administrador");
            System.out.println("2- Cliente");
            System.out.println("0- Salir");
            Integer opcion;
            opcion = entradaEscaner.nextInt();
            switch (opcion) {
                case 1:
                    getMenuAdministrador();
                    break;
                case 2:
                    getMenuCliente();
                    break;
                case 0:
                    // guardar datos en archivos JSON?
                    System.out.println("Gracias por utilizar el sistema.\n Que tenga un buen dia!!!");
                    seguir = "no";
                    break;
            }
        }
    }
    // endregion

    // region Menu Administrador
    public void getMenuAdministrador() {

    }
    // endregion

    // region MENU CLIENTE

    private void getMenuCliente() {
        boolean resp = true;
        Scanner entradaEscaner = new Scanner(System.in);
        while (resp) {
            System.out.println("MENU PRINCIPAL");
            System.out.println();
            System.out.println("1- Ver menus");
            System.out.println("2- Hacer reserva");
            System.out.println("3- Informacion personal");
            System.out.println("0- Salir");
            int opcion;
            try {
                opcion = entradaEscaner.nextInt();

                switch (opcion) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        System.out.println("VISTA DE LOS MENUS DISPONIBLES");
                        break;
                    case 2:
                        System.out.println("REALIZAR RESERVA");
                        break;
                    case 3:
                        System.out.println("INFORMACION PERSONAL CON LA OPCION DE REALIZAR ALGUN CAMBIO EN SU PERFIL");
                        menuInformacionPersonal();
                        break;
                    default:

                        break;
                }
            } catch (InputMismatchException e) {

            }
        }
    }

    private void menuInformacionPersonal() {
        boolean resp = true;
        Scanner entradaEscaner = new Scanner(System.in);
        while (resp) {
            System.out.println("INFORMACION PERSONAL");
            System.out.println();
            System.out.println("1- Ver informacion personal");
            System.out.println("2- Modificar informacion");
            System.out.println("3- Historial de compras");
            System.out.println("4- Reservas pendientes");
            System.out.println("0- Salir");
            int opcion;
            try {
                opcion = entradaEscaner.nextInt();
                switch (opcion) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        System.out.println("MUESTRA LA INFORMACION PERSONAL ACTUAL");
                        break;
                    case 2:
                        menuModificarDatos();
                        break;
                    case 3:
                        System.out.println("HISTORIAL PERSONAL DE COMPRAS");
                        break;
                    case 4:
                        System.out.println("LISTA CON COMPRAS PENDIENTES AL DIA DE LA FECHA");
                        System.out.println(
                                "Si es existe algun pedido se le puede dar la opcion que modifique algo de la reserva realizada");
                        break;
                    default:

                        break;
                }
            } catch (InputMismatchException e) {

            }
        }
    }

    public void menuModificarDatos() {
        boolean resp = true;
        Scanner entradaScanner = new Scanner(System.in);
        while (resp) {
            System.out.println("MODIFICAR INFORMACION PERSONAL");
            System.out.println();
            System.out.println("1- Modificar contraseña");
            System.out.println("2- Modificar telefono");
            System.out.println("3- Modificar direccion");
            System.out.println("4- Modificar email");
            System.out.println("0- Salir");
            int opc;
            try {
                opc = entradaScanner.nextInt();
                switch (opc) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        System.out.println("MODIFICAR PASS");
                        break;
                    case 2:
                        System.out.println("MODIFICAR TELEFONO");
                        break;
                    case 3:
                        System.out.println("MODIFICAR DIRECCION");
                        break;
                    case 4:
                        System.out.println("MODIFICAR EMAIL");
                        break;
                    default:

                        break;
                }
            } catch (InputMismatchException e) {

            }
        }
    }

    // endregion

}
