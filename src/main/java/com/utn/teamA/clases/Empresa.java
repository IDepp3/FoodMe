package com.utn.teamA.clases;

import java.nio.channels.ScatteringByteChannel;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import com.utn.teamA.ConexionDatos.AccesoClientes;
import com.utn.teamA.ConexionDatos.AccesoEmpleados;
import com.utn.teamA.ConexionDatos.AccesoReservas;
import com.utn.teamA.excepciones.ClienteNoExiste;
import com.utn.teamA.excepciones.FechaInvalidaException;
import com.utn.teamA.excepciones.FechaNoDisponible;
import com.utn.teamA.excepciones.NoExisteReserva;
import com.utn.teamA.utils.Color;
import com.utn.teamA.utils.Helpers;
import com.utn.teamA.utils.Vista;

/**
 * Clase Empresa
 */

public class Empresa {

    // region ATRIBUTOS

    private String nombre;
    private String direccion;
    private String CUIT;
    private String nacimiento;
    private String localidad;

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
        listaReservas = new ArrayList<>();
        listaEmpleados = new ArrayList<>();
        listaMenus = new ArrayList<Menu>();

        this.cliente = null;
        this.accesoClientes = new AccesoClientes();

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
        this.listaReservas = listaReservas;
        this.listaMenus = listaMenus;
        this.listaEmpleados = listaEmpleados;

        this.cliente = null;
        this.accesoClientes = new AccesoClientes();

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

    // endregion

    // region Setters

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
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
                + ", nacimiento=" + nacimiento + ", localidad='" + localidad + ", listaReservas=" + listaReservas
                + ", listaMenus=" + listaMenus + ", listaEmpleados=" + listaEmpleados + '}';
    }

    public void mostrar() {
        System.out.println(this);
    }

    // endregion

    // region Menu Principal

    public void iniciarSistema() {
        menuPrincipal();
    }

    public void menuPrincipal() {
        boolean resp = true;

        int opcion;
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
                    if (this.cliente != null) {
                        if (this.cliente.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR.tipo))
                            getMenuAdministrador();
                        else if (this.cliente.getTipoUsuario().equals(TipoUsuario.CLIENTE.tipo))
                            getMenuCliente(cliente);
                    } else
                        Vista.opcionIncorrecta("El usuario o contraseña es incorrecto");
                    break;
                case 2:
                    Vista.titulo("Registrarse");
                    this.cliente = registroUsuario();
                    if (!this.accesoClientes.existeRegistro(this.accesoClientes.obtenerRegistros(), this.cliente)) {

                        if (this.accesoClientes.agregarRegistro(this.cliente))
                            Vista.opcionCorrecta("Usuario creado correctamente");
                        else
                            Vista.opcionIncorrecta("Algo salio mal al crear el usuario");

                    } else
                        Vista.opcionIncorrecta("El usuario ya existe");
                    break;
                default:
                    Vista.opcionIncorrecta(opcion);
                    break;
            }
            this.cliente = null;
        }
        System.out.println("Gracias por usar la aplicacion");
    }

    // endregion

    // region Login y registro

    private Cliente loginUsuario() {
        Cliente c = new Cliente();

        Vista.ingreseDato("Nombre de usuario");
        c.setUsername(Helpers.nextLine());
        Vista.ingreseDato("Password");
        c.setPassword(Helpers.nextLine());

        c = this.accesoClientes.obtenerRegistroUsuarioPassword(c);

        return c;
    }

    private Cliente registroUsuario() {
        Cliente cliente;
        String nombreUsuario = Helpers.validaciones("Nombre usuario", Helpers.VALIDAR_NOMBRE_USUARIO,
                "Error, comienza con numeros o letras y puede contener (._) minimo 8, maximo 20 caracteres");
        String password = passwordIguales();
        String email = Helpers.validaciones("Email", Helpers.VALIDAR_EMAIL, "Ingrese email valido");
        cliente = new Cliente(Helpers.generarID(), nombreUsuario, password, email, Helpers.fechaActual(),
                Helpers.tipoAdministrador(), Helpers.estadoActivo());

        return cliente;
    }

    private String passwordIguales() {
        boolean resp = false;
        String pass = "";
        String confirmacion;

        while (!resp) {
            pass = Helpers.validaciones("Ingrese password", Helpers.VALIDAR_PASSWORD,
                    "Su contraseña debe ser como minimo de 8 caracteres maximo 15, 1 mayuscula, 1 minuscula, 1 digito, no espacios en blanco y al menos 1 caracter especial($@!%*?&)");
            confirmacion = Helpers.validaciones("Reingrese password", Helpers.VALIDAR_PASSWORD,
                    "Su contraseña debe ser como minimo de 8 caracteres maximo 15, 1 mayuscula, 1 minuscula, 1 digito, no espacios en blanco y al menos 1 caracter especial($@!%*?&)");
            if (pass.equals(confirmacion))
                resp = true;
            else
                Vista.opcionIncorrecta("Las contraseñas no coinciden");
        }

        return pass;
    }

    // endregion

    // region Menu Administrador

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
                    Vista.titulo("GESTION DE PERSONAL");
                    getMenuGestionPersonal();
                    break;
                case 2:
                    Vista.titulo("GESTION DE RESERVAS");
                    getMenuGestionReservas();
                    break;
                case 3:
                    getMenuGestionClientes();
                    break;
                case 4:
                    Vista.titulo("GESTION DE VENTAS");
                    getMenuGestionVentas();
                    break;
                default:
                    Vista.opcionIncorrecta(seleccion);
            }
        }
    }

    // region Personal

    private void getMenuGestionPersonal() {
        boolean resp = true;
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
                    menuAltaEmpleado();
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

    public void menuAltaEmpleado() {
        boolean resp = true;
        int opcion;

        while (resp) {
            Vista.titulo("Alta Empleado");
            System.out.println("1- Empleado existente");
            System.out.println("2- Crear nuevo empleado");
            System.out.println("0- Volver");
            opcion = Helpers.validarInt();
            switch (opcion) {
                case 0:
                    resp = false;
                    break;
                case 1:
                    darAltaEmpleadoExistente();
                    break;
                case 2:
                    darAltaUnEmpleado();
                    break;
                default:
                    Vista.opcionIncorrecta(opcion);
            }
        }
    }

    public void darAltaEmpleadoExistente() {

        Vista.ingreseDato("Ingrese el dni del Empleado ");
        String dni = Helpers.nextLine();
        Empleado a = new Empleado();
        a.setDni(dni);
        a = this.accesoEmpleados.obtenerRegistro(a);
        if (a != null) {
            a.setEstado(true);
            this.accesoEmpleados.actualizarRegistro(a);
            System.out.println("El empleado fue dado de alta nuevamente");
        } else {
            System.out.println("El empleado no existe");
        }

    }

    // region ABM Personal
    public void darAltaUnEmpleado() {
        Scanner entradaEscanner = new Scanner(System.in);
        Empleado empleado = null;
        String tipo = "";
        double sueldo = 0;
        System.out.println("\nDAR ALTA EMPLEADO");
        System.out.println();
        boolean respuestaNombre = false;

        String nombre = "";

        while (respuestaNombre == false) {

            System.out.println("\nIngrese el nombre del empleado: ");
            
            nombre = Helpers.nextLine();
            // Validamos el nombre que nos brinda el cliente.
            respuestaNombre = Helpers.validarNombre(nombre);

        }

        boolean respuestaApellido = false;

        String apellido = "";

        while (respuestaApellido == false) {

            System.out.print("\nIngrese el apellido del empleado: ");
            apellido = Helpers.nextLine();
            // Validamos el apellido que nos brinda el cliente.
            respuestaApellido = Helpers.validarApellido(apellido);
        }

        boolean respuestaFecha = false;

        // validacion de fecha
        LocalDate fecha = null;
        while (respuestaFecha == false) {
            try {
                int dia, mes, anio;
                System.out.print("\nIngrese el nacimiento del empleado: <DD/MM/AAAA> ");
                System.out.println("\nIngrese el dia: ");
                dia = entradaEscanner.nextInt();
                System.out.println("\nIngrese el mes: ");
                mes = entradaEscanner.nextInt();
                System.out.println("\nIngrese el año");
                anio = entradaEscanner.nextInt();
                fecha = LocalDate.of(anio, mes, dia);
                respuestaFecha = true;
            } catch (DateTimeException e) {
                System.out.println("\nLa fecha ingresada es incorrecta.");
            }
        }
        String telefono = "";

        boolean respuesta = false;
        while (respuesta == false) {

            System.out.print("\nIngrese numero de celular sin 0 ni 15: ");
            telefono = Helpers.nextLine();
            // Validamos el dni que nos da el cliente.
            respuesta = Helpers.validarTel(telefono);

        }

        String dni = "";

        System.out.print("\nIngrese la direccion: ");
        direccion = Helpers.nextLine();

        boolean respuestaDni = false;

        while (respuestaDni == false) {
            System.out.print("\nIngrese dni del empleado: ");
            dni = Helpers.nextLine();

            // Validamos el dni que nos da el cliente.
            respuestaDni = Helpers.validarDni(dni);
        }

        // Estado del Empleado
        boolean estado = true;
        boolean respuestaEmail = false;

        String email = "";

        while (respuestaEmail == false) {

            System.out.println("\nIngrese el email del empleado: ");
            email = Helpers.nextLine();
            // Validamos el email que nos da el cliente.
            respuestaEmail = Helpers.validarEmail(email);
        }

        System.out.println("\nIngrese tipo del empleado");
        System.out.println("\n 4 - MOZO | 5 - BARTENDER | 6 - SUSHIMAN");
        Scanner en = new Scanner(System.in);
        int op = 0;
        op = en.nextInt();
        tipo = null;
        switch (op) {
            case 4:
                tipo = TipoEmpleado.MOZO.toString();
                break;
            case 5:
                tipo = TipoEmpleado.BARTENDER.toString();
                break;
            case 6:
                tipo = TipoEmpleado.SUSHIMAN.toString();
                break;
            default:
                System.out.println("Opcion incorrecta");
        }

        System.out.println("\nIngrese sueldo del empleado: ");

        sueldo = entradaEscanner.nextDouble();

        empleado = new Empleado(nombre, apellido, fecha.toString(), telefono, direccion, dni, email, tipo, sueldo,
                estado);
        System.out.println("\nEl empleado se agrego exitosamente");
        accesoEmpleados.agregarRegistro(empleado);

    }

    // Damos de baja un empleado, el cual buscamos por Dni, en caso
    // de encontrarlo, su atributo estado pasara de Activo a Inactivo.
    public void darDeBaja() {
        System.out.println("DAMOS DE BAJA UN EMPLEADO.");
        System.out.println("Ingrese el dni del empleado: ");
        Empleado h = new Empleado();
        Scanner s = new Scanner(System.in);
        String dni = s.next();

        h.setDni(dni);
        boolean a = accesoEmpleados.borrarRegistro(h);
        if (a == true) {
            System.out.println("El empleado con dni: " + dni + " fue dado de baja.");
            h.setEstado(false);
            h.toString();
        } else {
            System.out.println("No hay empleados con el dni ingresado.");
        }
    }

    // Buscamos un empleado mediante el Dni del mismo, en caso
    // de encontrarlo dira que fue encontrado.

    public void buscarEmpleado() {

        Scanner escanner = new Scanner(System.in);
        System.out.println("\nACA BUSCAMOS UN EMPLEADO.");
        System.out.println("Ingrese el dni del empleado a buscar: ");
        String dni = "";
        dni = escanner.next();
        Empleado g = new Empleado();
        g.setDni(dni);
        if (accesoEmpleados.obtenerRegistro(g) != null) {
            g = accesoEmpleados.obtenerRegistro(g);

            System.out.println("\nCliente encontrado: " + "\nNombre: " + g.getNombre() + "\nApellido: "
                    + g.getApellido() + "\nDni: " + g.getDni() + "\nTelefono: " + g.getTelefono()
                    + "\nFecha Nacimiento: " + g.getFechaNacimiento() + "\nEmail: " + g.getEmail() + "\nTipo Empleado: "
                    + g.getTipoEmpleado() + "\nSueldo: " + g.getSueldo() + "\nEstado: "
                    + (g.getEstado() ? "Activo" : "Inactivo"));

        } else {
            System.out.println("No hay empleados con el dni ingresado.");
        }
    }

    public void listarEmpleados() {
        System.out.println("\nACA LISTAMOS LOS EMPLEADOS");
        List<Empleado> listaEmpleado = null;
        listaEmpleado = accesoEmpleados.obtenerRegistros();
        System.out.println(listaEmpleado.toString());
    }

    // endregion

    // endregion

    // region Reservas

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
                        darAltaReservas();
                        break;
                    case 2:
                        Vista.titulo(" BAJA UNA RESERVA.");
                        darBajaReservas();
                        break;
                    case 3:
                        Vista.titulo(" BUSCAR UNA RESERVA");
                        buscarReservas();
                        break;
                    case 4:
                        Vista.titulo("MODIFICAR UNA RESERVA");
                        modificarReservas();
                        break;
                    case 5:
                        Vista.titulo("LISTAR RESERVAS");
                        listarReservas();
                        break;
                    default:

                        System.out.println("Ingreso un dato Incorrecto. Reintente");

                }
            } catch (InputMismatchException e) {
                getMenuGestionReservas();
            } catch (Exception e) {
                getMenuGestionReservas();
            }
        }
    }

    // region Alta Como Admin
    public Reserva darAltaReservas() throws FechaInvalidaException {

        Scanner entradaEscanner2 = new Scanner(System.in);
        int ope = 1;
        String seguir = "s";
        LocalDate fecha = null;
        Hora hora = new Hora();
        StringBuilder horarioLlegada = null;
        StringBuilder horarioInicio = null;
        StringBuilder horarioFinaliza = null;
        List<Menu> menus;
        String descripcion;
        boolean quierebartender;
        String idCliente = null;

        while (seguir.equals("s")) {

            // Usuario ingresa fecha, valida que sea 48hs posterior al dia actual
            do {
                fecha = elegirFechaDeEvento();
                //System.out.println(fecha.toString());
            } while (!verificarFechaValida(fecha));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fecha3 = fecha.toString();
            Vista.deseaSeguirCargandoDatos();
            seguir = entradaEscanner2.nextLine();
            if (seguir.equals("n"))
                break;

            // Usuario ingresa la hora y minutos en el que empieza el evento.
            // calcula horarios de llegada y finalizacion
            System.out.println(Color.ANSI_BLUE + " 1 " + Color.ANSI_RESET + "Ingrese hora de inicio del Evento");
            String aviso = "Acordate que nuestro servivio dura entre: 3.5-4 hs. Llegamos entre: 3-4 hs antes. Finalizamos: 3-4 hs despues. FOODME.CO ";
            System.out.println(aviso);
            hora.init();
            horarioLlegada = hora.calcularLlegada(3);
            horarioInicio = hora.setearHoraInicio();
            horarioFinaliza = hora.calcularFinalizacion(4); // todo constante de horas de servicio
            Vista.deseaSeguirCargandoDatos();
            seguir = entradaEscanner2.nextLine();
            if (seguir.equals("n"))
                break;

            // Usuario ingresa Cliente:el sistema dirige al menu cliente en donde puede buscar o
            // dar alta un cliente. Se captura  el id cliente variable
            System.out.println(Color.ANSI_BLUE + " 2 " + Color.ANSI_RESET + "Seleccione el Cliente ");
            idCliente = reserevaIngresarCliente();
            System.out.println("Id Cliente :" + idCliente);

            Vista.deseaSeguirCargandoDatos();
            seguir = entradaEscanner2.nextLine();
            if (seguir.equals("n"))
                break;

            // Usuario selecciona Los tipo de Menu, cantidad de personas por menu e
            // ingredientes
            System.out.println(Color.ANSI_BLUE + " 3 " + Color.ANSI_RESET + "Seleccione los Menus ");
            System.out.println(Color.ANSI_BLUE + "  ");
            // traer lista de menus y sus ingredientes
            menus = seleccionarMenus();
            Vista.deseaSeguirCargandoDatos();
            seguir = entradaEscanner2.nextLine();
            if (seguir.equals("n"))
                break;

            // Usuario Ingresa si quiere bartender como servicio
            System.out.println(Color.ANSI_BLUE + " 5- " + Color.ANSI_RESET + "Quiere Bartender?s/n");
            String op = entradaEscanner2.nextLine();
            quierebartender = op.equals("s");

            // Usuario ingresa descripcion en la reserva. detalles preguntas de servicio
            // etc.
            System.out.println(Color.ANSI_BLUE + " 4- " + Color.ANSI_RESET + "Ingrese descripcion");
            descripcion = entradaEscanner2.nextLine();
            if (seguir.equals("n"))
                break;
            Vista.deseaSeguirCargandoDatos();
            seguir = entradaEscanner2.nextLine();
            if (seguir.equals("n"))
                break;

            Vista.opcionCorrecta("Finalizo cargar su reserva");

            Reserva reserva = new Reserva(fecha3, idCliente, horarioLlegada, horarioInicio, horarioFinaliza, menus,
                    descripcion, quierebartender);

            // El sistema inicializa el objeto
            // Reserva reserva = new Reserva(fechaAString, horarioLlegada, horarioInicio,
            // horarioFinaliza, idCliente, menus, descripcion, quierebartender);

            // Calcula costoTotal + servicio(mano de obra) en funcion a la cantidad de
            // personas
            reserva.setCostoTotal(1000.0);
            // reserva.setCosto(reserva.calcularCosto());//todo Antonela1

            // Calcula Precio Final = a costo + IVA (si el cliente paga en efectivo) con una
            // rentabilidad del 25%
            reserva.calcularPrecionFinal();

            System.out.println("Costo:" + reserva.getCostoTotal());
            System.out.println("Precio Final:" + reserva.getPrecioFinal());

            reserva.mostrar();

            Vista.finalizarReserva();
            seguir = entradaEscanner2.nextLine();
            if (seguir.equals("n"))
                break;

            // El sistema guarda en el archivo en formato json
            accesoReservas.mostrar(reserva);

            boolean a = accesoReservas.agregarRegistro(reserva);

            Vista.opcionCorrecta("La reserva se cargo con exito");

            seguir = "n";
        }
        return reserva;
    }

    // Alta Reserva Como cliente
    public void dardeAltaUnaReserva(Cliente cliente) {

        Scanner entradaEscanner2 = new Scanner(System.in);
        int ope = 1;
        String seguir = "s";
        LocalDate fecha = null;
        Hora hora = new Hora();
        StringBuilder horarioLlegada = null;
        StringBuilder horarioInicio = null;
        StringBuilder horarioFinaliza = null;
        List<Menu> menus;
        String descripcion;
        boolean quierebartender;
        String idCliente2 = null;

        String otro = "";

        while (seguir.equals("s")) {

            // Usuario ingresa fecha, valida que sea 48hs posterior al dia actual
            try {
                fecha = elegirFechaDeEvento();
                //System.out.println(fecha.toString());
            } catch (Exception e) {
                System.err.println("Fecha invalida");
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fecha3 = fecha.toString();

            Vista.deseaSeguirCargandoDatos();
            seguir = entradaEscanner2.nextLine();
            if (seguir.equals("n"))
                break;

            // Usuario ingresa la hora y minutos en el que empieza el evento.
            // calcula horarios de llegada y finalizacion
            System.out.println(Color.ANSI_BLUE + " 1 " + Color.ANSI_RESET + "Ingrese hora de inicio del Evento");
            String aviso = "Acordate que nuestro servivio dura entre: 3.5-4 hs. Llegamos entre: 3-4 hs antes. Finalizamos: 3-4 hs despues. FOODME.CO ";
            System.out.println(aviso);
            hora.init();
            horarioLlegada = hora.calcularLlegada(3);
            horarioInicio = hora.setearHoraInicio();
            horarioFinaliza = hora.calcularFinalizacion(4); // todo constante de horas de servicio
            Vista.deseaSeguirCargandoDatos();
            seguir = entradaEscanner2.nextLine();
            if (seguir.equals("n"))
                break;

            // Usuario ingresa Cliente/ lo dirige al menu cliente en donde puede buscar
            // al cliente o darlo de alta. se guarda el id del cliente
            idCliente2 = cliente.getId();

            // Usuario selecciona Los tipo de Menu, cantidad de personas por menu e
            // ingredientes
            System.out.println(Color.ANSI_BLUE + " 3 " + Color.ANSI_RESET + "Seleccione los Menus ");
            // traer lista de menus y sus ingredientes
            menus = seleccionarMenus();
            Vista.deseaSeguirCargandoDatos();
            seguir = entradaEscanner2.nextLine();
            if (seguir.equals("n"))
                break;

            // Usuario Ingresa si quiere bartender como servicio
            System.out.println(Color.ANSI_BLUE + " 5- " + Color.ANSI_RESET + "Quiere Bartender?s/n");
            String op = entradaEscanner2.nextLine();
            quierebartender = op.equals("s");

            // Usuario ingresa descripcion en la reserva. detalles preguntas de servicio
            // etc.
            System.out.println(Color.ANSI_BLUE + " 4- " + Color.ANSI_RESET + "Ingrese descripcion");
            descripcion = entradaEscanner2.nextLine();
            if (seguir.equals("n"))
                break;
            Vista.deseaSeguirCargandoDatos();
            seguir = entradaEscanner2.nextLine();
            if (seguir.equals("n"))
                break;

            Vista.opcionCorrecta("Finalizo cargar su reserva");

            Reserva reserva = new Reserva(fecha3, idCliente2, horarioLlegada, horarioInicio, horarioFinaliza, menus,
                    descripcion, quierebartender);
            reserva.mostrar();

            // El sistema inicializa el objeto
            // Reserva reserva = new Reserva(fechaAString, horarioLlegada, horarioInicio,
            // horarioFinaliza, idCliente, menus, descripcion, quierebartender);

            // Calcula costoTotal + servicio(mano de obra) en funcion a la cantidad de
            // personas
            reserva.setCostoTotal(100.0);
            // reserva.setCosto(reserva.calcularCosto());//todo Antonela1

            // Calcula Precio Final = a costo + IVA (si el cliente paga en efectivo) con una
            // rentabilidad del 25%
            reserva.calcularPrecionFinal();

            System.out.println("Costo:" + reserva.getCostoTotal());
            System.out.println("Precio Final:" + reserva.getPrecioFinal());

            Vista.finalizarReserva();
            seguir = entradaEscanner2.nextLine();
            if (seguir.equals("n"))
                break;

            // El sistema guarda en el archivo en formato json
            accesoReservas.mostrar(reserva);

            boolean a = accesoReservas.agregarRegistro(reserva);

            Vista.opcionCorrecta("La reserva se cargo con exito");

            seguir = "n";
        }

    }

    private String reserevaIngresarCliente() {
        Scanner entradaEscanner2 = new Scanner(System.in);

        String dni = null;
        Cliente clienteRegistrado = null;
        String idCliente = null;

        do {

            try {

                boolean resp = true;
                int opt = 0;


                while (resp) {

                    System.out.println("");

                    System.out.println("1- Alta cliente");
                    System.out.println("2- Buscar Cliente por Username");
                    System.out.println("0- Guardar");
                    opt = entradaEscanner2.nextInt();

                    entradaEscanner2.nextLine();

                    switch (opt) {
                        case 0:
                            resp = false;
                            break;
                        case 1:
                            Vista.titulo("Alta Cliente");
                            Cliente cliente = darAltaUnCliente();
                            idCliente= cliente.getId();
                            cliente.mostrar();
                            break;
                        case 2:
                            Vista.titulo("Buscar Cliente");
                             idCliente = buscarClienteR();
                           break;
                        default:
                            System.err.println("Dato incorrecto. Reintente");
                            break;
                    }
                }

            } catch (Exception e) {

            }

        } while (idCliente == null);

        return idCliente;
    }

    public String buscarClienteR(){
        String idCliente = null;
        Cliente clienteRegistrado = null;
        String dni3 = null;
        String idclienteRegistrado = null;
        Scanner entradaEscanner2 = new Scanner(System.in);
        try {

                 String nombreUsuario = Helpers.validaciones("Nombre usuario", Helpers.VALIDAR_NOMBRE_USUARIO,
                    "Error, comienza con numeros o letras y puede contener (._) minimo 8, maximo 20 caracteres");

                clienteRegistrado = accesoClientes.buscarCliente(nombreUsuario);
                clienteRegistrado.mostrar();
                idCliente = clienteRegistrado.getId();


        }catch (NullPointerException | ClienteNoExiste e){
            System.err.println("No existe el cliente");
            buscarClienteR();
        }
        return idCliente;
    }

    private boolean validarDia(String dia) {

        if (dia.length() != 2) // Comprobamos que son dos caracteres

            return false;

        else { // Y que es un valor numérico, entre 0 y 31

            try {

                int dd = Integer.parseInt(dia);

                return (dd > 0 && dd < 31);

            }

            catch (NumberFormatException e) {

                return false; // No se ha tecleado un valor numérico

            }

        }

    }

    private boolean validarMes(String mes) {

        if (mes.length() != 2)

            return false;

        else {

            try {

                int mm = Integer.parseInt(mes);

                return (mm > 0 && mm < 13);

            } catch (NumberFormatException e) {

                return false;

            }

        }

    }

    private boolean validarAnio(String anio) {

        if (anio.length() != 4)

            return false;

        else {

            try {

                int aaaa = Integer.parseInt(anio);

                return (aaaa != 0); // Aquí depende de que fechas queremos aceptar

            } catch (NumberFormatException e) {

                return false;

            }

        }

    }

    private LocalDate elegirFechaDeEvento() {

        LocalDate fecha = null;
        Scanner entradaEscanner = new Scanner(System.in);
        String f = "";
        String si = "s";
        boolean validar = false;
        boolean disponibilidad = false;
        while (si.equals("s")) {
            try {
                String mes = null;
                String anio = null;
                String dia = null;

                do {

                    LocalDate fechatentativa = validarfecha();
                    validar = verificarFechaValida(fechatentativa);

                    disponibilidad = accesoReservas.verificarFechaDeEventoDisponible(fechatentativa.toString());

                    if (disponibilidad) {
                        Vista.opcionCorrecta("Fecha disponible");
                        fecha = fechatentativa;
                    } else {
                        System.err.println("Fecha No Disponible");
                    }

                    Vista.deseaSeguirCargandoFechas();
                    si = entradaEscanner.next();

                } while (((!validar) && (!disponibilidad)) || (si.equals("s")));

            } catch (FechaNoDisponible e) {
                System.err.println("Fecha no disponible");
                Vista.deseaSeguirCargandoFechas();
                si = entradaEscanner.next();
            } catch (FechaInvalidaException e) {
                System.err.println("Fecha Invalida");
                Vista.deseaSeguirCargandoFechas();
                si = entradaEscanner.next();

            } catch (NullPointerException e) {
                System.err.println("No hay registros aun");
            } catch (Exception e) {
                System.err.println("Error. Fecha invalida");
                elegirFechaDeEvento();
            }

        }
        return fecha;

    }

    public boolean verificarFechaValida(LocalDate fechaVali) throws FechaInvalidaException {

        boolean fechaValida = false;

        if ((fechaVali.isAfter(LocalDate.now().plusDays(2)))) {
            fechaValida = true;
        } else {
            throw new FechaInvalidaException("Fecha Invalida");
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
                // trear ingredientes Todo trear Ingredientes al cargar una reserva

                op = entrada.nextInt();

                switch (op) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        System.out
                                .println(Color.ANSI_BLUE + " 1- " + Color.ANSI_RESET + "Ingrese cantidad de Personas");
                        int cantidadPer = entrada.nextInt();
                        entrada.nextLine();
                        menu.setCantPersonas(cantidadPer);
                        System.out.println("Cantidad = " + menu.getCantPersonas());
                        break;
                    case 2:
                        System.out.println(Color.ANSI_BLUE + " 2- " + Color.ANSI_RESET + "Eliminar ingrediente");
                        break;
                    case 3:
                        System.out.println(
                                Color.ANSI_BLUE + " 3- " + Color.ANSI_RESET + "Modificar algun ingrediente del menu");
                        break;
                    default:
                }

            }
        } catch (NullPointerException e) {

        } catch (InputMismatchException e) {
            seleccionarMenus();
        } catch (Exception e) {
            seleccionarMenus();
        } finally {

            return menu;
        }

    }

    // endregion

    // region Baja

    public void darBajaReservas() {
        List<Reserva> reservasCliente = new ArrayList<>();
        Reserva reserva = null;
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        boolean resp = true;
        try {

            while (resp == true) {

                Vista.darBajaReservas();
                op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        System.out.println(Color.ANSI_BLUE + " 1- " + Color.ANSI_RESET + "Ingrese el Id de la resreva a borrar");
                        String idReserva = scanner.next();
                        reserva = buscarReserva(idReserva);// esto despues lo puedo borraar
                        boolean reservaBajaId = darBajaReserva(reserva);

                        break;
                    case 2:

                        LocalDate fechaLD = validarfecha();
                        reserva = buscarReserva(fechaLD);
                        reserva.mostrar();
                        boolean reservaBajaFecha = darBajaReserva(reserva);
                        if (reservaBajaFecha) {
                            System.out.println("Reserva Cancelada");
                            buscarReserva(fechaLD).mostrar();
                        }
                        break;
                    case 3:

                        boolean resp4 = false;
                        List<Reserva> reservasClientefechas = new ArrayList<>();
                        Cliente cliente = null;

                        System.out.println(Color.ANSI_BLUE + " 3 " + Color.ANSI_RESET + "Dar de baja  por Cliente");
                        System.out.println("Ingrese el username del cliente");

                        while (!resp4) {
                            String username = Helpers.validaciones("Nombre usuario", Helpers.VALIDAR_NOMBRE_USUARIO,
                                    "Error, comienza con numeros o letras y puede contener (._) minimo 8, maximo 20 caracteres");
                            cliente = accesoClientes.buscarCliente(username);
                            reservasClientefechas = buscarReservas(cliente);
                            listarReservas(reservasClientefechas);
                            resp4 = true;
                        }

                        if (reservasClientefechas != null) {
                            System.out.println(Color.ANSI_BLUE + " 1- " + Color.ANSI_RESET + "Ingrese el Id de la reserva a borrar");
                            String idReserva2 = scanner.next();
                            reserva = buscarReserva(idReserva2);// esto despues lo puedo borraar
                            boolean reservaBajaId2 = darBajaReserva(reserva);
                            reserva = buscarReserva(idReserva2);// esto despues lo puedo borraar
                            reserva.mostrar();
                        }
                        break;
                    default:
                        System.err.println("Ingreso un dato incorrecto. Reintente");
                        break;

                }
            }
        }catch (NoExisteReserva e) {
            System.err.println("No existen reservas");
        }catch (ClienteNoExiste clienteNoExiste) {
            System.err.println("No existe el cliente");
        } catch (NullPointerException e) {

            darBajaReservas();

        } catch (InputMismatchException e) {

            darBajaReservas();

        } catch (Exception e) {

            darBajaReservas();

        }

    }

    public boolean darBajaReserva(Reserva reserva) {
        boolean reservaEliminada = false;
        try {
            if (reserva.isStatus()) {
                reservaEliminada = accesoReservas.borrarRegistro(reserva);
            } else {
                System.out.println("Ya se encuentra cancelada");
            }
        } catch (NullPointerException e) {

            System.err.println("No hay reservas con ese campo");

        } catch (Exception e) {

        }

        return reservaEliminada;
    }

    public LocalDate validarfecha(){
        Scanner entradaEscanner = new Scanner(System.in);
        String dia,mes,anio;
        System.out.println(Color.ANSI_BLUE + " 1- " + Color.ANSI_RESET + "Ingrese fecha del evento: dd/MM/yyyy");

            do {
                System.out.println("Dia: ");
                dia = entradaEscanner.next();
            } while (!validarDia(dia));

            do {
                System.out.println("Mes: ");
                mes = entradaEscanner.next();
            } while (!validarMes(mes));

            do {
                System.out.println("Año: ");
                anio = entradaEscanner.next();
                entradaEscanner.nextLine();
            } while (!validarAnio(anio));

            LocalDate fechatentativa = LocalDate.of(Integer.parseInt(anio), Integer.parseInt(mes),
                    Integer.parseInt(dia));

            return fechatentativa;
    }
    // endregion

    // region Modificar

    public void modificarReservas()  {

        List<Reserva> reservaM = null;
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        boolean resp = true;
        Vista.titulo("MODIFICAR RESERVA");
        try {

            reservaM = accesoReservas.obtenerRegistros();
            List<Reserva> reservasBuscar = accesoReservas.obtenerRegistros();
            listarReservas(reservasBuscar);
            Reserva reserva3 = null;
            String fecha3=null;
            do {
               Vista.titulo("Ingrese fecha de la reserva");
               LocalDate fecha3Ld = validarfecha();
               fecha3= fecha3Ld.toString();
               reserva3 = buscarReserva(fecha3Ld);
           }while (reserva3==null);


            while (resp == true) {

                Vista.titulo("Modificar Reserva");
                reserva3.mostrar();
                System.out.println("");
                Vista.menuModificarReserva();
                System.out.println("Ingrese una opcion:");
                op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {

                    case 0:
                            resp = false;
                            break;
                    case 1:
                        LocalDate fechaNuevaLd = null;
                        // Le pido al usuario que ingrese la fecha nueva
                        do {
                            System.out.println("Ingrese fecha nueva:");
                            fechaNuevaLd= validarfecha();

                        }while (!verificarFechaValida(fechaNuevaLd));

                            String fechaNueva = fechaNuevaLd.toString();
                            // Busca la reserva en la lista, la modifica y luego la vuelve a guardar en el
                            // archivo
                            reserva3=modificarReservaFecha(reservaM, fecha3, fechaNueva);
                            System.out.println("Se ha hecho la modificacion con exito!");

                        break;
                    case 2:
                        System.out.println("Modificar Menu");
                        List<Menu> menus = seleccionarMenus();
                        reserva3 = modificarReservaMenus(reservasBuscar, fecha3, menus);

                        break;
                    case 3:
                        // Le pide al usuario que ingrese la descripcion nueva
                        System.out.println("Modificar descripcion");
                        String descripcionNueva = scanner.nextLine();
                        reserva3 = modificarReservaDescripcion(reservaM, reserva3.getFechaEvento(), descripcionNueva);
                        break;
                    case 4:
                        System.out.println("Bartenders");
                        System.out.println("1- True");
                        System.out.println("2- False");
                        int opB = 0;
                        boolean quiereBartender = false;
                        opB = scanner.nextInt();
                        switch (opB){
                            case 1:
                                quiereBartender = true;
                                break;
                            case 2:
                                quiereBartender = false;
                            default:
                                System.err.println("Numero incorrecto");
                        }
                        reserva3 = modificarReservaQuiereBartender(reservaM,reserva3.getFechaEvento(),quiereBartender);
                        break;
                    case 5:
                        System.out.println("Cambiar status");
                        System.out.println("1- True");
                        System.out.println("2- False");
                         opB = 0;
                        boolean status = false;
                        opB = scanner.nextInt();
                        switch (opB){
                            case 1:
                                status = true;
                                break;
                            case 2:
                                status = false;
                            default:
                                System.err.println("Numero incorrecto");
                        }
                        reserva3 = modificarReservaStatus(reservaM,reserva3.getFechaEvento(),status);
                            break;
                    default:
                        System.out.println("Ingreso dato incorrecto. Reintente");
                }
            }

        }catch (FechaInvalidaException e){
            System.err.println("Fecha invalida");
            modificarReservas();

        } catch (NullPointerException e) {

            System.err.println("No existe");
            modificarReservas();

        } catch (InputMismatchException e) {
            System.err.println("Dato invalido");
            modificarReservas();

        } catch (Exception e) {
            System.err.println("Error");
            modificarReservas();
        }
    }

    public Reserva modificarReservaFecha(List<Reserva> reservas, String fechaVieja, String fechaNueva) {
        boolean resp = false;
        int i = 0;
        Reserva reserva = null;
            if (reservas != null) {
                while (!resp && i < reservas.size()) {
                    if (reservas.get(i).getFechaEvento().equals(fechaVieja)) {
                        reservas.get(i).setFechaEvento(fechaNueva);
                        accesoReservas.guardarInformacion(reservas);
                        reserva = reservas.get(i);
                        resp = true;
                    }
                    i++;
                }
            }
            return reserva;

    }

    public Reserva modificarReservaMenus(List<Reserva> reservas, String fecha, List<Menu> menus) {
        boolean resp = false;
        int i = 0;
        Reserva reserva = null;
        try {
            if (reservas != null) {
                while (!resp && i < reservas.size()) {
                    if (reservas.get(i).getFechaEvento().equals(fecha)) {

                        reservas.get(i).setMenus(menus);
                        reserva = reservas.get(i);
                        accesoReservas.guardarInformacion(reservas);
                        reservas.get(i).mostrar();
                        reserva = reservas.get(i);
                        resp = true;
                    }
                    i++;
                }

            }
        } catch (NullPointerException e) {

        } catch (Exception e) {

        }
        return reserva;
    }

    public Reserva modificarReservaDescripcion(List<Reserva> reservas, String fechaVieja, String descricion) {
        boolean resp = false;
        int i = 0;
        Reserva reserva = null;
        try {
            if (reservas != null) {
                while (!resp && i < reservas.size()) {
                    if (reservas.get(i).getFechaEvento().equals(fechaVieja)) {
                        reservas.get(i).setDescripcion(descricion);
                        reserva = reservas.get(i);
                        accesoReservas.guardarInformacion(reservas);
                        resp = true;
                    }
                    i++;
                }

            }
        } catch (NullPointerException e) {

        } catch (Exception e) {

        }
        return reserva;
    }

    public Reserva modificarReservaQuiereBartender(List<Reserva> reservas, String fecha, boolean quiereBartender) {
        boolean resp = false;
        int i = 0;
        Reserva reserva = null;
        try {
            if (reservas != null) {
                while (!resp && i < reservas.size()) {
                    if (reservas.get(i).getFechaEvento().equals(fecha)) {

                        reservas.get(i).setQuiereBartender(quiereBartender);
                        accesoReservas.guardarInformacion(reservas);
                        reserva = reservas.get(i);
                        resp = true;
                    }
                    i++;
                }

            }
        } catch (NullPointerException e) {

        } catch (Exception e) {

        }
        return reserva;
    }

    public Reserva modificarReservaStatus(List<Reserva> reservas, String fecha, boolean quiereBartender) {
        boolean resp = false;
        int i = 0;
        Reserva reserva = null;
        try {
            if (reservas != null) {
                while (!resp && i < reservas.size()) {
                    if (reservas.get(i).getFechaEvento().equals(fecha)) {

                        reservas.get(i).setQuiereBartender(quiereBartender);
                        accesoReservas.guardarInformacion(reservas);
                        reserva = reservas.get(i);
                        resp = true;
                    }
                    i++;
                }

            }
        } catch (NullPointerException e) {

        } catch (Exception e) {

        }
        return reserva;
    }
    // endregion

    // region Buscar

    public void buscarReservas() {
        List<Reserva> reservasCliente = new ArrayList<>();
        Reserva reserva = null;
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        boolean resp = true;
        try {

            while (resp == true) {

                System.out.println("");
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
                        reserva = null;
                        System.out.println("ID");
                        String idReserva = scanner.next();
                        scanner.nextLine();
                        reserva = buscarReserva(idReserva);
                        reserva.mostrar();
                        break;
                    case 2:
                        reserva = null;
                        reserva = seleccionarfechaEvento(scanner);
                        reserva.mostrar();
                        break;

                    case 3:
                        System.out.println("Cliente");
                        boolean dnivalido = false;
                        reservasCliente = null;
                        while (!dnivalido) {
                            String nombreUsuario = Helpers.validaciones("Nombre usuario", Helpers.VALIDAR_NOMBRE_USUARIO,
                                    "Error, comienza con numeros o letras y puede contener (._) minimo 8, maximo 20 caracteres");
                            Cliente clienteObj = accesoClientes.buscarCliente(nombreUsuario);
                            reservasCliente = buscarReservas(clienteObj);
                            System.out.println("Aca");
                            listarReservas(reservasCliente);
                            dnivalido = true;
                        }
                        break;
                    default:
                        System.out.println("Ingreso un dato incorrecto. Reintente");
                }
            }

           } catch (DateTimeException e) {
            System.err.println("Fecha invalida");
            buscarReservas();
           } catch (NullPointerException e) {
            System.err.println("No existen reservas ");
            buscarReservas();

        } catch (InputMismatchException e) {
            System.err.println("Error");
            buscarReservas();

        } catch (Exception e) {
            System.err.println("Error");
            buscarReservas();

        }

    }

    public Reserva buscarReserva(String id) {
        Reserva reserva = null;
        try {

            reserva = accesoReservas.obtenerRegistro(id);

        } catch (NoExisteReserva e) {

        } catch (NullPointerException e) {

        } catch (Exception e) {

        }

        return reserva;
    }

    public Reserva buscarReserva(LocalDate fechaLD) throws NoExisteReserva {
        Reserva reserva = null;
        try {

            reserva = accesoReservas.obtenerRegistro(fechaLD);

        }catch (NoExisteReserva e) {
            System.err.println("No existe reserva con esa fecha");
        }catch (NullPointerException e ){

        } catch (Exception e) {

        }
        return reserva;
    }

    public Reserva seleccionarfechaEvento(Scanner scanner) {
        reserva = null;

        try {
            LocalDate fechaLD = validarfecha();
            reserva = buscarReserva(fechaLD);

        } catch (NoExisteReserva e) {

        } catch (NullPointerException e) {

        } catch (Exception e) {

        }

        return reserva;

    }

    public List<Reserva> buscarReservas(Cliente cliente) {
        List<Reserva> reservasCliente = new ArrayList<>();
        try {

            reservasCliente = accesoReservas.obtenerRegistro(cliente);

        }catch (NoExisteReserva r){
            System.err.println("A");
        } catch (NullPointerException e) {

        } catch (Exception e) {

        }
        return reservasCliente;
    }

    public List<Reserva> buscarReservas(Cliente clienteObj,String username) throws NoExisteReserva {
        boolean resp = false;
        List<Reserva> reservasCliente = null;
        List<Reserva> reservas = null;
        int i = 0;

            reservas = accesoReservas.obtenerRegistros();

            if (!reservas.isEmpty()) {

                for (int j = 0; j < reservas.size(); j++) {
                    if(reservas.get(j).getIdCliente().equals(clienteObj.getId())){
                        reservasCliente.add(reservas.get(j));
                        reservas.get(j).mostrar();
                        resp=true;
                    }
                }
            }

            if (!resp) {
                throw new NoExisteReserva("No hay reservas");
            }


        return reservasCliente;
    }

    // endregion

    // region Listar

    public void listarReservas() {
        List<Reserva> reservasL = new ArrayList<>();
        Scanner entradaEscanner = new Scanner(System.in);
        boolean resp = true;

        while (resp) {

            Vista.menuListarReservas();

            reservasL = accesoReservas.obtenerRegistros();
            int seleccion;

            try {
                seleccion = entradaEscanner.nextInt();

                switch (seleccion) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        Vista.titulo(" Listar todas las reservas.");
                        listarTodaslasReservas();
                        break;
                    case 2:
                        Vista.titulo(" Listar reservas Activas.");
                        listarReservasActivas();
                        break;
                    case 3:
                        Vista.titulo(" Listar Reservas No Activas");
                        listarReservasNoActivas();
                        break;
                    case 4:
                        boolean resp4 = false;
                        Vista.titulo("Listar reservas por cliente");
                        Cliente cliente = null;
                        while (!resp4) {
                            String nombreUsuario = Helpers.validaciones("Nombre usuario", Helpers.VALIDAR_NOMBRE_USUARIO,
                                    "Error, comienza con numeros o letras y puede contener (._) minimo 8, maximo 20 caracteres");
                            cliente = accesoClientes.buscarCliente(nombreUsuario);
                            List<Reserva> reservasCliente = new ArrayList<>();
                            reservasCliente = buscarReservas(cliente);
                            listarReservas(reservasCliente);
                            resp4 = true;
                        }
                        break;
                    default:
                        System.out.println("Ingreso un dato Incorrecto. Reintente");
                }
            } catch (ClienteNoExiste clienteNoExiste) {
                System.err.println("No existe el username");

            } catch (InputMismatchException e) {
                getMenuGestionReservas();
            } catch (Exception e) {
                getMenuGestionReservas();
            }

        }
    }

    public void listarTodaslasReservas() {

        List<Reserva> reservas = null;
        boolean resp = false;
        int i = 0;

        try {

            reservas = accesoReservas.obtenerRegistros();

            for (int j = 0; j < reservas.size(); j++) {
                reservas.get(j).mostrar();
                resp = true;
            }

            if (!resp) {
                System.out.println("No hay reservas");
                System.out.println("");
            } else
                countReservas();
            System.out.println("Total: " + reservas.size());

        } catch (NullPointerException e) {

        } catch (Exception e) {

        }
    }

    public void listarReservasActivas() {

        List<Reserva> reservas = null;
        boolean resp = false;
        int i = 0;
        int countA = 0;

        try {

            reservas = accesoReservas.obtenerRegistros();
            for (Reserva x : reservas) {
                if ((x != null) && (x.isStatus())) {
                    x.mostrar();
                    countA++;
                    resp = true;
                }
            }

            if (!resp) {
                System.out.println("No hay reservas Activas");
            }

            System.out.println("Total: " + countA);

        } catch (NullPointerException e) {

        } catch (Exception e) {

        }

    }

    public void listarReservasNoActivas() {

        List<Reserva> reservas = null;
        boolean resp = false;
        int i = 0;
        int countD = 0;
        try {

            reservas = accesoReservas.obtenerRegistros();
            for (Reserva x : reservas) {
                if ((x != null) && (!x.isStatus())) {
                    x.mostrar();
                    countD++;
                    resp = true;

                }
            }
            if (!resp) {
                System.out.println("No hay reservas No Activas.");
            }
            System.out.println("Total: " + countD);

        } catch (NullPointerException e) {

        } catch (Exception e) {
        }
    }

    public void listarReservas(List<Reserva> reservas) {
        boolean resp = false;
        int count = 0;
        if (!reservas.isEmpty()) {
            for (Reserva x : reservas) {
                if (x != null) {
                    x.mostrar();
                    count++;
                    resp = true;
                }
            }
        }
        if (!resp) {
            System.out.println("No hay reservas");
            System.out.println("Total : " + count);
            System.out.println("");
        } else {

            System.out.println("Total : " + count);
        }
    }

    public void countReservas() {
        List<Reserva> reservas = null;
        boolean resp = false;
        int i = 0;
        int countA = 0;
        int countD = 0;
        try {

            reservas = accesoReservas.obtenerRegistros();
            for (Reserva x : reservas) {
                if ((x != null) && (x.isStatus())) {
                    countA++;
                } else
                    countD++;
            }
            System.out.println("Reservas Activas : " + countA);
            System.out.println("Reservas Inactivas : " + countD);

        } catch (NullPointerException e) {

        } catch (Exception e) {
        }
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

    // endregion

    // region Stock
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
                    menuAltaCliente();
                    break;
                case 2:
                    darDeBajaCliente();
                    break;
                case 3:
                    buscarCliente();
                    break;
                case 4:
                    listarClientes();
                    break;
                default:
                    Vista.opcionIncorrecta(seleccion);
                    break;

            }
        }

    }

    private void menuAltaCliente() {
        boolean resp = true;
        int opcion;

        while (resp) {
            Vista.titulo("Alta Cliente");
            System.out.println("1 Cliente existente");
            System.out.println("2 Crear nuevo cliente");
            System.out.println("0 Volver");
            opcion = Helpers.validarInt();
            switch (opcion) {
                case 0:
                    resp = false;
                    break;
                case 1:
                    darAltaClienteExistente();
                    break;
                case 2:
                    darAltaUnCliente();
                    break;
                default:
                    Vista.opcionIncorrecta(opcion);
            }
        }
    }

    private void getMenuCliente(Cliente cliente) {
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
                    dardeAltaUnaReserva(cliente);
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

    // region ABM
    private void darAltaClienteExistente() {
        Vista.ingreseDato("Ingrese id del cliente : ");
        String id = Helpers.nextLine();
        Cliente a = new Cliente();
        a.setId(id);
        a = this.accesoClientes.obtenerRegistro(a);
        if (a != null) {
            a.setEstado(true);
            this.accesoClientes.actualizarRegistro(a);
            System.out.println("El cliente fue dado de alta nuevamente");
        } else {
            System.out.println("El cliente no existe");
        }

    }

    public Cliente darAltaUnCliente() {
        Scanner entradaEscanner = new Scanner(System.in);
        Cliente cliente = null;
        List<Reserva> listaReservas = null;

        // Pedimos al usuario cliente el nombre y apellido
        System.out.print("\nIngrese el nombre del cliente: ");
        String nombre = entradaEscanner.next();
        System.out.print("\nIngrese el apellido del cliente: ");
        String apellido = entradaEscanner.next();

        // Validamos fecha de nacimiento
        boolean fechaNacimientoval = false;
        String fechadeNacimiento = null;
        System.out.println("Ingrese el nacimiento del cliente: dd/MM/yyyy ");
        String dia, mes, anio;
        LocalDate fecha4 = null;
        do {
            do {
                System.out.println("Dia: ");
                dia = entradaEscanner.next();
            } while (!validarDia(dia));

            do {
                System.out.println("Mes: ");
                mes = entradaEscanner.next();
            } while (!validarMes(mes));

            do {
                System.out.println("Año: ");
                anio = entradaEscanner.next();
                entradaEscanner.nextLine();
            } while (!validarAnio(anio));

            LocalDate fechaNacimiento = LocalDate.of(Integer.parseInt(anio), Integer.parseInt(mes),
                    Integer.parseInt(dia));
            if (fechaNacimiento.isBefore(LocalDate.now().minusYears(18))) {
                fechaNacimientoval = true;
                fechadeNacimiento = fechaNacimiento.toString();
            } else {
                System.out.println("No cumple con la edad minima para registrarse");
                System.out.println(fechaNacimiento.toString());
            }

        } while (!fechaNacimientoval);

        // Pedimos y validamos el telefono celular
        String telefono = "";
        do {
            System.out.println("\nIngrese numero de celular sin 0 ni 15");
            telefono = entradaEscanner.next();
            entradaEscanner.nextLine();
        } while (!Helpers.validarTel(telefono));

        // Pedimos y validamos la direccion.
        String direccion = null;

        do {
            System.out.println("\nIngrese la direccion: ");
            direccion = entradaEscanner.nextLine();
        } while (direccion == null);

        // Pedimos y validamos el dni que nos da el cliente.
        boolean respuest = false;
        String dniV = "";
        do {
            System.out.print("\nIngrese dni del cliente: ");
            dniV = entradaEscanner.next();
        } while (!Helpers.validarDni(dniV));

        // Pedimos y validamos el email que nos da el cliente.
        String email = null;
        do {
            System.out.println("\nIngrese el email del cliente: ");
            email = entradaEscanner.next();
            System.out.println(email);
        } while (!Helpers.validarEmail(email));

        // Guardamos y mostramos los datos a cargar como nuevo cliente
        cliente = new Cliente(email, dniV, email, nombre, apellido, fechadeNacimiento, telefono, direccion, dniV);

        System.out.println("Se agrego exitosamente el cliente");
        accesoClientes.agregarRegistro(cliente);

        return cliente;
    }

    public void buscarCliente() {
        Scanner escanner = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente a buscar: ");
        String dni = "";
        dni = escanner.next();
        Cliente aux = new Cliente(dni);
        Cliente g = this.accesoClientes.obtenerRegistroXDni(aux);
        if (g != null) {
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
        Cliente c = new Cliente();
        System.out.println("Ingrese id de cliente : ");
        c.setId(Helpers.nextLine());
        boolean a = accesoClientes.borrarRegistro(c);
        if (a == true) {
            System.out.println("El cliente se dio de baja");
        } else {
            System.out.println("El cliente no ha podido darse de baja.");
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
        // LocalDate fecha;
        while (resp) {
            Vista.titulo("Modificacion de datos personales");
            Vista.modificarInformacionPersonal();
            opc = Helpers.validarInt();
            switch (opc) {
                case 0:
                    resp = false;
                    break;
                case 1:
                    aux = Helpers.validaciones("nombre", Helpers.VALIDAR_NOMBRES,
                            "Tiene que empezar con mayusculas y se pueden ingresar hasta 2 nombres");
                    this.cliente.setNombre(aux);
                    break;
                case 2:
                    aux = Helpers.validaciones("apellido", Helpers.VALIDAR_NOMBRES,
                            "Tiene que empezar con mayusculas y se pueden ingresar hasta 2 nombres");
                    this.cliente.setApellido(aux);
                    break;
                case 3:
                    // fecha = Helpers.validarFecha();
                    // this.cliente.setFechaNacimiento(fecha);
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
        }
    }
    // endregion

    // endregion

}
