package com.utn.teamA.clases;

import java.beans.Beans;
import java.text.BreakIterator;
import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.utn.teamA.ConexionDatos.AccesoClientes;
import com.utn.teamA.ConexionDatos.AccesoReservas;

import javax.swing.*;

/**
 *
 *
 * Clase Empresa
 */

public class Empresa {

    private String nombre;
    private String direccion;
    private String CUIT;
    private LocalDate nacimiento;
    private String localidad;

    private List<Usuario> listaUsuarios;
    private List<Reserva> listaReservas = new ArrayList<>();
    private List<Menu> listaMenus;
    private List<Empleado> listaEmpleados;
    private List<Cliente> clientes;
    // private List<Venta>listaHistorialVentas;

    private Cliente cliente;

    private AccesoClientes accesoClientes;

    private Scanner scanner;
    private AccesoReservas accesoReservas;

    // region Constructor

    /**
     * Constructor de la clase vacio
     */
    public Empresa() {
        this.cliente = null;
        this.accesoClientes = new AccesoClientes();
        this.clientes = this.accesoClientes.obtenerRegistros();
        this.scanner = new Scanner(System.in);

        this.accesoReservas = new AccesoReservas();
        accesoReservas.obtenerRegistros();

    }

    /**
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

        this.cliente = null;
        this.accesoClientes = new AccesoClientes();
        this.clientes = this.accesoClientes.obtenerRegistros();
    }

    /**
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

        this.cliente = null;
        this.accesoClientes = new AccesoClientes();
        this.clientes = this.accesoClientes.obtenerRegistros();
    }
    // endregion

    // region Getters

    /**
     * Getter del String Nombre
     *
     * @return @String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return @String
     */
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

    // region Menu Principal

    /**
     * iniciarSistema() Deberia cargar los archivos en los listas y mediante un menu
     * se puede accder al menu del administrador o al del cliente cuando elije la
     * opcion Salir se deberia persistir en archivo todo lo trabajado
     */
    public void iniciarSistema() {


        @SuppressWarnings("resource") // el scanner no se cerro close.
        Scanner entradaEscaner = new Scanner(System.in);
        String seguir = "si";
        try {
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
                        this.cliente = new Cliente("Joaquin", "Alvarez");
                        this.cliente = this.accesoClientes.obtenerRegistro(this.cliente);
                        if (this.cliente != null) {
                            getMenuCliente();
                        } else
                            System.out.println("El cliente no existe");
                        break;
                    case 0:
                        // guardar datos en archivos JSON?
                        System.out.println("Gracias por utilizar el sistema.\n Que tenga un buen dia!!!");
                        seguir = "no";
                        break;
                    default:
                        System.out.println("Numero incorrecto. Reintente");
                }
            }
        } catch(InputMismatchException e){
            System.out.println("Ingreso un tipo de dato incorrecto. Solo Numeros");
            iniciarSistema();

        }catch (Exception e) {
            System.out.println("Ingreso un tipo de dato incorrecto. Solo Numeros");
            iniciarSistema();
        }
    }
    // endregion

    // region Menu Administrador
    // TODO crear vistas del administrador A trabajar: Marco
    // TODO administrar empleados A trabajar: Antonela


    private void getMenuAdministrador() {

        Scanner entradaEscanner = new Scanner(System.in);
        boolean resp= true;
        int seleccion;

        try {
            while (resp) {

                System.out.println("MENU ADMINISTRADOR");
                System.out.println("");
                System.out.println("1- Gestion de Personal");
                System.out.println("2- Gestion de Reservas");
                System.out.println("3- Gestion de Ventas");
                System.out.println("4- Gestion de Stock");
                System.out.println("0- Salir");

                seleccion = entradaEscanner.nextInt();

                switch (seleccion) {

                    case 0:
                        resp= false;
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
                        System.out.println("Dato incorrecto. Reintente");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Ingreso un tipo de dato incorrecto. Solo Numeros");
            getMenuAdministrador();
        }catch (Exception e){
            System.out.println("Ingreso un tipo de dato incorrecto. Solo Numeros");
            getMenuAdministrador();
        }
    }

    //region Gestion de Personal
    private void getMenuGestionPersonal() {
        Scanner entradaEscanner = new Scanner(System.in);
        String resp = new String("si");
        Empleado f = null;
        int op = 0;
        try {
            while (resp.equals("si")) {
                System.out.println("MENU GESTION DE PERSONAL");
                System.out.println("");
                System.out.println("1- Dar de alta un empleado");
                System.out.println("2- Dar de baja un empleado");
                System.out.println("3- Buscar un empleado");
                System.out.println("0- Salir");
                int seleccion;
                seleccion = entradaEscanner.nextInt();
                switch (seleccion) {
                    case 0:
                        resp = "no";
                        break;
                    case 1:
                        darAltaUnEmpleado();
                        break;
                    case 2:
                        System.out.println("ACA DAMOS DE BAJA UN EMPLEADO.");
                        break;
                    case 3:
                        System.out.println("ACA BUSCAMOS UN EMPLEADO.");
                        break;
                    default:
                        System.out.println("Ingreso un dato incorrecto. reintente.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Dato incorrecto");
            getMenuGestionPersonal();
        }

    }

    // region ABM Personal
    public void darAltaUnEmpleado() {
        Scanner entradaEscanner2 = new Scanner(System.in);
        Empleado empleado = null;
        int ope = 1;
        String nombre = null;
        String apellido = null;
        LocalDate fecha = null;
        String telefono = null;
        String direccion = null;
        String dni = null;
        String email = null;
        TipoEmpleado tipo = null;
        double sueldo = 0;
        String s = new String("s");
        System.out.println("Dar de Alta a un Empleado");
        try {

            while (s.equals("s")) {

                switch (ope) {
                    case 1:
                        System.out.print("\nIngrese el nombre del empleado: ");
                        nombre = entradaEscanner2.next();
                        ope = 1;
                    case 2:
                        System.out.print("\nIngrese el apellido del empleado: ");
                        apellido = entradaEscanner2.next();
                    case 3:
                        System.out.print("\nIngrese el nacimiento del empleado: dd/MM/yyyy");
                        String df = entradaEscanner2.next();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        fecha = LocalDate.parse(df, formatter);

                    case 4:
                        System.out.print("\nIngrese el numero de telefono: ");
                        telefono = entradaEscanner2.next();
                    case 5:
                        System.out.print("\nIngrese la direccion: ");
                        direccion = entradaEscanner2.next();
                        entradaEscanner2.next();
                    case 6:
                        System.out.print("\nIngrese dni del empleado: ");
                        dni = entradaEscanner2.next();
                    case 7:
                        System.out.println("\nIngrese el email del empleado: ");
                        email = entradaEscanner2.next();
                    case 8:
                        System.out.println("\nIngrese tipo del empleado");
                        System.out.println("\n 4 - MOZO | 5 - BARTENDER | 6 - SUSHIMAN");
                        Scanner en = new Scanner(System.in);
                        int op = 0;
                        op = en.nextInt();
                        tipo = null;
                        switch (op) {
                            case 4:
                                tipo = TipoEmpleado.MOZO;
                                break;
                            case 5:
                                tipo = TipoEmpleado.BARTENDER;
                                break;
                            case 6:
                                tipo = TipoEmpleado.SUSHIMAN;
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                        }
                    case 9:
                        System.out.println("Ingrese sueldo del empleado: ");
                        Scanner u = new Scanner(System.in);
                        sueldo = u.nextDouble();
                        System.out.println(sueldo);
                        s = "no";
                    default:
                        System.out.println("Opcion incorrecta");

                }

            }
            empleado = new Empleado(nombre, apellido, fecha, telefono, direccion, dni, email, tipo, sueldo);
            System.out.println("Se agrego exitosamente el empleado");
        } catch (DateTimeException e) {
            System.out.println("Formato incorrecta. Reintente");
            darAltaUnEmpleado();
        } catch (Exception e) {
            System.out.println("Formato incorrecta. Reintente.");
            darAltaUnEmpleado();
        }

    }

    public void darDeBaja() {
    }

    public void buscarEmpleado() {
    }

    //endregion
    //Buscar
    //endregion

    //region Gestion Reservas
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
                        System.out.println(" ALTA UNA RESERVA.");
                        dardeAltaUnaReserva();
                        break;
                    case 2:
                        System.out.println(" BAJA UNA RESERVA.");
                        //darBajaUnareserva();
                        break;
                    case 3:
                        System.out.println(" BUSCAR UNA RESERVA");
                        //buscarUnareserva();
                        break;
                    case 4:
                        System.out.println("MODIFICAR UNA RESERVA");
                        //modificarUnaReserva();
                        break;
                    default:


                }
            } catch (InputMismatchException e) {
                getMenuGestionReservas();
            }
        }
    }


    //region ABM
    public void dardeAltaUnaReserva() {

        Scanner entradaEscanner2 = new Scanner(System.in);
        int ope = 1;
        boolean resp = true;

        LocalDate fecha = null;
        List<Menu> menus = new ArrayList<>();
        String descripcion = new String("");
        boolean quierebartender = false;
        Persona cliente = new Cliente();

        try {
            while (resp) {
                System.out.println("DAR ALTA UNA RESERVA");
                System.out.println("");
                switch (ope) {
                    case 1:
                        System.out.print("1- Ingrese fecha del evento: dd/mm/yyyy ");
                        String f = entradaEscanner2.next();
                        entradaEscanner2.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        fecha = LocalDate.parse(f, formatter);
                    case 2:
                        System.out.print("\nIngrese el Cliente en el sistema: ");
                        System.out.println("");
                        System.out.print("\n1- Buscar Cliente ");
                        System.out.print("\n2- Dar Alta a Cliente ");

                        int opt = 0;
                        switch (opt) {
                            case 1:
                                System.out.println("1- Dar alta Cliente");
                                break;
                            case 2:
                                System.out.println("2- Buscar Cliente");
                                break;
                            default:
                                System.out.println("Dato incorrecto. Reintente");
                                break;
                        }
                    case 3:
                        System.out.print("\n3- Seleccione Menu y cantidad de Personas?");
                        //MOSTRAR MENUS: traer archivo Lista de menus en
                        menus = seleccionarMenus();
                        System.out.println("Menu Seleccionado");
                    case 4:
                        System.out.print("\n4- Ingrese descripcion");
                            descripcion = entradaEscanner2.nextLine();

                    case 5:
                        System.out.print("\n5- Quiere Bartender?s/n");
                        String op = entradaEscanner2.next();
                        if (op.equals("s")) {
                            quierebartender = true;
                        } else {
                            quierebartender = false;
                        }
                        System.out.println("Se ha grabado:" + quierebartender);
                        break;
                    default:
                        System.out.println("Dato incorrecto. Reintente");

                }
                System.out.println("a");
                Reserva reserva = new Reserva(fecha, cliente, menus, descripcion, quierebartender);
                accesoReservas.obtenerRegistro(reserva);


/*
                System.out.println("B");
                reserva.mostrar();
                System.out.println("C");
                boolean a = accesoReservas.agregarRegistro(reserva);
*/
                resp = false;
            }
        } catch (DateTimeException e) {
               System.out.println("Dato incorrecto. Reintente");
               dardeAltaUnaReserva();
        } catch (Exception e) {
               System.out.println("Dato incorrecto. Reintente.");
               dardeAltaUnaReserva();
        }


    }

    public List<Menu> seleccionarMenus() {

        Scanner entrada = new Scanner(System.in);
        int op = 0;
        boolean resp = true;
        List<Menu> menus = new ArrayList<>();


        try {
            while (resp) {
                System.out.println("SELECCIONAR MENU");
                System.out.println("");
                System.out.print("\n 1- Menu Clasico");
                System.out.print("\n 2- Menu vegano");
                System.out.print("\n 3- Menu Vegetariano");
                System.out.print("\n 4- Menu diabetico");
                System.out.print("\n 0- Salir");
                op = entrada.nextInt();

                switch (op) {
                    case 0:
                        System.out.println("0- SALIR");
                        resp = false;
                        break;
                    case 1:
                        System.out.println("1- CLASICO");
                        Menu a = new Menu();
                        menus.add(modificarMenu(a));
                        break;
                    case 2:
                        System.out.println("2- VEGANO");
                        Menu b = new Menu();
                        menus.add(modificarMenu(b));
                        break;
                    case 3:
                        System.out.println("3- VEGETARIANO");
                        Menu c = new Menu();
                        menus.add(modificarMenu(c));
                        break;
                    case 4:
                        System.out.println("4- DIABETICO");
                        Menu d = new Menu();
                        menus.add(modificarMenu(d));
                        break;
                    default:
                        System.out.println("Dato Incorrecto. Reintente.");
                }
            }
        }catch (InputMismatchException e){
            seleccionarMenus();
        }catch (Exception e){
            seleccionarMenus();
        }

        return menus;
    }

    public Menu modificarMenu(Menu menu) {

        boolean resp = true;
        Scanner entrada = new Scanner(System.in);
        int op=0;

        try {

            while (resp) {
                System.out.println("MENU");
                System.out.println("");
                System.out.println("1- Cantidad de Personas");
                System.out.println("2- Modificar Ingredientes");
                System.out.println("3- Eliminar Ingrediente");
                System.out.println("0- Salir");
                //trear ingredientes
                op = entrada.nextInt();
                switch (op) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        System.out.println("3 -Ingrese cantidad de Personas");
                        int cantidadPer = entrada.nextInt();
                        menu.setCantReservas(cantidadPer);
                        System.out.println("Cantidad = " + menu.getCantReservas());
                        break;
                    case 2:
                        System.out.println("2- Eliminar Ingrediente");
                        break;
                    case 3:
                        System.out.print("1- Modificar algun ingrediente del menu? s/n");
                        break;
                    default:
                }

            }
        } catch (InputMismatchException e) {
            seleccionarMenus();
        }catch (Exception e){
            seleccionarMenus();
        }finally {
            return menu;
        }

    }

    //darBajaUnareserva();

    //modificarUnaReserva();



    //endregion
    //endregion

    //region Ventas
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
                getMenuGestionVentas();
            }
        }

    }

    //region Ver Historial
    //endregion
    //region ABM
    //endregion

    //endregion

    //region Stock
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
                getMenuGestionStock();
            }
        }

    }

    //region ABM

    //endregion
    //region Ver Stock
    //endregion

    //endregion

    //endregion

    //region Menu Cliente
    private void getMenuCliente() {
        boolean resp = true;
        Scanner entradaEscaner = new Scanner(System.in);
        while (resp) {
            System.out.println("Bienvenido " + this.cliente.getNombre() + " " + this.cliente.getApellido());
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
                        menuInformacionPersonal();
                        break;
                    default:

                        break;
                }
            } catch (InputMismatchException e) {
                getMenuCliente();
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
                        System.out.println(this.cliente);
                        break;
                    case 2:
                        menuModificarDatos();
                        break;
                    case 3:
                        verHistorialCompras();
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
                menuInformacionPersonal();
            }
        }
    }
    // TODO archivos modificar info personal cliente A Trabajar: Joaquin
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
                        String telefono = control(ingresaString());
                        this.cliente.setTelefono(telefono);
                        this.accesoClientes.actualizarRegistro(this.cliente);
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
                menuModificarDatos();
            }
            this.clientes = accesoClientes.obtenerRegistros();
        }
    }

    private void verHistorialCompras(){
        if(this.cliente.getReservas() == null)
            System.out.println("Todavia no tenes reservas hechas");
        else{
            this.listaReservas = this.cliente.getReservas();
            for(Reserva r : this.listaReservas){
                System.out.println(r);
            }
        }
    }

    // endregion

    // region Control de ingresos por teclado
        private String control(String string){
            boolean resp = true;
            String cadena = string;
            System.out.println("Telefono dentro de control" + cadena);
            while(resp){
                if(cadena.equals("")){
                    cadena = ingresaString();
                }else{
                    resp = false;
                }

            }

            return cadena;
        }
    // endregion

    // region Ingresos por teclado
        private String ingresaString(){
            System.out.print("Ingresa numero de telefono : ");
            String string = this.scanner.next();
            return (string.trim().equals("")) ? "" : string;
        }
    // endregion
}
