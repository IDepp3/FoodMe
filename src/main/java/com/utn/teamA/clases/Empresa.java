package com.utn.teamA.clases;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.utn.teamA.ConexionDatos.AccesoClientes;
import com.utn.teamA.ConexionDatos.AccesoEmpleados;
import com.utn.teamA.ConexionDatos.AccesoReservas;
import com.utn.teamA.utils.Helpers;
import com.utn.teamA.utils.Vista;

/**
 *
 *
 * Clase Empresa
 */

public class Empresa {

    // region ATRIBUTOS

    private String nombre;
    private String direccion;
    private String CUIT;
    private String nacimiento;
    private String localidad;

    private List<Cliente> listaClientes;
    private List<Reserva> listaReservas = new ArrayList<>();
    private List<Menu> listaMenus;
    private List<Empleado> listaEmpleados;

    // private List<Venta>listaHistorialVentas;

    private Cliente cliente;
    private Empleado empleado;
    private Reserva reserva;

    private AccesoClientes accesoClientes;
    private AccesoEmpleados accesoEmpleados;
    private AccesoReservas accesoReservas;

    // endregion 

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

    public Empresa(String elNombre, String laDireccion, String elCUIT, String elNacimiento, String unaLocalidad) {
        nombre = elNombre;
        direccion = laDireccion;
        CUIT = elCUIT;
        nacimiento = elNacimiento;
        localidad = unaLocalidad;
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

    public Empresa(String nombre, String direccion, String CUIT, String nacimiento, String localidad,
            List<Usuario> listaUsuarios, List<Cliente> listaClientes, List<Reserva> listaReservas,
            List<Menu> listaMenus, List<Empleado> listaEmpleados) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.CUIT = CUIT;
        this.nacimiento = nacimiento;
        this.localidad = localidad;
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

    /**
     * @return @String
     */
    public String getDireccion() {
        return direccion;
    }

    public String getCUIT() {
        return CUIT;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public String getLocalidad() {
        return localidad;
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

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
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
                + ", nacimiento=" + nacimiento + ", localidad='" + localidad
                + ", listaReservas=" + listaReservas + ", listaMenus=" + listaMenus + ", listaEmpleados="
                + listaEmpleados + '}';
    }

    public void mostrar() {
        System.out.println(toString());
    }

    // endregion

    // region Menu Principal

    public void iniciarSistema() {
        menuPrincipal();
    }
    // endregion

    // region MENU

    public void menuPrincipal() {
        boolean resp = true;
        int opcion;
        for(Cliente c : this.listaClientes){
            System.out.println(c);
        }
        while (resp) {
            Vista.titulo("Empresa de Catering");
            Vista.menuPrincipal();
            opcion = Helpers.validarInt();
            switch (opcion) {
                case 0:
                    resp = false;
                    break;
                case 1:
                    Vista.titulo("Login");
                    this.cliente = loginUsuario();
                    //this.cliente = this.listaClientes.get(0);
                    if (this.cliente != null)
                        if (this.cliente.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR.tipo))
                            seleccionDeMenu();
                        else if (this.cliente.getTipoUsuario().equals(TipoUsuario.CLIENTE.tipo))
                            getMenuCliente();
                        else
                            Vista.opcionIncorrecta("El usuario o contraseña es incorrecto");
                    break;
                case 2:
                    Vista.titulo("Registrarse");
                    this.cliente = registroUsuario();
                    if (this.accesoClientes.agregarRegistro(this.cliente))
                        Vista.opcionCorrecta("Usuario creado correctamente");
                    else {
                        Vista.opcionIncorrecta("El usuario ya existe intente con otro email u otro nombre de usuario");
                    }
                    break;
                default:
                    Vista.opcionIncorrecta(opcion);
                    break;
            }
            this.cliente = null;
            this.listaClientes = this.accesoClientes.obtenerRegistros();
        }
        System.out.println("Gracias por usar la aplicacion");
    }



    // endregion

    // region LOGIN Y REGISTRO

    private Cliente loginUsuario() {
        Cliente c = new Cliente();
        boolean resp = true;
        int i = 0;

        c.setUsername(Helpers.validaciones("nombre usuario", Helpers.VALIDAR_NOMBRE_USUARIO,
                "Error, comienza con numeros o letras y puede contener (._) minimo 8, maximo 20 caracteres"));
        c.setPassword(Helpers.encriptarPassword(Helpers.ingresoPassword()));

        while (resp && i < this.listaClientes.size()) {
            if (this.listaClientes.get(i).existeCliente(c)) {
                c = this.listaClientes.get(i);
                resp = false;
            }
            i++;
        }
        return c;
    }

    private Cliente registroUsuario() {
        Cliente cliente;
        String nombreUsuario = Helpers.validaciones("nombre usuario", Helpers.VALIDAR_NOMBRE_USUARIO,
                "Error, comienza con numeros o letras y puede contener (._) minimo 8, maximo 20 caracteres");
        String password = passwordIguales();
        String email = Helpers.validaciones("email", Helpers.VALIDAR_EMAIL, "Ingrese email valido");
       // cliente = new Cliente(Helpers.generarID(), nombreUsuario, Helpers.encriptarPassword(password), email,
        //        Helpers.fechaActual(), Helpers.tipoCliente(), Helpers.estadoActivo());
        Cliente cliente2 = new Cliente();
        return cliente2;
    }

    private String passwordIguales() {
        boolean resp = true;
        String pass = "";
        String confirmacion;

        while (resp) {
            pass = Helpers.validarPassword("Ingrese password");
            confirmacion = Helpers.validarPassword("Reingrese password");
            if (pass.equals(confirmacion))
                resp = false;
            else
                Vista.opcionCorrecta("Las contraseñas no coinciden");
        }

        return pass;
    }

    // endregion

    // region Menu Administrador

    private void seleccionDeMenu(){
        boolean resp = true;
        int opcion;
        while(resp){
            Vista.titulo("Seleccion de vistas");
            Vista.seleccionMenuAdmin();
            opcion = Helpers.validarInt();
            switch (opcion) {
                case 0:
                    resp = false;
                    break;
                case 1:
                    getMenuAdministrador();
                    break;
                case 2:
                    getMenuCliente();
                    break;
                default:
                    Vista.opcionIncorrecta(opcion);
                    break;
            }
        }
    }
    private void getMenuAdministrador() {
        boolean resp = true;
        int seleccion;
        while (resp) {
            Vista.titulo("Menu Administrador");
            Vista.menuPrincipalAdministrador();
            seleccion = Helpers.validarInt();
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
                    Vista.titulo("GESTION DE CLIENTES");
                    getMenuGestionVentas();
                    break;
                case 4:
                    Vista.titulo("GESTION DE VENTAS");
                    getMenuGestionClientes();
                    break;
                default:
                    Vista.opcionIncorrecta(seleccion);
            }
        }
    }

    // region Gestion de Personal
    private void getMenuGestionPersonal() {
        boolean resp = true;
        //Empleado f = null;
        int opcion;
        while (resp) {
            Vista.titulo("Gestion del Personal");
            Vista.menuGestionPersonal();
            opcion = Helpers.validarInt();
            switch (opcion) {
                case 0:
                    resp = false;
                    break;
                case 1:
                    darAltaUnEmpleado();
                    break;
                case 2:
                    darDeBaja();
                    break;
                case 3:
                    buscarEmpleado();
                    break;
                case 4:
                    listarEmpleados();
                    break;
                default:
                    Vista.opcionIncorrecta(opcion);
            }
        }
    }

    // region ABM Personal
    public void darAltaUnEmpleado() {
        Scanner entradaEscanner = new Scanner(System.in);
        Empleado empleado = null;
        TipoEmpleado tipo = null;
        double sueldo = 0;
        System.out.println("DAR ALTA EMPLEADO");
        System.out.println("");
        System.out.print("\nIngrese el nombre del empleado: ");
        String nombre = entradaEscanner.next();
        System.out.print("\nIngrese el apellido del empleado: ");
        String apellido = entradaEscanner.next();
        
        // validacion de fecha

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
        String fecha4= null;
        empleado = new Empleado(nombre, apellido, fecha4, telefono, direccion, dni, email, tipo, sueldo, estado);
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

    // endregion

    // endregion

    // region Gestion Reservas
    private void getMenuGestionReservas() {

        Scanner entradaEscanner = new Scanner(System.in);
        boolean resp = true;

        while (resp) {

            System.out.println("1- Dar de alta una reserva");
            System.out.println("2- Dar de baja una reserva");
            System.out.println("3- Buscar una reserva");
            System.out.println("4- Modificar una reserva");
            System.out.println("5- Listar reservas");
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
                        listarReservas();
                        darBajaUnareserva();
                        break;
                    case 3:
                        System.out.println(" BUSCAR UNA RESERVA");
                        // listarReservas();
                        buscarUnaReserva();
                        break;
                    case 4:
                        System.out.println("MODIFICAR UNA RESERVA");
                        listarReservas();
                        modificarUnaReserva();
                        break;
                    case 5:
                        System.out.println("LISTAR RESERVAS");
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

    // region ABM
    public void dardeAltaUnaReserva() {

        Scanner entradaEscanner2 = new Scanner(System.in);
        int ope = 1;
        boolean resp = true;

        LocalDate fecha = null;
        LocalDate fechaTentativa = null;
        List<Menu> menus = new ArrayList<>();
        String descripcion = new String("");
        boolean quierebartender = false;
        Cliente cliente = new Cliente();
        String idCliente = null;

        try {
            while (resp) {
                System.out.println("DAR ALTA UNA RESERVA");
                System.out.println("");
                switch (ope) {
                    case 1:
                        boolean fechaDisponible1 = true;
                        String si = new String("s");
                        while ((si.equals("s"))) {
                            System.out.print("1- Ingrese fecha del evento: dd/mm/yyyy ");
                            String f = entradaEscanner2.next();
                            entradaEscanner2.nextLine();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            fechaTentativa = LocalDate.parse(f, formatter);
                            fechaDisponible1 = verificarFechaDeReservaDisponible(f);
                            if (fechaDisponible1) {
                                System.out.println("Fecha disponible?");
                                fecha = fechaTentativa;
                            } else {
                                System.out.println("Fecha No Disponible");

                            }

                            System.out.println("Dese seguir buscando fechas? s/n");
                            si = entradaEscanner2.next();
                        } // todo Antonela me da error
                    case 2:
                        System.out.print("\nIngrese el Cliente en el sistema: ");
                        System.out.println("");
                        System.out.print("\n1- Buscar Cliente ");
                        System.out.print("\n2- Dar Alta a Cliente ");

                        int opt = 0;
                        switch (opt) {
                            case 1:
                                System.out.println("1- Dar alta Cliente");
                                // cliente = darAltaCliente();
                                idCliente = cliente.getId();
                                break;
                            case 2:
                                System.out.println("2- Buscar Cliente");
                                // idCliente= buscarCliente(String dni).getDNI();
                                break;
                            default:
                                System.out.println("Dato incorrecto. Reintente");
                                break;
                        }
                    case 3:
                        System.out.print("\n3- Seleccione Menu y cantidad de Personas?");
                        // MOSTRAR MENUS: traer archivo Lista de menus en
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
                        break;
                    default:
                        System.out.println("Dato incorrecto. Reintente");

                }

                String fecha5 = null;
                Reserva reserva = new Reserva(fecha5, idCliente, menus, descripcion, quierebartender);

                accesoReservas.mostrar(reserva);
                boolean a = true;
                a = accesoReservas.agregarRegistro(reserva);
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
                System.out.println("MENU");
                System.out.println("");
                System.out.println("1- Cantidad de Personas");
                System.out.println("2- Modificar Ingredientes");
                System.out.println("3- Eliminar Ingrediente");
                System.out.println("0- Salir");
                // trear ingredientes
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
        } catch (Exception e) {
            seleccionarMenus();
        } finally {
            return menu;
        }

    }

    public void darBajaUnareserva() { // TODo
        System.out.println("DAR DE BAJA UNA RESERVA");
        System.out.println("Ingrese Id, fecha u Cliente");

    }

    public Reserva buscarUnaReserva() {

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
                    case 1:
                        System.out.println("ID");
                        reserva = buscarUnaReservaPorID(scanner.next());
                        break;
                    case 2:
                        System.out.println("FECHA dd/MM/yyyy");
                        reserva = buscarUnaReservaPorID(scanner.next());
                        reserva.mostrar();
                        break;
                    case 3:
                        System.out.println("Cliente");
                        reserva: buscarUnaReservaPorCliente(scanner.next());

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

        return reserva;

    }

    public void listarReservas() {

        List<Reserva> reservas = accesoReservas.obtenerRegistros();
        boolean resp = false;
        int i = 0;

        if (reservas == null || reservas.isEmpty()) {
            System.out.println("No aun ningun registro de Reservas");
        } else {

            for (int j = 0; j < reservas.size(); j++) {
                reservas.get(i).mostrar();
            }
        }
    }

    public Reserva buscarUnaReservaPorID(String id) {
        Reserva reserva = null;
        try {

            List<Reserva> reservas = accesoReservas.obtenerRegistros();
            boolean resp = false;
            int i = 0;
            while (!resp && i < reservas.size()) {
                if (reservas.get(i).getId().equals(id)) {
                    reserva = reservas.get(i);
                    reserva.mostrar();
                    resp = true;
                }
                i++;
            }
        } catch (NullPointerException e) {
            System.out.println();
        }

        return reserva;
    }

    public Reserva buscarUnaReservaPorFecha(String fecha) {

        return reserva;
    } // TODO Antonela

    public Reserva buscarUnaReservaPorCliente(String cliente) {

        return reserva;
    } // TODO Antonla

    public void modificarUnaReserva() {
    } // TODO Antonela

    public boolean verificarFechaDeReservaDisponible(String fechaRes) {

        List<Reserva> reservas = accesoReservas.obtenerRegistros();
        for (Reserva r : reservas) {
            if ((r != null) && (r.getFechaEvento().equals(fechaRes))) {

                return false;

            }

        }
        System.out.println("fecha r");
        return true;
    }

    // endregion
    // endregion

    // region Ventas
    private void getMenuGestionVentas() {
        boolean resp = true;
        int seleccion;

        while (resp) {
            Vista.titulo("Gestion de ventas");
            Vista.menuGestionVentas();
            seleccion = Helpers.validarInt();
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
                    Vista.opcionIncorrecta(seleccion);
                    break;
            }
        }

    }

    // region Ver Historial
    // endregion
    // region ABM
    // endregion

    // endregion

    // region Menu Cliente
    private void getMenuGestionClientes() {
        boolean resp = true;
        int seleccion;
        while (resp) {
            Vista.titulo("Gestion de Clientes");
            Vista.menuGestionClientes();
            seleccion = Helpers.validarInt();
            switch (seleccion) {
                case 0:
                    resp = false;
                    break;
                case 1:
                    darAltaUnCliente();
                    break;
                case 2:
                    darDeBajaCliente();
                    break;
                case 3:
                    buscarCliente();
                    break;
                case 4:
                    listarClientes();
                default:
                    Vista.opcionIncorrecta(seleccion);
                    break;

            }
        }

    }

    public void darAltaUnCliente() {
        Scanner entradaEscanner = new Scanner(System.in);
        Cliente cliente = null;
        List<Reserva>listaReservas = null;
        System.out.println("DAR ALTA CLIENTE");
        System.out.println("");
        System.out.print("\nIngrese el nombre del cliente: ");
        String nombre = entradaEscanner.next();
        System.out.print("\nIngrese el apellido del cliente: ");
        String apellido = entradaEscanner.next();
        
        // validacion de fecha

        System.out.print("\nIngrese el nacimiento del cliente: dd/MM/yyyy ");
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
        System.out.print("\nIngrese dni del cliente: ");
        dni = entradaEscanner.next();

        // Validamos el dni que nos da el cliente.
        respuest = Helpers.validarDni(dni);


        String email = "";
        boolean estado = true;
        boolean respu = true;
        while (respu == true) {
            // Validamos el email que nos da el cliente.
            System.out.println("\nIngrese el email del cliente: ");
            email = entradaEscanner.next();

            respu = false;
            String fecha3 = "12-12-12";

        }
        String fecha3=null;
        cliente = new Cliente(nombre, apellido, fecha3, telefono, direccion, dni, email, estado, listaReservas);
        System.out.println("Se agrego exitosamente el cliente");
        accesoClientes.agregarRegistro(cliente);

    }


    public void buscarCliente(){
        Scanner escanner = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente a buscar: ");
        String dni = "";
        dni = escanner.next();
        Cliente g = new Cliente();
        if (g.getDni().equals(dni)) {
            g = accesoClientes.obtenerRegistro(g);
            System.out.println("Cliente encontrado");
            System.out.println(g);
        } else {
            System.out.println("El dni no existe.");
        }
    }

    public void listarClientes() {
        List<Cliente> listaClientes = null;
        listaClientes = accesoClientes.obtenerRegistros();
        System.out.println(listaClientes);
    }


    public void darDeBajaCliente() {
        Cliente h = new Cliente();
        boolean a = accesoClientes.borrarRegistro(h);
        if (a == true) {
            h.setEstado(false);
            h.toString();
        } else {
            System.out.println("El cliente no ha podido darse de baja.");
        }
    }

    // region ABM

    // endregion
    // region Ver Stock
    // endregion

    // endregion

    // endregion

    // region Menu Cliente
    private void getMenuCliente() {
        boolean resp = true;
        int opcion;
        while (resp) {
            Vista.titulo("Bienvenido " + this.cliente.getUsername());
            Vista.menuPrincipalUsuario();
            opcion = Helpers.validarInt();
            switch (opcion) {
                case 0:
                    resp = false;
                    break;
                case 1:
                    System.out.println("VISTA DE LOS MENUS DISPONIBLES");
                    break;
                case 2:
                    dardeAltaUnaReserva();
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
                    this.cliente.listarReservas();
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
        int opc;
        String aux = "";
        //LocalDate fecha;
        while (resp) {
            Vista.titulo("Modificacion de datos personales");
            Vista.modificarInformacionPersonal();
            opc = Helpers.validarInt();
            switch (opc) {
                case 0:
                    resp = false;
                    break;
                case 1:
                    aux = Helpers.validaciones("nombre", Helpers.VALIDAR_NOMBRES, "Tiene que empezar con mayusculas y se pueden ingresar hasta 2 nombres");
                    this.cliente.setNombre(aux);
                    break;
                case 2:
                    aux = Helpers.validaciones("apellido", Helpers.VALIDAR_NOMBRES, "Tiene que empezar con mayusculas y se pueden ingresar hasta 2 nombres");
                    this.cliente.setApellido(aux);
                    break;
                case 3:
                    //fecha = Helpers.validarFecha();
                    //this.cliente.setFechaNacimiento(fecha);
                    break;
                case 4:
                    aux = Helpers.validaciones("telefono", Helpers.VALIDAR_TELEFONO, "Coloque el numero sin 0 ni 15");
                    this.cliente.setTelefono(aux);
                    break;
                case 5:
                    Vista.ingreseDato("Ingrese una direccion");
                    aux = Helpers.nextLine();
                    break;
                case 6:
                    aux = Helpers.validaciones("DNI", Helpers.VALIDAR_DNI, "Ingrese un dni valido");
                    this.cliente.setDni(aux);
                    break;
                case 7:
                    aux = passwordIguales();
                    this.cliente.setPassword(aux);
                    break;
                case 8:
                    aux = Helpers.validaciones("email", Helpers.VALIDAR_EMAIL, "Ingrese un email valido");
                    this.cliente.setEmail(aux);
                    break;
                default:
                    Vista.opcionIncorrecta(opc);
                    break;
            }
            this.accesoClientes.actualizarRegistro(this.cliente);
            this.listaClientes = accesoClientes.obtenerRegistros();
        }
    }

    // endregion
}
