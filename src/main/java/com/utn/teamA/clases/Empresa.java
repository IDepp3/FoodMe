package com.utn.teamA.clases;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.utn.teamA.ConexionDatos.AccesoClientes;
import com.utn.teamA.utils.Helpers;
import com.utn.teamA.utils.Vista;

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
    private List<Cliente> clientes;
    // private List<Venta>listaHistorialVentas;

    private Cliente cliente;

    private AccesoClientes accesoClientes;

    // region Constructor

    /**
     * Constructor de la clase vacio
     *
     */
    public Empresa() {
        this.cliente        = null;
        this.accesoClientes = new AccesoClientes();
        this.clientes       = this.accesoClientes.obtenerRegistros();
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
                    this.cliente = this.accesoClientes.obtenerRegistro(new Cliente("Horacio", "Guarani"));
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
    // TODO crear vistas del administrador A trabajar: Marco
    // TODO administrar empleados A trabajar: Antonela

    // region MENU ADMINISTRADOR

    private void getMenuAdministrador() {

        Scanner entradaEscanner = new Scanner(System.in);
        boolean respuesta = true;

        while (respuesta) {
            System.out.println("MENU ADMINISTRADOR");
            System.out.println("");
            System.out.println("1- Gestion de Personal");
            System.out.println("2- Gestion de Reservas");
            System.out.println("3- Gestion de Ventas");
            System.out.println("4- Gestion de Stock");
            System.out.println("0- Salir");
            int seleccion;
            try {
                seleccion = entradaEscanner.nextInt();

                switch (seleccion) {

                    case 0:
                        respuesta = false;
                        break;
                    case 1:
                        System.out.println("GESTION DE PERSONAL");
                        getMenuGestionPersonal();
                        break;
                    case 2:
                        System.out.println("GESTION DE RESERVAS");
                        getMenuGestionReservas();
                        break;
                    case 3:
                        System.out.println("GESTION DE VENTAS");
                        getMenuGestionVentas();
                        break;
                    case 4:
                        System.out.println("GESTION DE STOCK");
                        getMenuGestionStock();
                        break;
                    default:

                        break;
                }

            } catch (InputMismatchException e) {

            }
        }
    }
    // endregion

    /* MENU PARA AÑADIR, ELIMINAR Y BUSCAR UN EMPLEADO. */

    private void getMenuGestionPersonal() {
        Scanner entradaEscanner = new Scanner(System.in);
        boolean resp = true;
        Empleado f = null;
        int opcion = 0;
        int op = 0;

        while (resp) {

            System.out.println("MENU GESTION DE PERSONAL");
            System.out.println("");
            System.out.println("1- Dar de alta un empleado");
            System.out.println("2- Dar de baja un empleado");
            System.out.println("3- Buscar un empleado");
            System.out.println("0- Salir");
            int seleccion;

            try {
                seleccion = entradaEscanner.nextInt();
                switch (seleccion) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        System.out.println("\nIngrese un ID al empleado: ");
                        int id = entradaEscanner.nextInt();
                        System.out.print("\nIngrese el nombre del empleado: ");
                        String nombre = entradaEscanner.next();
                        System.out.print("\nIngrese el apellido del empleado: ");
                        String apellido = entradaEscanner.next();
                        /* System.out.print("\nIngrese el nacimiento del empleado: dd/MM/yyyy ");
                        String fecha = entradaEscanner.next();
                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                        Date testDate = null;
                        String date = fecha;
                        testDate = df.parse(date); */
                        LocalDate fecha = LocalDate.of(1991,12,18);
                        System.out.print("\nIngrese el numero de telefono: ");
                        String telefono = entradaEscanner.next();
                        System.out.print("\nIngrese la direccion: ");
                        String direccion = entradaEscanner.next();
                        entradaEscanner.next();
                        System.out.print("\nIngrese dni del empleado: ");
                        String dni = entradaEscanner.next();
                        System.out.println("\nIngrese el email del empleado: ");
                        String email = entradaEscanner.next();
                        System.out.print("\nIngrese tipo del empleado");
                        System.out.print("\n 4 - MOZO | 5 - BARTENDER | 6 - SUSHIMAN");
                        op = entradaEscanner.nextInt();
                        TipoEmpleado tipo = null;
                        switch (op) {
                            case 4:
                                tipo = TipoEmpleado.MOZO;
                                break;
                            case 5:
                                tipo = TipoEmpleado.BARTENDER;
                                break;
                        }
                        System.out.print("\nIngrese sueldo del empleado: ");
                        int sueldo = entradaEscanner.nextInt();

                        f = new Empleado(nombre, apellido, fecha, telefono, direccion, dni, email,tipo,sueldo);
                        System.out.println(f.toString());
                        break;

                    case 2:
                        System.out.println("ACA DAMOS DE BAJA UN EMPLEADO.");
                        break;
                    case 3:
                        System.out.println("ACA BUSCAMOS UN EMPLEADO.");
                        break;
                    default:

                        break;

                }
            } catch (InputMismatchException e) {

            }
        }

    }

    private void getMenuGestionReservas() {

        Scanner entradaEscanner = new Scanner(System.in);
        boolean resp = true;

        while (resp) {

            System.out.println("MENU GESTION DE RESERVAS");
            System.out.println("");
            System.out.println("1- Dar de alta una reserva");
            System.out.println("2- Dar de baja una reserva");
            System.out.println("3- Buscar una reserva");
            System.out.println("0- Salir");
            int seleccion;

            try {
                seleccion = entradaEscanner.nextInt();
                switch (seleccion) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        System.out.println("ACA DAMOS DE ALTA UNA RESERVA.");
                        break;
                    case 2:
                        System.out.println("ACA DAMOS DE BAJA UNA RESERVA.");
                        break;
                    case 3:
                        System.out.println("ACA BUSCAMOS UNA RESERVA");
                        break;
                    default:
                        System.out.println();
                        break;

                }
            } catch (InputMismatchException e) {

            }
        }

    }

    private void getMenuGestionVentas() {
        Scanner entradaEscanner = new Scanner(System.in);
        boolean resp = true;

        while (resp) {

            System.out.println("MENU GESTION DE VENTAS");
            System.out.println("");
            System.out.println("1- Dar de alta una venta");
            System.out.println("2- Dar de baja una venta");
            System.out.println("3- Buscar una venta");
            System.out.println("0- Salir");
            int seleccion;

            try {
                seleccion = entradaEscanner.nextInt();
                switch (seleccion) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        System.out.println("ACA DAMOS DE ALTA UNA VENTA.");
                        break;
                    case 2:
                        System.out.println("ACA DAMOS DE BAJA UNA VENTA.");
                        break;
                    case 3:
                        System.out.println("ACA BUSCAMOS UNA VENTA.");
                        break;
                    default:

                        break;

                }
            } catch (InputMismatchException e) {

            }
        }

    }

    private void getMenuGestionStock() {
        Scanner entradaEscanner = new Scanner(System.in);
        boolean resp = true;

        while (resp) {

            System.out.println("MENU GESTION DE STOCK");
            System.out.println("");
            System.out.println("1- Dar de alta un articulo");
            System.out.println("2- Dar de baja un articulo");
            System.out.println("3- Buscar un articulo");
            System.out.println("0- Salir");
            int seleccion;

            try {
                seleccion = entradaEscanner.nextInt();
                switch (seleccion) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        System.out.println("ACA DAMOS DE ALTA UN ARTICULO.");
                        break;
                    case 2:
                        System.out.println("ACA DAMOS DE BAJA UN ARTICULO");
                        break;
                    case 3:
                        System.out.println("ACA BUSCAMOS UN ARTICULO");
                        break;
                    default:

                        break;

                }
            } catch (InputMismatchException e) {

            }
        }

    }

    // region MENU CLIENTE

    private void getMenuCliente() {
        boolean resp = true;
        int opcion;
        while (resp) {
            Vista.titulo("Menu Principal");
            Vista.menuPrincipal();
            opcion = Helpers.validarInt();

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
                    menuInformacionPersonal();
                    break;
                default:
                    Vista.opcionIncorrecta(opcion);
                    break;
            }
        }
    }

    private void menuInformacionPersonal() {
        boolean resp = true;
        int opcion;
        while (resp) {
            Vista.titulo("Informacion Personal");
            Vista.informacionPersonal();
            opcion = Helpers.validarInt();

            switch (opcion) {
                case 0:
                    resp = false;
                    break;
                case 1:
                    System.out.println(this.cliente);
                    break;
                case 2:
                    menuModificarDatos();
                    break;
                case 3:
                    //verHistorialCompras();
                    break;
                case 4:
                    System.out.println("LISTA CON COMPRAS PENDIENTES AL DIA DE LA FECHA");
                    System.out.println(
                            "Si es existe algun pedido se le puede dar la opcion que modifique algo de la reserva realizada");
                    break;
                default:
                    Vista.opcionIncorrecta(opcion);
                    break;
            }

        }
    }

    public void menuModificarDatos() {
        boolean resp = true;
        int opcion;
        String aux;
        while (resp) {
            Vista.titulo("Modificar datos");
            Vista.modificarInformacionPersonal();
            opcion = Helpers.validarInt();

            switch (opcion) {
                case 0:
                    resp = false;
                    break;
                case 1:
                    aux = Helpers.nextLine();
                    this.cliente.setPassword(aux);
                    break;
                case 2:
                    break;
                case 3:
                    Vista.titulo("Ingrese fecha formato dd/mm/aaaa");
                    break;
                case 4:
                    Vista.titulo("Ingrese numero de celular sin 0 ni 15");
                    aux = Helpers.validarTelefono();
                    this.cliente.setTelefono(aux);
                    Vista.opcionCorrecta("Telefono modificado correctamente");
                    break;
                default:
                    Vista.opcionIncorrecta(opcion);
                    break;
            }
            this.accesoClientes.actualizarRegistro(this.cliente);
            this.clientes = accesoClientes.obtenerRegistros();
        }
    }

    // endregion

}
