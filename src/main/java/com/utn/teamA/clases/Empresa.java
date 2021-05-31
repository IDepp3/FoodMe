package com.utn.teamA.clases;

import java.time.DateTimeException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.utn.teamA.ConexionDatos.AccesoClientes;

import javax.swing.*;

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

    private Scanner scanner;

    // region Constructor

    /**
     * Constructor de la clase vacio
     *
     */
    public Empresa() {
        this.cliente        = null;
        this.accesoClientes = new AccesoClientes();
        this.clientes       = this.accesoClientes.obtenerRegistros();
        this.scanner        = new Scanner(System.in);
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

        this.cliente        = null;
        this.accesoClientes = new AccesoClientes();
        this.clientes       = this.accesoClientes.obtenerRegistros();
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

        this.cliente        = null;
        this.accesoClientes = new AccesoClientes();
        this.clientes       = this.accesoClientes.obtenerRegistros();
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
        }catch (Exception e){
            System.out.println("Ingreso un tipo de dato incorrecto. Solo Numeros");
            iniciarSistema();
        }
    }
    // endregion

    // region Menu Administrador
    // TODO crear vistas del administrador A trabajar: Marco
    // TODO administrar empleados A trabajar: Antonela

    // region MENU ADMINISTRADOR

    private void getMenuAdministrador() {

        Scanner entradaEscanner = new Scanner(System.in);
        String respuesta = new String("si");
        try{
                while (respuesta.equals("si")) {
                    System.out.println("MENU ADMINISTRADOR");
                    System.out.println("");
                    System.out.println("1- Gestion de Personal");
                    System.out.println("2- Gestion de Reservas");
                    System.out.println("3- Gestion de Ventas");
                    System.out.println("4- Gestion de Stock");
                    System.out.println("0- Salir");
                    int seleccion;

                    seleccion = entradaEscanner.nextInt();

                    switch (seleccion) {

                        case 0:
                            respuesta = "no";
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
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingreso un tipo de dato incorrecto. Solo Numeros");
                getMenuAdministrador();
            }
        }
    // endregion

    /* MENU PARA AÑADIR, ELIMINAR Y BUSCAR UN EMPLEADO. */

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
                            break;
                    }
            }
        }catch(InputMismatchException e){
           System.out.println("Dato incorrecto");
            getMenuGestionPersonal();
        }

    }
    public void darAltaUnEmpleado() {
        Scanner entradaEscanner2 = new Scanner(System.in);
        Empleado empleado = null;
        int ope = 1;
        String nombre = null;
        String apellido = null;
        LocalDate fecha = null;
        String telefono = null; String direccion = null; String dni = null;
        String email=null; TipoEmpleado tipo=null;
        double sueldo = 0;
        String s = new String("s");
        System.out.println("Dar de Alta a un Empleado");
        try {

            while(s.equals("s")) {

                switch (ope) {
                    case 1:
                        System.out.print("\nIngrese el nombre del empleado: ");
                         nombre = entradaEscanner2.next();
                         ope=1;
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
                        break;

                }

            }
            //empleado = new Empleado(nombre, apellido, fecha, telefono, direccion,dni, email,tipo,sueldo);
            System.out.println("Se agrego exitosamente el empleado");
            }catch (DateTimeException e ) {
            System.out.println("Formato incorrecta. ReintenteDATE");
            darAltaUnEmpleado();
            }catch(Exception e ){
                System.out.println("Formato incorrecta. Reintente.EXCE");
                darAltaUnEmpleado();
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
                getMenuGestionVentas();
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
                getMenuGestionStock();
            }
        }

    }

    // region MENU CLIENTE

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

    // endregion

    // region METODOS CLIENTES

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
