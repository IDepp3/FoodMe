package com.utn.teamA.clases;

import com.utn.teamA.ConexionDatos.AccesoClientes;
import com.utn.teamA.ConexionDatos.AccesoEmpleados;
import com.utn.teamA.ConexionDatos.AccesoReservas;
import com.utn.teamA.Excepciones.FechaInvalidaException;
import com.utn.teamA.utils.Color;
import com.utn.teamA.utils.Helpers;
import com.utn.teamA.utils.Vista;
import org.jetbrains.annotations.NotNull;

import java.nio.channels.ClosedChannelException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    private List<Usuario> listaUsuarios; //ToDo ver como ingresar con archivos una lista de usuarios
    private List<Cliente> listaClientes;
    private List<Reserva> listaReservas = new ArrayList<>();
    private List<Menu> listaMenus;
    private List<Empleado> listaEmpleados;

    // private List<Venta>listaHistorialVentas;

    private Cliente cliente;
    private final Empleado empleado;
    private Reserva reserva;

    private AccesoClientes accesoClientes;
    private AccesoEmpleados accesoEmpleados;
    private AccesoReservas accesoReservas;

    // region Constructor

    /**
     * Constructor de la clase vacio
     */
    public Empresa() {
        this.cliente = null;
        this.empleado = null;
        this.reserva = null;

        this.accesoClientes = new AccesoClientes();
        this.accesoEmpleados = new AccesoEmpleados();
        this.accesoReservas = new AccesoReservas();

        this.listaEmpleados = this.accesoEmpleados.obtenerRegistros();
        this.listaClientes = this.accesoClientes.obtenerRegistros();
        this.listaReservas = this.accesoReservas.obtenerRegistros();

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
        listaUsuarios = new ArrayList<>();
        listaClientes = new ArrayList<>();
        listaReservas = new ArrayList<>();
        listaEmpleados = new ArrayList<>();
        listaMenus = new ArrayList<Menu>();

        this.cliente = null;
        this.accesoClientes = new AccesoClientes();
        this.listaClientes = this.accesoClientes.obtenerRegistros();

        this.empleado = null;
        this.accesoEmpleados = new AccesoEmpleados();
        this.listaEmpleados = this.accesoEmpleados.obtenerRegistros();

        this.reserva = null;
        this.accesoReservas = new AccesoReservas();
        this.listaReservas = this.accesoReservas.obtenerRegistros();
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
                   List<Usuario> listaUsuarios, List<Cliente> listaClientes, List<Reserva> listaReservas, List<Menu> listaMenus,
                   List<Empleado> listaEmpleados) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.CUIT = CUIT;
        this.nacimiento = nacimiento;
        this.localidad = localidad;
        this.listaUsuarios = listaUsuarios;
        this.listaClientes = listaClientes;
        this.listaReservas = listaReservas;
        this.listaMenus = listaMenus;
        this.listaEmpleados = listaEmpleados;

        this.cliente = null;
        this.accesoClientes = new AccesoClientes();
        this.listaClientes = this.accesoClientes.obtenerRegistros();

        this.empleado = null;
        this.accesoEmpleados = new AccesoEmpleados();
        this.listaEmpleados = this.accesoEmpleados.obtenerRegistros();

        this.reserva = null;
        this.accesoReservas = new AccesoReservas();
        this.listaReservas = this.accesoReservas.obtenerRegistros();
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return @String
     */
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getLocalidad() {
        return localidad;
    }

    // endregion

    // region Setters

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public List<Menu> getListaMenus() {
        return listaMenus;
    }

    public void setListaMenus(List<Menu> listaMenus) {
        this.listaMenus = listaMenus;
    }

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void setAccesoClientes(AccesoClientes accesoClientes) {
        this.accesoClientes = accesoClientes;
    }

    public void setAccesoEmpleados(AccesoEmpleados accesoEmpleados) {
        this.accesoEmpleados = accesoEmpleados;
    }

    public void setAccesoReservas(AccesoReservas accesoReservas) {
        this.accesoReservas = accesoReservas;
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
        System.out.println(this);
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
        boolean resp = true;
        try {
            while (resp) {
                Vista.titulo("FOOD ME");
                Vista.menuPrincipalFoodMe();
                int opcion = 0;
                opcion = entradaEscaner.nextInt();
                switch (opcion) {
                    case 1:
                        getMenuAdministrador();
                        break;
                    case 2:
                        this.accesoClientes.agregarRegistro(new Cliente("Horacio", "Guarani"));
                        this.listaClientes = this.accesoClientes.obtenerRegistros();
                        this.cliente = this.listaClientes.get(0);
                        if (this.cliente != null) {
                            getMenuCliente();
                        } else
                            System.out.println("El cliente no existe");
                        break;
                    case 0:
                        // guardar datos en archivos JSON?
                        System.out.println("Gracias por utilizar el sistema.\n Que tenga un buen dia!!!");
                        resp = false;
                        break;
                    default:
                        System.out.println("Numero incorrecto. Reintente");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Ingreso un tipo de dato incorrecto. Solo Numeros");
            iniciarSistema();

        } catch (Exception e) {
            System.out.println("Ingreso un tipo de dato incorrecto. Solo Numeros");
            iniciarSistema();
        }
    }
    // endregion

    //region Menu Administrador
    // TODO crear vistas del administrador A trabajar: Marco
    // TODO administrar empleados A trabajar: Antonela

    private void getMenuAdministrador() {

        Scanner entradaEscanner = new Scanner(System.in);
        boolean resp = true;
        int seleccion;

        try {
            while (resp) {

                Vista.titulo("MENU ADMINISTRADOR");
                //Vista.menuAdministrador();

                seleccion = entradaEscanner.nextInt();

                switch (seleccion) {

                    case 0:
                        resp = false;
                        break;
                    case 1:

                        getMenuGestionPersonal();
                        break;
                    case 2:
                        Vista.titulo("GESTION DE RESERVAS");
                        getMenuGestionReservas();
                        break;
                    case 3:
                        Vista.titulo("GESTION DE VENTAS");
                        getMenuGestionVentas();
                        break;
                    case 4:
                        Vista.titulo("GESTION DE STOCK");
                        getMenuGestionStock();
                        break;
                    default:
                        System.out.println("Dato incorrecto. Reintente");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Ingreso un tipo de dato incorrecto. Solo Numeros");
            getMenuAdministrador();
        } catch (Exception e) {
            System.out.println("Ingreso un tipo de dato incorrecto. Solo Numeros");
            getMenuAdministrador();
        }
    }

    //region Gestion de Personal
    private void getMenuGestionPersonal() {
        Scanner entradaEscanner = new Scanner(System.in);
        boolean resp = true;
        Empleado f = null;
        int op = 0;
        int opcion = 0;
        try {
            while (resp) {
                System.out.println("MENU GESTION DE PERSONAL");
                System.out.println();
                System.out.println("1- Dar de alta un empleado");
                System.out.println("2- Dar de baja un empleado");
                System.out.println("3- Buscar un empleado");
                System.out.println("0- Salir");
                int seleccion;
                seleccion = entradaEscanner.nextInt();
                switch (seleccion) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        darAltaUnEmpleado();
                        break;
                    case 2:
                        System.out.println("ACA DAMOS DE BAJA UN EMPLEADO.");
                        break;
                    case 3:
                        buscarEmpleado();
                        break;
                    default:
                        System.out.println("Ingreso un dato incorrecto. reintente.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Dato incorrecto");
            getMenuGestionPersonal();
        } catch (Exception e) {
            getMenuGestionPersonal();
        }
    }

    // region ABM Personal
    public void darAltaUnEmpleado() {
        Scanner entradaEscanner = new Scanner(System.in);
        Empleado empleado = null;
        TipoEmpleado tipo = null;
        double sueldo = 0;
        System.out.println("DAR ALTA EMPLEADO");
        System.out.println();
        System.out.print("\nIngrese el nombre del empleado: ");
        String nombre = entradaEscanner.next();
        System.out.print("\nIngrese el apellido del empleado: ");
        String apellido = entradaEscanner.next();
        System.out.print("\nIngrese el nacimiento del empleado: dd/MM/yyyy ");
        int dia, mes, anio;
        LocalDate fecha = null;


        System.out.println("Ingrese el dia: ");
        dia = entradaEscanner.nextInt();
        System.out.println("Ingrese el mes: ");
        mes = entradaEscanner.nextInt();
        System.out.println("Ingrese el año");
        anio = entradaEscanner.nextInt();
        fecha = LocalDate.of(anio, mes, dia);


        String telefono = "";

        boolean respuesta = false;
        while (respuesta == false) {

            System.out.print("\nIngrese numero de celular sin 0 ni 15");
            telefono = entradaEscanner.next();
            // Validamos el dni que nos da el cliente.
            respuesta = Helpers.validarTel(telefono);

        }

        String dni = "";

        System.out.print("\nIngrese la direccion: ");
        direccion = entradaEscanner.next();
        entradaEscanner.next();
        boolean respuest = false;
        System.out.print("\nIngrese dni del empleado: ");
        dni = entradaEscanner.next();

        // Validamos el dni que nos da el cliente.
        respuest = Helpers.validarDni(dni);

        String email = "";
        boolean estado = true;
        boolean respu = true;
        while (respu == true) {
            // Validamos el email que nos da el cliente.
            System.out.println("\nIngrese el email del empleado: ");
            email = entradaEscanner.next();


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

            System.out.println("Ingrese sueldo del empleado: ");

            sueldo = entradaEscanner.nextDouble();

            respu = false;
        }
        empleado = new Empleado(nombre, apellido, fecha, telefono, direccion, dni, email, tipo, sueldo, estado);
        System.out.println("Se agrego exitosamente el empleado");
        accesoEmpleados.agregarRegistro(empleado);

    }

    public void darDeBaja() {
        System.out.println("DAMOS DE BAJA UN EMPLEADO.");
        Empleado h = new Empleado("Marcos", "Solari");
        boolean a = accesoEmpleados.borrarRegistro(h);
        if (a == true) {
            h.setEstado(false);
            h.toString();
        } else {
            System.out.println("El empleado no ha podido darse de baja.");
        }
    }

    public void buscarEmpleado() {

        Scanner escanner = new Scanner(System.in);
        System.out.println("\nACA BUSCAMOS UN EMPLEADO.");
        System.out.println("Ingrese el dni del empleado a buscar: ");
        String dni = "";
        dni = escanner.next();
        Empleado g = new Empleado();
        Empleado e = new Empleado();
        if (g.getDni().equals(dni)) {
            g = accesoEmpleados.obtenerRegistro(g);
            System.out.println("Cliente encontrado");
            System.out.println(g);
        } else {
            System.out.println("El dni no existe.");
        }
    }

    public void listarEmpleados() {
        System.out.println("\nACA LISTAMOS LOS EMPLEADOS");
        List<Empleado> listaEmpleado = null;
        listaEmpleado = accesoEmpleados.obtenerRegistros();
        System.out.println(listaEmpleado);
    }

    //endregion

    //endregion

    //region Reservas

    private void getMenuGestionReservas() {

        Scanner entradaEscanner = new Scanner(System.in);
        boolean resp = true;


        while (resp) {

            Vista.menuGestionReserva();

            int seleccion;


            try {
                seleccion = entradaEscanner.nextInt();
                switch (seleccion) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        Vista.titulo(" ALTA UNA RESERVA.");
                        dardeAltaUnaReserva();
                        break;
                    case 2:
                        Vista.titulo(" BAJA UNA RESERVA.");
                        listarReservas();
                        darBajaReservas();
                        break;
                    case 3:
                        Vista.titulo(" BUSCAR UNA RESERVA");
                        listarReservas();
                        buscarUnaReserva();
                        break;
                    case 4:
                        Vista.titulo("MODIFICAR UNA RESERVA");
                        modificarUnaReserva(reserva);
                        break;
                    case 5:
                        Vista.titulo("LISTAR RESERVAS");
                        listarReservas();
                        break;
                    default:


                }
            } catch (InputMismatchException e) {
                getMenuGestionReservas();
            } catch (Exception e) {
                getMenuGestionReservas();
            }
        }
    }

    //region ABM

    //region Alta
    public Reserva dardeAltaUnaReserva()  {

        Scanner entradaEscanner2 = new Scanner(System.in);
        int ope = 1;
        String seguir = "s";
        LocalDate fecha;
        Hora hora = new Hora();
        StringBuilder horarioLlegada = null;
        StringBuilder horarioInicio = null;
        StringBuilder horarioFinaliza =null;
        List<Menu> menus;
        String descripcion;
        boolean quierebartender;
        Cliente cliente = new Cliente();
        String idCliente = null;
        String otro = "";
        try {
            while (seguir.equals("s")) {



                //Usuario ingresa fecha, valida que sea 48hs posterior al dia actual
                fecha = elegirFechaDeEvento();
                Vista.deseaSeguirCargandoDatos();
                seguir = entradaEscanner2.nextLine();
                if (seguir.equals("n")) break;



                //Usuario ingresa la hora y minutos en el que empieza el evento.
                //calcula horarios de  llegada y finalizacion
                System.out.println(Color.ANSI_BLUE + " 1 " + Color.ANSI_RESET + "Ingrese hora de inicio del Evento");
                String aviso = """
                           Acordate que nuestro servivio duraentre:  3.5-4 hs
                           Llegamos entre: 3-4 hs antes
                           Finalizamos: 3-4 hs despues 
                                                      
                                                      FOODME.CO
                    """ ;
                System.out.println(aviso);
                hora.init();
                horarioLlegada= hora.calcularLlegada(3);
                horarioInicio = hora.setearHoraInicio();
                horarioFinaliza = hora.calcularFinalizacion(4); //todo constante de horas de servicio

                        
                //Usuario ingrsa Cliente/ lo dirige al menu cliente en donde puede buscar
                //al cliente o darlo de alta. se guarda el id del cliente
                System.out.println(Color.ANSI_BLUE + " 2 " + Color.ANSI_RESET + "Seleccione el Cliente ");
                idCliente = resrevaIngresarCliente();
                Vista.deseaSeguirCargandoDatos();
                seguir = entradaEscanner2.nextLine();
                if (seguir.equals("n")) break;

                //Usuario selecciona  Los tipo de Menu, cantidad de personas por menu e ingredientes
                System.out.println(Color.ANSI_BLUE + " 3 " + Color.ANSI_RESET + "Seleccione los Menus ");
                //traer lista de menus y sus ingredientes
                menus = seleccionarMenus();
                Vista.deseaSeguirCargandoDatos();
                seguir = entradaEscanner2.nextLine();
                if (seguir.equals("n")) break;

                //Usuario ingresa descripcion en la reserva. detalles preguntas de servicio etc.
                System.out.println(Color.ANSI_BLUE + " 4- " + Color.ANSI_RESET + "Ingrese descripcion");
                descripcion = entradaEscanner2.nextLine();
                if (seguir.equals("n")) break;
                Vista.deseaSeguirCargandoDatos();
                seguir = entradaEscanner2.nextLine();
                if (seguir.equals("n")) break;

                //Usuario Ingresa si quiere bartender como servicio
                System.out.println(Color.ANSI_BLUE + " 5- " + Color.ANSI_RESET + "Quiere Bartender?s/n");
                String op = entradaEscanner2.nextLine();
                quierebartender = op.equals("s");

                Vista.opcionCorrecta("Finalizo cargar su reserva");
                Vista.finalizarReserva();
                seguir = entradaEscanner2.nextLine();
                if (seguir.equals("n")) break;

                //El sistema inicializa el objeto y guarda en el archivo el json
                Reserva reserva = new Reserva(fecha, horarioLlegada,horarioInicio,horarioFinaliza ,idCliente, menus, descripcion, quierebartender);
                accesoReservas.mostrar(reserva);
                boolean a = accesoReservas.agregarRegistro(reserva);
                Vista.opcionCorrecta("La reserva se cargo con exito");
                seguir = "n";
            }

        }catch (InputMismatchException e){

        }catch(Exception e){

        }

        return reserva;

    }

    private String resrevaIngresarCliente(){
        Scanner entradaEscanner2 = new Scanner(System.in);
        String idCliente = null;
        try {

            boolean resp = true;
            int opt = 0;
            while (resp) {
                Vista.menuDarAltaReservaIngreseCliente();
                opt = entradaEscanner2.nextInt();

                switch (opt) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        //buscar cleinte

                        //cliente = darAltaCliente();
                        idCliente = cliente.getId();
                        break;
                    case 2:
                        //idCliente= buscarCliente(String dni).getDNI();
                        break;
                    default:
                        System.err.println("Dato incorrecto. Reintente");
                        break;
                }
            }

        } catch (InputMismatchException e) {

        } catch (Exception e) {

        }
        return idCliente;
    }

    private LocalDate elegirFechaDeEvento() {
        LocalDate fechaTentativa = null;
        LocalDate fecha = null;
        Scanner entradaEscanner = new Scanner(System.in);
        String f = "";
        String si = "s";
        while (si.equals("s")) {
            try {

                System.out.println(Color.ANSI_BLUE + " 1- " + Color.ANSI_RESET+ "Ingrese fecha del evento: dd/MM/yyyy");
                f = entradaEscanner.next();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                fechaTentativa = LocalDate.parse(f, formatter);
                boolean fechaV = verificarFechaValida(fechaTentativa);
                boolean fechaD = accesoReservas.verificarFechaDeEventoDisponible(fechaTentativa);
                if (fechaV && fechaD) {
                    Vista.opcionCorrecta("Fecha disponible");
                    fecha = fechaTentativa;
                } else {
                    System.err.println("Fecha No Disponible");

                }

            } catch (FechaInvalidaException e) {
                System.err.println(e.getMessage());
            }
            Vista.deseaSeguirCargandoFechas();
            si = entradaEscanner.next();
        }
        return fecha;

    }

    public boolean verificarFechaValida(LocalDate fechaVali) throws FechaInvalidaException {

        boolean fechaValida = false;
        if ((fechaVali.isAfter(LocalDate.now().plusDays(2)))) {
            fechaValida = true;
        } else {
            throw new FechaInvalidaException("La fecha es invalida") {
            };
        }
        return fechaValida;
    }

    public List<Menu> seleccionarMenus() {

        Scanner entrada = new Scanner(System.in);
        int op = 0;
        boolean resp = true;
        List<Menu> menus = new ArrayList<>();


        try {


            while (resp) {


                System.out.println("SELECCIONAR MENU");
                Vista.darAltaReservaSeleccionarMenu();
                op = entrada.nextInt();


                switch (op) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        Vista.titulo("CLASICO");
                        Menu a = new Menu();
                        menus.add(modificarMenu(a));
                        break;
                    case 2:
                        Vista.titulo("VEGANO");
                        Menu b = new Menu();
                        menus.add(modificarMenu(b));
                        break;
                    case 3:
                        Vista.titulo("VEGETARIANO");
                        Menu c = new Menu();
                        menus.add(modificarMenu(c));
                        break;
                    case 4:
                        Vista.titulo("DIABETICO");
                        Menu d = new Menu();
                        menus.add(modificarMenu(d));
                        break;
                    default:
                        System.err.println("Dato Incorrecto. Reintente.");
                }
            }
        } catch (InputMismatchException e) {
            seleccionarMenus();
        } catch (Exception e) {
            seleccionarMenus();
        }

        return menus;
    }

    public Menu modificarMenu(Menu menu) {

        boolean resp = true;
        Scanner entrada = new Scanner(System.in);
        int op = 0;

        try {

            while (resp) {


                Vista.sleccionarMenuAltaReserva();
                //trear ingredientes Todo trear Ingredientes al cargar una reserva
                op = entrada.nextInt();

                switch (op) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        System.out.println(Color.ANSI_BLUE + " 1- " + Color.ANSI_RESET + "Ingrese cantidad de Personas");
                        int cantidadPer = entrada.nextInt();
                        menu.setCantReservas(cantidadPer);
                        System.out.println("Cantidad = " + menu.getCantReservas());
                        break;
                    case 2:
                        System.out.println(Color.ANSI_BLUE + " 2- " + Color.ANSI_RESET + "Eliminar ingrediente");
                        break;
                    case 3:
                        System.out.println(Color.ANSI_BLUE + " 3- " + Color.ANSI_RESET + "Modificar algun ingrediente del menu");
                        break;
                    default:
                }

            }
        } catch (InputMismatchException e) {
            seleccionarMenus();
        } catch (Exception e) {
            seleccionarMenus();
        } finally {
            return menu;
        }

    }


    //endregion

    //region Baja

    public void darBajaReservas() {
        List<Reserva> reservasCliente = new ArrayList<>();
        Reserva reserva = new Reserva();
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        boolean resp = true;
        try {

            while (resp == true) {

                Vista.darBajaReservas();
                op = scanner.nextInt();

                switch (op) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        System.out.println(Color.ANSI_BLUE + " 1- " + Color.ANSI_RESET + "ID");
                        String idReserva = scanner.next();
                        darBajaUnareserva(idReserva);
                        reserva.mostrar();
                        break;
                    case 2:
                        System.out.println(Color.ANSI_BLUE + " 2 " + Color.ANSI_RESET + "FECHA dd/MM/yyyy");
                        String fecha = scanner.next();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate fechaLD = LocalDate.parse(fecha, formatter);
                        reserva = darBajaUnareserva(fechaLD);
                        reserva.mostrar();
                        break;
                    case 3:
                        System.out.println(Color.ANSI_BLUE + " 3 " + Color.ANSI_RESET + "CLIENTE");
                        Cliente cliente = null;//busCarCliente() //todo DNI,ID,Apellido, etc.
                        reservasCliente = //buscarReservasPorCliente(cliente);
                                reservasCliente = darBajaTodasReservas(cliente);
                        mostrarListaReservasPorCliente(reservasCliente); //todo Crear una clase para las listas.
                        break;
                    default:
                        System.err.println("Ingreso un dato incorrecto. Reintente");

                }
            }
        } catch (NullPointerException e) {
            System.err.println("Error");
            buscarUnaReserva();

        } catch (InputMismatchException e) {
            System.err.println("Error");
            buscarUnaReserva();

        } catch (Exception e) {
            System.err.println("Error");
            buscarUnaReserva();

        }

    }

    public Reserva darBajaUnareserva(Reserva reserva) {

        if (reserva == null) {
            System.err.println("No selecciono ninguna reserva. La puede buscar");
        } else {

            try {
                accesoReservas.borrarRegistro(reserva);

            } catch (Exception e) {

            }
            reserva.mostrar();
        }

        return reserva;
    }

    public Reserva darBajaUnareserva(String idReserva) {

        if (reserva == null) {
            System.err.println("La reserva no existe");
        } else {

            try {
                accesoReservas.borrarRegistro(idReserva);

            } catch (Exception e) {

            }
        }

        return reserva;
    }

    public Reserva darBajaUnareserva(LocalDate fechaReserva) {

        if (reserva == null) {
            System.err.println("La reserva no existe");
        } else {

            try {
                accesoReservas.borrarRegistro(fechaReserva);

            } catch (Exception e) {

            }
        }

        return reserva;
    }

    public List<Reserva> darBajaTodasReservas(Cliente idCliente) {

        List<Reserva> reservas = new ArrayList<>();
        if (reserva == null) {
            System.err.println("La reserva no existe");
        } else {

            try {
                reservas = accesoReservas.borrarRegistro(idCliente);

            } catch (Exception e) {

            }
        }

        return reservas;
    }

    //endregion

    //region Modificar
    public void modificarUnaReserva(Reserva reserva) {
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        boolean resp = true;
        try {

            while (resp == true) {


                Vista.modificarReserva();

                op = scanner.nextInt();

                switch (op) {
                    case 0:
                        resp = false;
                    case 1:
                        System.out.println("Modificar Fecha Evento");
                        String fecha = scanner.next();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate fechaLD = LocalDate.parse(fecha, formatter);
                        reserva.setFechaEvento(fechaLD);
                        break;
                    case 2:
                        System.out.println("Modificar Menu");
                        //Cambiar Tipo de Menu
                        //Cambiar Cantidad de Personas en el Menu
                        //Cambiar Platos de un Menu
                        //Cambiar ingrediente de un plato de un Menu
                        break;
                    case 3:
                        System.out.println("Modificar descripcion");
                        break;
                    default:
                        System.out.println("Ingreso dato incorrecto. Reintente");

                }
            }
        } catch (NullPointerException e) {
            System.out.println("vacio");
            buscarUnaReserva();

        } catch (InputMismatchException e) {
            System.out.println("Error");
            buscarUnaReserva();

        } catch (Exception e) {
            System.out.println("Error");
            buscarUnaReserva();

        }

    }
    //endregion

    //region Buscar
    public void buscarUnaReserva() {
        List<Reserva> reservasCliente = new ArrayList<>();
        Reserva reserva = new Reserva();
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        boolean resp = true;
        try {

            while (resp == true) {
                System.out.println("BUSCAR UNA RESERVA");
                System.out.println("1- Id");
                System.out.println("2. Fecha");
                System.out.println("3- Cliente");
                System.out.println("0- Salir");
                op = scanner.nextInt();
                switch (op) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        System.out.println("ID");
                        String idReserva = scanner.next();
                        reserva = buscarUnaReserva(idReserva);
                        reserva.mostrar();
                        break;
                    case 2:
                        System.out.println("FECHA dd/MM/yyyy");
                        String fecha = scanner.next();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate fechaLD = LocalDate.parse(fecha, formatter);
                        reserva = buscarUnaReserva(fechaLD);
                        reserva.mostrar();
                        break;
                    case 3:
                        System.out.println("Cliente");
                        reservasCliente = buscarReservasPorCliente(scanner.next());
                        mostrarListaReservasPorCliente(reservasCliente); //todo Crear una clase para las listas.
                        break;
                    default:
                        System.out.println("Ingreso un dato incorrecto. Reintente");

                }
            }
        } catch (NullPointerException e) {
            System.out.println("vacio");
            buscarUnaReserva();

        } catch (InputMismatchException e) {
            System.out.println("Error");
            buscarUnaReserva();

        } catch (Exception e) {
            System.out.println("Error");
            buscarUnaReserva();

        }


    }

    public Reserva buscarUnaReserva(String id) {
        Reserva reserva = null;
        try {

            reserva = accesoReservas.obtenerRegistro(id);

        } catch (Exception e) {

        }
        if (reserva == null) {
            System.out.println("Acordarme de hacer una excepacion personalizada");
        }
        return reserva;
    }

    public Reserva buscarUnaReserva(LocalDate fechaLD) {
        Reserva reserva = null;
        try {

            reserva = accesoReservas.obtenerRegistro(fechaLD);

        } catch (Exception e) {

        }
        if (reserva == null) {
            System.out.println("Acordarme de hacer una excepacion personalizada");
        }
        return reserva;
    }

    public List<Reserva> buscarReservasPorCliente(String id) {
        List<Reserva> reservasCliente = new ArrayList<>();
        try {
            Cliente clienteObj = accesoClientes.obtenerRegistro(id);
            reservasCliente = accesoReservas.obtenerRegistro(clienteObj);

        } catch (Exception e) {

        }
        if (reserva == null) {
            System.out.println("Acordarme de hacer una excepacion personalizada");
        }
        return reservasCliente;
    }
    //endregion

    //region Listar

    public void listarReservas() {

        List<Reserva> reservas = accesoReservas.obtenerRegistros();
        boolean resp = false;
        int i = 0;

        if (reservas == null || reservas.isEmpty()) {
            System.err.println("Aun no hay ningun registro de Reservas");
        } else {
            for (Reserva x: reservas) {
                if(x!=null){
                    x.mostrar();

                }
            }
        }
    }

    public void mostrarListaReservasPorCliente(List<Reserva> reservas) {
        if (!reservas.isEmpty()) {
            for (Reserva x : reservas) {
                if (x != null) {
                    x.mostrar();
                } else {
                    System.out.println("No hay reservas");
                }
            }
        }
    }

    //endlista






    //endregion

    //endregion

    //endregion

    //region Ventas
    private void getMenuGestionVentas() {
        Scanner entradaEscanner = new Scanner(System.in);
        boolean resp = true;

        while (resp) {


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
                        //verHistorialCompras();
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
                        /*String telefono = control(ingresaString());
                        this.cliente.setTelefono(telefono);
                        this.accesoClientes.actualizarRegistro(this.cliente);
                        */
                        //Todo Joaco tira eror la funcion
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
            this.listaClientes = accesoClientes.obtenerRegistros();
        }
    }


    // endregion


}
