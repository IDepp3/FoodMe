package com.utn.teamA.clases;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.utn.teamA.ConexionDatos.AccesoClientes;
import com.utn.teamA.ConexionDatos.AccesoEmpleados;
import com.utn.teamA.ConexionDatos.AccesoReservas;
import com.utn.teamA.ConexionDatos.MenuPersistencia;
import com.utn.teamA.utils.Color;
import com.utn.teamA.utils.Helpers;
import com.utn.teamA.utils.Vista;

/**
 * Clase Empresa
 */

public class Empresa {

    // region ATRIBUTOS

    private String direccion;
    private Cliente cliente;
    private MenuLista menus;
    private PlatoLista platos;
    private IngredienteLista ingredientes;

    private AccesoClientes accesoClientes;
    private AccesoEmpleados accesoEmpleados;
    private AccesoReservas accesoReservas;

    // endregion

    // region Constructor

    public Empresa() {
        this.accesoClientes = new AccesoClientes();
        this.accesoEmpleados = new AccesoEmpleados();
        this.accesoReservas = new AccesoReservas();
        this.menus = new MenuLista();
        this.platos = new PlatoLista();
        this.ingredientes = new IngredienteLista();
    }

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
                            getMenuCliente();
                    } else
                        Vista.opcionIncorrecta("El usuario o contraseña es incorrecto");
                    break;
                case 2:
                    Vista.titulo("Registrarse");
                    this.cliente = registroUsuario();
                    if (this.accesoClientes.agregarRegistro(this.cliente))
                        Vista.opcionCorrecta("Usuario creado correctamente");
                    else
                        Vista.opcionIncorrecta("El usuario ya existe");
                    break;
                default:
                    Vista.opcionIncorrecta(opcion);
                    break;
            }
            this.cliente = null;
        }
        Vista.opcionCorrecta("Gracias por usar la aplicacion");
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
                Helpers.tipoCliente(), Helpers.estadoActivo());

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

    // region SECCION CLIENTE

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
                    this.menus.mostrarMenusActivos();
                    break;
                case 2:
                    if (this.cliente.getNombre() != null && this.cliente.getApellido() != null
                            && this.cliente.getTelefono() != null && this.cliente.getDni() != null
                            && this.cliente.getDireccion() != null && this.cliente.getEstado()) {
                        Reserva aux = dardeAltaUnaReserva(this.cliente);
                        List<String> aux2 = this.cliente.getReservas();
                        if (aux2 == null) {
                            aux2 = new ArrayList<String>();
                        }
                        aux2.add(aux.getId());
                        this.cliente.setReservas(aux2);
                        this.accesoClientes.actualizarRegistro(this.cliente);
                    } else
                        Vista.opcionIncorrecta("Complete su perfil antes de hacer una reserva");
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
                    Vista.informacionPersonalUsuario(this.cliente);
                    ;
                    Helpers.enterParaContinuar();
                    break;
                case 2:
                    menuModificarDatos();
                    break;
                case 3:
                    listarReservasCliente();
                    Helpers.enterParaContinuar();
                    break;
                default:
                    Vista.opcionIncorrecta(opcion);
                    break;
            }
        }
    }

    private void menuModificarDatos() {
        boolean resp = true;
        int opc;
        String aux = "";
        LocalDate fecha;
        while (resp) {
            Vista.titulo("Modificacion de datos personales");
            Vista.modificarInformacionPersonal();
            opc = Helpers.validarInt();
            switch (opc) {
                case 0:
                    resp = false;
                    break;
                case 1:
                    aux = Helpers.validaciones("Ingrese nombre", Helpers.VALIDAR_NOMBRES,
                            "Tiene que empezar con mayusculas y se pueden ingresar hasta 2 nombres");
                    this.cliente.setNombre(aux);
                    break;
                case 2:
                    aux = Helpers.validaciones("Ingrese apellido", Helpers.VALIDAR_NOMBRES,
                            "Tiene que empezar con mayusculas y se pueden ingresar hasta 2 nombres");
                    this.cliente.setApellido(aux);
                    break;
                case 3:
                    fecha = Helpers.validarFecha();
                    this.cliente.setFechaNacimiento(String.valueOf(fecha));
                    break;
                case 4:
                    aux = Helpers.validaciones("Ingrese telefono", Helpers.VALIDAR_TELEFONO,
                            "Coloque el numero sin 0 ni 15");
                    this.cliente.setTelefono(aux);
                    break;
                case 5:
                    Vista.ingreseDato("Ingrese una direccion");
                    aux = Helpers.nextLine();
                    this.cliente.setDireccion(aux);
                    break;
                case 6:
                    aux = Helpers.validaciones("Ingrese DNI", Helpers.VALIDAR_DNI, "Ingrese un dni valido");
                    this.cliente.setDni(aux);
                    break;
                case 7:
                    aux = Helpers.validaciones("Ingrese email", Helpers.VALIDAR_EMAIL, "Ingrese un email valido");
                    this.cliente.setEmail(aux);
                    break;
                case 8:
                    aux = passwordIguales();
                    this.cliente.setPassword(aux);
                    break;
                default:
                    Vista.opcionIncorrecta(opc);
                    break;
            }
        }
        if (this.accesoClientes.actualizarRegistro(this.cliente)) {
            Vista.opcionCorrecta("Perfil modificado correctamente");
            Helpers.enterParaContinuar();
        }
    }

    // endregion

    // region RESERVA CLIENTE

    public Reserva dardeAltaUnaReserva(Cliente cliente) {
        Reserva reserva = null;
        Scanner entradaEscanner2 = new Scanner(System.in);
        int cantidadPersonas;
        String seguir = "s";
        LocalDate fecha = null;
        Hora hora = new Hora();
        StringBuilder horarioLlegada = null;
        StringBuilder horarioInicio = null;
        StringBuilder horarioFinaliza = null;
        String menu;
        String descripcion;
        boolean quierebartender = false;
        Double costoTotal = 5000.0;

        Vista.titulo("Realizando reserva");

        while (seguir.equals("s")) {

            // Usuario ingresa fecha, valida que sea 48hs posterior al dia actual
            fecha = Helpers.validarFecha();

            Vista.deseaSeguirCargandoDatos();
            seguir = Helpers.nextLine();
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

            this.menus.mostrarMenusActivos();
            menu = this.menus.agregarMenuReserva();

            Vista.deseaSeguirCargandoDatos();
            seguir = entradaEscanner2.nextLine();
            if (seguir.equals("n"))
                break;

            cantidadPersonas = Integer.parseInt(
                    Helpers.validaciones("Ingrese cantidad de personas", Helpers.VALIDAR_ENTEROS, "Dato incorrecto"));
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
            MenuPersistencia men = new MenuPersistencia();
            Menu aux = new Menu();
            aux.setId(menu);
            Menu m = men.obtenerRegistro(aux);
            costoTotal = calcularTotal(cantidadPersonas, m.getPrecio(), quierebartender);
            reserva = new Reserva(Helpers.generarID(), Helpers.fechaActual(), fecha.toString(), this.cliente.getId(),
                    horarioLlegada, horarioInicio, horarioFinaliza, menu, descripcion, costoTotal, quierebartender,
                    true, cantidadPersonas, costoTotal);

            Vista.verReservaToString(reserva);

            Vista.finalizarReserva();
            seguir = entradaEscanner2.nextLine();
            if (seguir.equals("n"))
                break;

            // El sistema guarda en el archivo en formato json
            // accesoReservas.mostrar(reserva);

            accesoReservas.agregarRegistro(reserva);

            Vista.opcionCorrecta("La reserva se cargo con exito");

            seguir = "n";
        }

        return reserva;
    }

    private double calcularTotal(int cantidadPersonas, double precioMenu, boolean bartender) {
        double total = 0;

        total = precioMenu * cantidadPersonas;
        if (bartender) {
            total += TipoEmpleado.BARTENDER.sueldo;
        }

        return total;
    }

    private void listarReservasCliente() {
        boolean resp = true;
        List<String> reservasCliente = this.cliente.getReservas();
        if (this.cliente.getReservas() != null) {
            int j = 0;
            List<Reserva> reservas = this.accesoReservas.obtenerRegistros();
            for (int i = 0; i < reservasCliente.size(); i++) {
                Reserva reserva = new Reserva(reservasCliente.get(i));
                while (resp && j < reservas.size()) {
                    if (reserva.equals(reservas.get(j))) {
                        Vista.verReservaToString(reservas.get(j));
                        resp = false;
                    }
                    j++;
                }
                resp = true;
            }
        } else
            Vista.opcionIncorrecta("Todavia no realizaste ninguna reserva");
    }

    // endregion

    // region Menu Administrador

    private void getMenuAdministrador() {
        boolean resp = true;
        int seleccion;
        while (resp) {
            Vista.titulo("Menu Administrador");
            Vista.titulo("Bienvenido " + this.cliente.getUsername());
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
                    getMenuGestionClientes();
                    break;
                case 4:
                    menus.menuMenu();
                    break;
                case 5:
                    platos.platoMenu();
                    break;
                case 6:
                    ingredientes.ingredienteMenu();
                    break;
                default:
                    Vista.opcionIncorrecta(seleccion);
            }
        }
    }

    // region gestion cliente admin

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
                    Vista.titulo("Lista de Clientes");
                    listarClientes();
                    Helpers.enterParaContinuar();
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
            Vista.menuGestionCliente();
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

    // region ABM
    private void darAltaClienteExistente() {
        Vista.ingreseDato("Ingrese id del cliente");
        String id = Helpers.nextLine();
        Cliente a = new Cliente();
        a.setId(id);
        a = this.accesoClientes.obtenerRegistro(a);
        if (a != null) {
            a.setEstado(true);
            this.accesoClientes.actualizarRegistro(a);
            Vista.opcionCorrecta("El cliente fue dado de alta nuevamente");
        } else {
            Vista.opcionIncorrecta("El cliente no existe");
        }

    }

    public Cliente darAltaUnCliente() {
        Scanner entradaEscanner = new Scanner(System.in);
        Cliente cliente = null;
        Vista.titulo("Creando Cliente");
        // Pedimos al usuario cliente el nombre y apellido
        Vista.ingreseDato("Ingrese el nombre del cliente");
        String nombre = entradaEscanner.next();
        Vista.ingreseDato("Ingrese el apellido del cliente");
        String apellido = entradaEscanner.next();

        Vista.ingreseDato("Ingrese el nacimiento del cliente: dd/MM/yyyy");
        System.out.println("");

        LocalDate fecha4 = Helpers.validarFecha();

        // Pedimos y validamos el telefono celular
        String telefono = "";
        do {
            Vista.ingreseDato("Ingrese numero de celular (sin 0 ni 15)");
            telefono = entradaEscanner.next();
            entradaEscanner.nextLine();
        } while (!Helpers.validarTel(telefono));

        // Pedimos y validamos la direccion.
        String direccion = null;

        do {
            Vista.ingreseDato("Ingrese la direccion");
            direccion = entradaEscanner.nextLine();
        } while (direccion == null);

        // Pedimos y validamos el dni que nos da el cliente.
        String dniV = "";
        do {
            Vista.ingreseDato("Ingrese dni del cliente");
            dniV = entradaEscanner.next();
        } while (!Helpers.validarDni(dniV));

        // Pedimos y validamos el email que nos da el cliente.
        String email = null;
        do {
            Vista.ingreseDato("Ingrese el email del cliente");
            email = entradaEscanner.next();
        } while (!Helpers.validarEmail(email));

        // Guardamos y mostramos los datos a cargar como nuevo cliente
        cliente = new Cliente(null, null, email, nombre, apellido, fecha4.toString(), telefono, direccion, dniV);

        Vista.opcionCorrecta("Se agrego exitosamente el cliente");
        this.accesoClientes.agregarRegistro(cliente);

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
        if (listaClientes != null) {
            for (Cliente c : listaClientes) {
                Vista.informacionPersonalUsuario(c);
            }
        }
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

    // endregion

    public void menuAltaEmpleado() {
        boolean resp = true;
        int opcion;

        while (resp) {
            Vista.titulo("Alta Empleado");
            Vista.vistaEleccionCrearEmpleado();
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
            Vista.opcionCorrecta("El empleado fue dado de alta nuevamente");
        } else {
            Vista.opcionIncorrecta("El empleado no existe");
        }

    }

    // region ABM Personal
    public void darAltaUnEmpleado() {
        Scanner entradaEscanner = new Scanner(System.in);
        Empleado empleado = null;
        String tipo = "";
        double sueldo = 0;

        Vista.titulo("Datos empleado");

        boolean respuestaNombre = false;

        String nombre = "";

        while (respuestaNombre == false) {

           
            Vista.ingreseDato("Ingrese nombre");
            nombre = Helpers.nextLine();
            // Validamos el nombre que nos brinda el cliente.
            respuestaNombre = Helpers.validarNombre(nombre);

        }

        boolean respuestaApellido = false;

        String apellido = "";

        while (respuestaApellido == false) {

            
            Vista.ingreseDato("Ingrese apellido");
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
                
                Vista.ingreseDato("Fecha nacimiento");
                System.out.println("");
               
                Vista.ingreseDato("Ingrese dia");
                dia = entradaEscanner.nextInt();
               
                Vista.ingreseDato("Ingrese mes");
                mes = entradaEscanner.nextInt();
                
                Vista.ingreseDato("Ingrese año");
                anio = entradaEscanner.nextInt();
                fecha = LocalDate.of(anio, mes, dia);
                respuestaFecha = true;
            } catch (DateTimeException e) {
              
                Vista.opcionIncorrecta("La fecha ingresada es incorrecta");
            }
        }
        String telefono = "";

        boolean respuesta = false;
        while (respuesta == false) {

          
            Vista.ingreseDato("Ingrese numero de celular (sin 0 ni 15)");
            telefono = Helpers.nextLine();
            // Validamos el dni que nos da el cliente.
            respuesta = Helpers.validarTel(telefono);

        }

        String dni = "";

        
        Vista.ingreseDato("Ingrese direccion");
        direccion = Helpers.nextLine();

        boolean respuestaDni = false;

        while (respuestaDni == false) {
            
            Vista.ingreseDato("Ingrese DNI");
            dni = Helpers.nextLine();

            // Validamos el dni que nos da el cliente.
            respuestaDni = Helpers.validarDni(dni);
        }

        // Estado del Empleado
        boolean estado = true;
        boolean respuestaEmail = false;

        String email = "";

        while (respuestaEmail == false) {

            
            Vista.ingreseDato("Ingrese email");
            email = Helpers.nextLine();
            // Validamos el email que nos da el cliente.
            respuestaEmail = Helpers.validarEmail(email);
        }

        Vista.ingreseDato("TIPO EMPLEADO");
        
        Vista.ingreseDato("4 - MOZO | 5 - BARTENDER | 6 - SUSHIMAN");
        @SuppressWarnings("resource")
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
                Vista.opcionIncorrecta("Opcion incorrecta");
        }

        Vista.ingreseDato("Ingrese sueldo del empleado");

        sueldo = entradaEscanner.nextDouble();

        empleado = new Empleado(nombre, apellido, fecha.toString(), telefono, direccion, dni, email, tipo, sueldo,
                estado);
        Vista.opcionCorrecta("El empleado se agrego exitosamente");
        accesoEmpleados.agregarRegistro(empleado);

    }

    // Damos de baja un empleado, el cual buscamos por Dni, en caso
    // de encontrarlo, su atributo estado pasara de Activo a Inactivo.
    public void darDeBaja() {

        Vista.ingreseDato("Ingrese el dni del empleado");
        Empleado h = new Empleado();
        @SuppressWarnings("resource")
        Scanner s = new Scanner(System.in);
        String dni = s.next();

        h.setDni(dni);
        boolean a = accesoEmpleados.borrarRegistro(h);
        if (a == true) {
         
            Vista.opcionCorrecta("El empleado con dni " + dni + " fue dado de baja");
            h.setEstado(false);
            h.toString();
        } else {
            Vista.opcionIncorrecta("No hay empleados con el dni ingresado.");
        }
    }

    // Buscamos un empleado mediante el Dni del mismo, en caso
    // de encontrarlo dira que fue encontrado.

    public void buscarEmpleado() {
        Scanner escanner = new Scanner(System.in);

        Vista.ingreseDato("Ingrese el dni del empleado a buscar");
        String dni = "";
        dni = escanner.next();
        Empleado g = new Empleado();
        g.setDni(dni);
        if (accesoEmpleados.obtenerRegistro(g) != null) {
            g = accesoEmpleados.obtenerRegistro(g);

            Vista.opcionCorrecta("Cliente encontrado");
            Vista.listarEmpleado(g);
        } else {
            
            Vista.opcionIncorrecta("No hay empleados con el dni ingresado");
        }
    }

    public void listarEmpleados() {
        List<Empleado> listaEmpleado = null;
        listaEmpleado = accesoEmpleados.obtenerRegistros();
        if (listaEmpleado != null) {
            for (Empleado e : listaEmpleado) {
                Vista.listarEmpleado(e);
            }
        }
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
                    
                        Vista.titulo(" BAJA UNA RESERVA.");
                        darDeBajaReserva();
                    
                        break;
                    case 2:
                        Vista.titulo("LISTAR RESERVAS");
                        listarReservasAdministrador();
                        Helpers.enterParaContinuar();
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

    private void listarReservasAdministrador() {
        List<Reserva> reservas = this.accesoReservas.obtenerRegistros();
        if (reservas != null) {
            for (Reserva r : reservas) {
                Vista.verReservaToString(r);
            }
        }
    }

    private void darDeBajaReserva() {
        Vista.ingreseDato("Ingrese id de reserva que desea dar de baja");
        String id = Helpers.nextLine();
        Reserva r = this.accesoReservas.obtenerRegistro(new Reserva(id));

        if (r != null) {
            r.setStatus(false);
            if (this.accesoReservas.actualizarRegistro(r)){
                Vista.opcionCorrecta("La reserva fue dada de baja");
            }
            
        } else
            Vista.opcionIncorrecta("La reserva que busca no existe");
    }

    // region Alta Como Admin

    /*
     * private LocalDate elegirFechaDeEvento() {
     * 
     * LocalDate fecha = null; Scanner entradaEscanner = new Scanner(System.in);
     * String f = ""; String si = "s"; boolean validar = false; boolean
     * disponibilidad = false; while (si.equals("s")) { try { String mes = null;
     * String anio = null; String dia = null;
     * 
     * do {
     * 
     * LocalDate fechatentativa = validarfecha(); validar =
     * verificarFechaValida(fechatentativa);
     * 
     * disponibilidad =
     * accesoReservas.verificarFechaDeEventoDisponible(fechatentativa.toString());
     * 
     * if (disponibilidad) { Vista.opcionCorrecta("Fecha disponible"); fecha =
     * fechatentativa; } else { System.err.println("Fecha No Disponible"); }
     * 
     * Vista.deseaSeguirCargandoFechas(); si = entradaEscanner.next();
     * 
     * } while (((!validar) && (!disponibilidad)) || (si.equals("s")));
     * 
     * } catch (FechaNoDisponible e) { System.err.println("Fecha no disponible");
     * Vista.deseaSeguirCargandoFechas(); si = entradaEscanner.next(); } catch
     * (FechaInvalidaException e) { System.err.println("Fecha Invalida");
     * Vista.deseaSeguirCargandoFechas(); si = entradaEscanner.next();
     * 
     * } catch (NullPointerException e) {
     * System.err.println("No hay registros aun"); } catch (Exception e) {
     * System.err.println("Error. Fecha invalida"); elegirFechaDeEvento(); }
     * 
     * } return fecha;
     * 
     * }
     */

    // region ALTA RESERVA
    /*
     * public Reserva darAltaReservas() throws FechaInvalidaException {
     * 
     * Scanner entradaEscanner2 = new Scanner(System.in); int ope = 1; String seguir
     * = "s"; LocalDate fecha = null; Hora hora = new Hora(); StringBuilder
     * horarioLlegada = null; StringBuilder horarioInicio = null; StringBuilder
     * horarioFinaliza = null; List<Menu> menus; String descripcion; boolean
     * quierebartender; String idCliente = null;
     * 
     * while (seguir.equals("s")) {
     * 
     * // USUARIO INGRESA FECHA, VALIDA QUE SEA 48 HRS ANTES DEL EVENTO do {
     * fecha = elegirFechaDeEvento(); //System.out.println(fecha.toString()); }
     * while (!verificarFechaValida(fecha)); DateTimeFormatter formatter =
     * DateTimeFormatter.ofPattern("dd/MM/yyyy"); String fecha3 = fecha.toString();
     * Vista.deseaSeguirCargandoDatos(); seguir = entradaEscanner2.nextLine(); if
     * (seguir.equals("n")) break;
     * 
     * // Usuario ingresa la hora y minutos en el que empieza el evento. // calcula
     * horarios de llegada y finalizacion System.out.println(Color.ANSI_BLUE + " 1 "
     * + Color.ANSI_RESET + "Ingrese hora de inicio del Evento"); String aviso =
     * "Acordate que nuestro servivio dura entre: 3.5-4 hs. Llegamos entre: 3-4 hs antes. Finalizamos: 3-4 hs despues. FOODME.CO "
     * ; System.out.println(aviso); hora.init(); horarioLlegada =
     * hora.calcularLlegada(3); horarioInicio = hora.setearHoraInicio();
     * horarioFinaliza = hora.calcularFinalizacion(4); // todo constante de horas de
     * servicio Vista.deseaSeguirCargandoDatos(); seguir =
     * entradaEscanner2.nextLine(); if (seguir.equals("n")) break;
     * 
     * // Usuario ingresa Cliente:el sistema dirige al menu cliente en donde puede
     * buscar o // dar alta un cliente. Se captura el id cliente variable
     * System.out.println(Color.ANSI_BLUE + " 2 " + Color.ANSI_RESET +
     * "Seleccione el Cliente "); idCliente = reserevaIngresarCliente();
     * System.out.println("Id Cliente :" + idCliente);
     * 
     * Vista.deseaSeguirCargandoDatos(); seguir = entradaEscanner2.nextLine(); if
     * (seguir.equals("n")) break;
     * 
     * // Usuario selecciona Los tipo de Menu, cantidad de personas por menu e //
     * ingredientes System.out.println(Color.ANSI_BLUE + " 3 " + Color.ANSI_RESET +
     * "Seleccione los Menus "); System.out.println(Color.ANSI_BLUE + "  "); //
     * traer lista de menus y sus ingredientes menus = seleccionarMenus();
     * Vista.deseaSeguirCargandoDatos(); seguir = entradaEscanner2.nextLine(); if
     * (seguir.equals("n")) break;
     * 
     * // Usuario Ingresa si quiere bartender como servicio
     * System.out.println(Color.ANSI_BLUE + " 5- " + Color.ANSI_RESET +
     * "Quiere Bartender?s/n"); String op = entradaEscanner2.nextLine();
     * quierebartender = op.equals("s");
     * 
     * // Usuario ingresa descripcion en la reserva. detalles preguntas de servicio
     * // etc. System.out.println(Color.ANSI_BLUE + " 4- " + Color.ANSI_RESET +
     * "Ingrese descripcion"); descripcion = entradaEscanner2.nextLine(); if
     * (seguir.equals("n")) break; Vista.deseaSeguirCargandoDatos(); seguir =
     * entradaEscanner2.nextLine(); if (seguir.equals("n")) break;
     * 
     * Vista.opcionCorrecta("Finalizo cargar su reserva");
     * 
     * Reserva reserva = new Reserva(fecha3, idCliente, horarioLlegada,
     * horarioInicio, horarioFinaliza, menus, descripcion, quierebartender);
     * 
     * // El sistema inicializa el objeto // Reserva reserva = new
     * Reserva(fechaAString, horarioLlegada, horarioInicio, // horarioFinaliza,
     * idCliente, menus, descripcion, quierebartender);
     * 
     * // Calcula costoTotal + servicio(mano de obra) en funcion a la cantidad de //
     * personas reserva.setCostoTotal(1000.0); //
     * reserva.setCosto(reserva.calcularCosto());
     * 
     * // Calcula Precio Final = a costo + IVA (si el cliente paga en efectivo) con
     * una // rentabilidad del 25% reserva.calcularPrecionFinal();
     * 
     * System.out.println("Costo:" + reserva.getCostoTotal());
     * System.out.println("Precio Final:" + reserva.getPrecioFinal());
     * 
     * reserva.mostrar();
     * 
     * Vista.finalizarReserva(); seguir = entradaEscanner2.nextLine(); if
     * (seguir.equals("n")) break;
     * 
     * // El sistema guarda en el archivo en formato json
     * accesoReservas.mostrar(reserva);
     * 
     * boolean a = accesoReservas.agregarRegistro(reserva);
     * 
     * Vista.opcionCorrecta("La reserva se cargo con exito");
     * 
     * seguir = "n"; } return reserva; }
     */

    // endregion

    // Alta Reserva Como cliente
    /*
     * public void dardeAltaUnaReserva(Cliente cliente) {
     * 
     * Scanner entradaEscanner2 = new Scanner(System.in); int ope = 1; String seguir
     * = "s"; LocalDate fecha = null; Hora hora = new Hora(); StringBuilder
     * horarioLlegada = null; StringBuilder horarioInicio = null; StringBuilder
     * horarioFinaliza = null; List<Menu> menus; String descripcion; boolean
     * quierebartender; String idCliente2 = null;
     * 
     * String otro = "";
     * 
     * while (seguir.equals("s")) {
     * 
     * // Usuario ingresa fecha, valida que sea 48hs posterior al dia actual try {
     * fecha = elegirFechaDeEvento(); //System.out.println(fecha.toString()); }
     * catch (Exception e) { System.err.println("Fecha invalida"); }
     * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
     * String fecha3 = fecha.toString();
     * 
     * Vista.deseaSeguirCargandoDatos(); seguir = entradaEscanner2.nextLine(); if
     * (seguir.equals("n")) break;
     * 
     * // Usuario ingresa la hora y minutos en el que empieza el evento. // calcula
     * horarios de llegada y finalizacion System.out.println(Color.ANSI_BLUE + " 1 "
     * + Color.ANSI_RESET + "Ingrese hora de inicio del Evento"); String aviso =
     * "Acordate que nuestro servivio dura entre: 3.5-4 hs. Llegamos entre: 3-4 hs antes. Finalizamos: 3-4 hs despues. FOODME.CO "
     * ; System.out.println(aviso); hora.init(); horarioLlegada =
     * hora.calcularLlegada(3); horarioInicio = hora.setearHoraInicio();
     * horarioFinaliza = hora.calcularFinalizacion(4); // todo constante de horas de
     * servicio Vista.deseaSeguirCargandoDatos(); seguir =
     * entradaEscanner2.nextLine(); if (seguir.equals("n")) break;
     * 
     * // Usuario ingresa Cliente/ lo dirige al menu cliente en donde puede buscar
     * // al cliente o darlo de alta. se guarda el id del cliente idCliente2 =
     * cliente.getId();
     * 
     * // Usuario selecciona Los tipo de Menu, cantidad de personas por menu e //
     * ingredientes System.out.println(Color.ANSI_BLUE + " 3 " + Color.ANSI_RESET +
     * "Seleccione los Menus "); // traer lista de menus y sus ingredientes menus =
     * seleccionarMenus(); Vista.deseaSeguirCargandoDatos(); seguir =
     * entradaEscanner2.nextLine(); if (seguir.equals("n")) break;
     * 
     * // Usuario Ingresa si quiere bartender como servicio
     * System.out.println(Color.ANSI_BLUE + " 5- " + Color.ANSI_RESET +
     * "Quiere Bartender?s/n"); String op = entradaEscanner2.nextLine();
     * quierebartender = op.equals("s");
     * 
     * // Usuario ingresa descripcion en la reserva. detalles preguntas de servicio
     * // etc. System.out.println(Color.ANSI_BLUE + " 4- " + Color.ANSI_RESET +
     * "Ingrese descripcion"); descripcion = entradaEscanner2.nextLine(); if
     * (seguir.equals("n")) break; Vista.deseaSeguirCargandoDatos(); seguir =
     * entradaEscanner2.nextLine(); if (seguir.equals("n")) break;
     * 
     * Vista.opcionCorrecta("Finalizo cargar su reserva");
     * 
     * Reserva reserva = new Reserva(fecha3, idCliente2, horarioLlegada,
     * horarioInicio, horarioFinaliza, menus, descripcion, quierebartender);
     * reserva.mostrar();
     * 
     * // El sistema inicializa el objeto // Reserva reserva = new
     * Reserva(fechaAString, horarioLlegada, horarioInicio, // horarioFinaliza,
     * idCliente, menus, descripcion, quierebartender);
     * 
     * // Calcula costoTotal + servicio(mano de obra) en funcion a la cantidad de //
     * personas reserva.setCostoTotal(100.0); //
     * reserva.setCosto(reserva.calcularCosto());//todo Antonela1
     * 
     * // Calcula Precio Final = a costo + IVA (si el cliente paga en efectivo) con
     * una // rentabilidad del 25% reserva.calcularPrecionFinal();
     * 
     * System.out.println("Costo:" + reserva.getCostoTotal());
     * System.out.println("Precio Final:" + reserva.getPrecioFinal());
     * 
     * Vista.finalizarReserva(); seguir = entradaEscanner2.nextLine(); if
     * (seguir.equals("n")) break;
     * 
     * // El sistema guarda en el archivo en formato json
     * accesoReservas.mostrar(reserva);
     * 
     * boolean a = accesoReservas.agregarRegistro(reserva);
     * 
     * Vista.opcionCorrecta("La reserva se cargo con exito");
     * 
     * seguir = "n"; }
     * 
     * }
     */

    /*
     * private String reserevaIngresarCliente() { Scanner entradaEscanner2 = new
     * Scanner(System.in);
     * 
     * String dni = null; Cliente clienteRegistrado = null; String idCliente = null;
     * 
     * do {
     * 
     * try {
     * 
     * boolean resp = true; int opt = 0;
     * 
     * 
     * while (resp) {
     * 
     * System.out.println("");
     * 
     * System.out.println("1- Alta cliente");
     * System.out.println("2- Buscar Cliente por Username");
     * System.out.println("0- Guardar"); opt = entradaEscanner2.nextInt();
     * 
     * entradaEscanner2.nextLine();
     * 
     * switch (opt) { case 0: resp = false; break; case 1:
     * Vista.titulo("Alta Cliente"); Cliente cliente = darAltaUnCliente();
     * idCliente= cliente.getId(); cliente.mostrar(); break; case 2:
     * Vista.titulo("Buscar Cliente"); idCliente = buscarClienteR(); break;
     * 
     * default: System.err.println("Dato incorrecto. Reintente"); break; } }
     * 
     * } catch (Exception e) {
     * 
     * }
     * 
     * } while (idCliente == null);
     * 
     * return idCliente; }
     * 
     * public String buscarClienteR(){ String idCliente = null; Cliente
     * clienteRegistrado = null; String dni3 = null; String idclienteRegistrado =
     * null; Scanner entradaEscanner2 = new Scanner(System.in); try {
     * 
     * String nombreUsuario = Helpers.validaciones("Nombre usuario",
     * Helpers.VALIDAR_NOMBRE_USUARIO,
     * "Error, comienza con numeros o letras y puede contener (._) minimo 8, maximo 20 caracteres"
     * );
     * 
     * clienteRegistrado = accesoClientes.obtenerRegistroXDni(new
     * Cliente(nombreUsuario)); clienteRegistrado.mostrar(); idCliente =
     * clienteRegistrado.getId();
     * 
     * 
     * }catch (NullPointerException e){ System.err.println("No existe el cliente");
     * buscarClienteR(); } return idCliente; }
     * 
     * private boolean validarDia(String dia) {
     * 
     * if (dia.length() != 2) // Comprobamos que son dos caracteres
     * 
     * return false;
     * 
     * else { // Y que es un valor numérico, entre 0 y 31
     * 
     * try {
     * 
     * int dd = Integer.parseInt(dia);
     * 
     * return (dd > 0 && dd < 31);
     * 
     * }
     * 
     * catch (NumberFormatException e) {
     * 
     * return false; // No se ha tecleado un valor numérico
     * 
     * }
     * 
     * }
     * 
     * }
     * 
     * private boolean validarMes(String mes) {
     * 
     * if (mes.length() != 2)
     * 
     * return false;
     * 
     * else {
     * 
     * try {
     * 
     * int mm = Integer.parseInt(mes);
     * 
     * return (mm > 0 && mm < 13);
     * 
     * } catch (NumberFormatException e) {
     * 
     * return false;
     * 
     * }
     * 
     * }
     * 
     * }
     * 
     * private boolean validarAnio(String anio) {
     * 
     * if (anio.length() != 4)
     * 
     * return false;
     * 
     * else {
     * 
     * try {
     * 
     * int aaaa = Integer.parseInt(anio);
     * 
     * return (aaaa != 0); // Aquí depende de que fechas queremos aceptar
     * 
     * } catch (NumberFormatException e) {
     * 
     * return false;
     * 
     * }
     * 
     * }
     * 
     * }
     */

    /*
     * private LocalDate elegirFechaDeEvento() {
     * 
     * LocalDate fecha = null; Scanner entradaEscanner = new Scanner(System.in);
     * String f = ""; String si = "s"; boolean validar = false; boolean
     * disponibilidad = false; while (si.equals("s")) { try { String mes = null;
     * String anio = null; String dia = null;
     * 
     * do {
     * 
     * LocalDate fechatentativa = validarfecha(); validar =
     * verificarFechaValida(fechatentativa);
     * 
     * disponibilidad =
     * accesoReservas.verificarFechaDeEventoDisponible(fechatentativa.toString());
     * 
     * if (disponibilidad) { Vista.opcionCorrecta("Fecha disponible"); fecha =
     * fechatentativa; } else { System.err.println("Fecha No Disponible"); }
     * 
     * Vista.deseaSeguirCargandoFechas(); si = entradaEscanner.next();
     * 
     * } while (((!validar) && (!disponibilidad)) || (si.equals("s")));
     * 
     * } catch (FechaNoDisponible e) { System.err.println("Fecha no disponible");
     * Vista.deseaSeguirCargandoFechas(); si = entradaEscanner.next(); } catch
     * (FechaInvalidaException e) { System.err.println("Fecha Invalida");
     * Vista.deseaSeguirCargandoFechas(); si = entradaEscanner.next();
     * 
     * } catch (NullPointerException e) {
     * System.err.println("No hay registros aun"); } catch (Exception e) {
     * System.err.println("Error. Fecha invalida"); elegirFechaDeEvento(); }
     * 
     * } return fecha;
     * 
     * }
     */

    /*
     * public boolean verificarFechaValida(LocalDate fechaVali) throws
     * FechaInvalidaException {
     * 
     * boolean fechaValida = false;
     * 
     * if ((fechaVali.isAfter(LocalDate.now().plusDays(2)))) { fechaValida = true; }
     * else { throw new FechaInvalidaException("Fecha Invalida"); }
     * 
     * return fechaValida;
     * 
     * }
     */

    /*
     * public List<Menu> seleccionarMenus() {
     * 
     * Scanner entrada = new Scanner(System.in); int op = 0; boolean resp = true;
     * List<Menu> menus = new ArrayList<>();
     * 
     * try {
     * 
     * while (resp) {
     * 
     * Vista.darAltaReservaSeleccionarMenu(); op = entrada.nextInt();
     * 
     * switch (op) { case 0: resp = false; break; case 1: Vista.titulo("CLASICO");
     * Menu a = new Menu(); menus.add(modificarMenu(a)); break; case 2:
     * Vista.titulo("VEGANO"); Menu b = new Menu(); menus.add(modificarMenu(b));
     * break; case 3: Vista.titulo("VEGETARIANO"); Menu c = new Menu();
     * menus.add(modificarMenu(c)); break; case 4: Vista.titulo("DIABETICO"); Menu d
     * = new Menu(); menus.add(modificarMenu(d)); break; default:
     * System.err.println("Dato Incorrecto. Reintente."); } } } catch
     * (InputMismatchException e) { seleccionarMenus(); } catch (Exception e) {
     * seleccionarMenus(); }
     * 
     * return menus; }
     */

    /*
     * public Menu modificarMenu(Menu menu) {
     * 
     * boolean resp = true; Scanner entrada = new Scanner(System.in); int op = 0;
     * 
     * try {
     * 
     * while (resp) {
     * 
     * Vista.sleccionarMenuAltaReserva(); // trear ingredientes Todo trear
     * Ingredientes al cargar una reserva
     * 
     * op = entrada.nextInt();
     * 
     * switch (op) { case 0: resp = false; break; case 1: System.out
     * .println(Color.ANSI_BLUE + " 1- " + Color.ANSI_RESET +
     * "Ingrese cantidad de Personas"); int cantidadPer = entrada.nextInt();
     * entrada.nextLine(); menu.setCantPersonas(cantidadPer);
     * System.out.println("Cantidad = " + menu.getCantPersonas()); break; case 2:
     * System.out.println(Color.ANSI_BLUE + " 2- " + Color.ANSI_RESET +
     * "Eliminar ingrediente"); break; case 3: System.out.println( Color.ANSI_BLUE +
     * " 3- " + Color.ANSI_RESET + "Modificar algun ingrediente del menu"); break;
     * default: }
     * 
     * } } catch (NullPointerException e) {
     * 
     * } catch (InputMismatchException e) { seleccionarMenus(); } catch (Exception
     * e) { seleccionarMenus(); } finally {
     * 
     * return menu; }
     * 
     * }
     */

    // endregion

    // region Baja

    /*
     * public void darBajaReservas() { List<Reserva> reservasCliente = new
     * ArrayList<>(); Reserva reserva = null; Scanner scanner = new
     * Scanner(System.in); int op = 0; boolean resp = true; try {
     * 
     * while (resp == true) {
     * 
     * Vista.darBajaReservas(); op = scanner.nextInt(); scanner.nextLine();
     * 
     * switch (op) { case 0: resp = false; break; case 1:
     * System.out.println(Color.ANSI_BLUE + " 1- " + Color.ANSI_RESET +
     * "Ingrese el Id de la resreva a borrar"); String idReserva = scanner.next();
     * reserva = buscarReserva(idReserva);// esto despues lo puedo borraar boolean
     * reservaBajaId = darBajaReserva(reserva);
     * 
     * break; case 2:
     * 
     * LocalDate fechaLD = validarfecha(); reserva = buscarReserva(fechaLD);
     * reserva.mostrar(); boolean reservaBajaFecha = darBajaReserva(reserva); if
     * (reservaBajaFecha) { System.out.println("Reserva Cancelada");
     * buscarReserva(fechaLD).mostrar(); } break; case 3:
     * 
     * boolean resp4 = false; List<Reserva> reservasClientefechas = new
     * ArrayList<>(); Cliente cliente = null;
     * 
     * System.out.println(Color.ANSI_BLUE + " 3 " + Color.ANSI_RESET +
     * "Dar de baja  por Cliente");
     * 
     * while (!resp4) { String username = Helpers.validaciones("Nombre usuario",
     * Helpers.VALIDAR_NOMBRE_USUARIO,
     * "Error, comienza con numeros o letras y puede contener (._) minimo 8, maximo 20 caracteres"
     * ); cliente = accesoClientes.buscarCliente(username); reservasClientefechas =
     * buscarReservas(cliente); listarReservas(reservasClientefechas); resp4 = true;
     * }
     * 
     * if (!reservasClientefechas.isEmpty()) { System.out.println(Color.ANSI_BLUE +
     * " 1- " + Color.ANSI_RESET + "Ingrese el Id de la reserva a borrar"); String
     * idReserva2 = scanner.next(); reserva = buscarReserva(idReserva2); boolean
     * reservaBajaId2 = darBajaReserva(reserva); reserva =
     * buscarReserva(idReserva2); reserva.mostrar(); } break; default:
     * System.err.println("Ingreso un dato incorrecto. Reintente"); break;
     * 
     * } } }catch (NoExisteReserva e) { System.err.println("No existen reservas");
     * }catch (ClienteNoExiste clienteNoExiste) {
     * System.err.println("No existe el cliente"); } catch (NullPointerException e)
     * {
     * 
     * darBajaReservas();
     * 
     * } catch (InputMismatchException e) {
     * 
     * darBajaReservas();
     * 
     * } catch (Exception e) {
     * 
     * darBajaReservas();
     * 
     * }
     * 
     * }
     */

    /*
     * public boolean darBajaReserva(Reserva reserva) { boolean reservaEliminada =
     * false; try { if (reserva.isStatus()) { reservaEliminada =
     * accesoReservas.borrarRegistro(reserva); } else {
     * System.out.println("Ya se encuentra cancelada"); } } catch
     * (NullPointerException e) {
     * 
     * System.err.println("No hay reservas con ese campo");
     * 
     * } catch (Exception e) {
     * 
     * }
     * 
     * return reservaEliminada; }
     */

    /*
     * public LocalDate validarfecha(){ Scanner entradaEscanner = new
     * Scanner(System.in); String dia,mes,anio; System.out.println(Color.ANSI_BLUE +
     * " 1- " + Color.ANSI_RESET + "Ingrese fecha del evento: dd/MM/yyyy");
     * 
     * do { System.out.println("Dia: "); dia = entradaEscanner.next(); } while
     * (!validarDia(dia));
     * 
     * do { System.out.println("Mes: "); mes = entradaEscanner.next(); } while
     * (!validarMes(mes));
     * 
     * do { System.out.println("Año: "); anio = entradaEscanner.next();
     * entradaEscanner.nextLine(); } while (!validarAnio(anio));
     * 
     * LocalDate fechatentativa = LocalDate.of(Integer.parseInt(anio),
     * Integer.parseInt(mes), Integer.parseInt(dia));
     * 
     * return fechatentativa; }
     */
    // endregion

    // region Modificar

    /*
     * public void modificarReservas() {
     * 
     * List<Reserva> reservaM = null; Scanner scanner = new Scanner(System.in); int
     * op = 0; boolean resp = true; Vista.titulo("MODIFICAR RESERVA"); try {
     * 
     * reservaM = accesoReservas.obtenerRegistros(); List<Reserva> reservasBuscar =
     * accesoReservas.obtenerRegistros(); listarReservas(reservasBuscar); Reserva
     * reserva3 = null; String fecha3=null; do {
     * Vista.titulo("Ingrese fecha de la reserva"); LocalDate fecha3Ld =
     * validarfecha(); fecha3= fecha3Ld.toString(); reserva3 =
     * buscarReserva(fecha3Ld); }while (reserva3==null);
     * 
     * 
     * while (resp == true) {
     * 
     * Vista.titulo("Modificar Reserva"); reserva3.mostrar();
     * System.out.println(""); Vista.menuModificarReserva();
     * System.out.println("Ingrese una opcion:"); op = scanner.nextInt();
     * scanner.nextLine();
     * 
     * switch (op) {
     * 
     * case 0: resp = false; break; case 1: LocalDate fechaNuevaLd = null; // Le
     * pido al usuario que ingrese la fecha nueva do {
     * System.out.println("Ingrese fecha nueva:"); fechaNuevaLd= validarfecha();
     * 
     * }while (!verificarFechaValida(fechaNuevaLd));
     * 
     * String fechaNueva = fechaNuevaLd.toString(); // Busca la reserva en la lista,
     * la modifica y luego la vuelve a guardar en el // archivo
     * reserva3=modificarReservaFecha(reservaM, fecha3, fechaNueva);
     * System.out.println("Se ha hecho la modificacion con exito!");
     * 
     * break; case 2: System.out.println("Modificar Menu"); List<Menu> menus =
     * seleccionarMenus(); reserva3 = modificarReservaMenus(reservasBuscar, fecha3,
     * menus);
     * 
     * break; case 3: // Le pide al usuario que ingrese la descripcion nueva
     * System.out.println("Modificar descripcion"); String descripcionNueva =
     * scanner.nextLine(); reserva3 = modificarReservaDescripcion(reservaM,
     * reserva3.getFechaEvento(), descripcionNueva); break; case 4:
     * System.out.println("Bartenders"); System.out.println("1- True");
     * System.out.println("2- False"); int opB = 0; boolean quiereBartender = false;
     * opB = scanner.nextInt(); switch (opB){ case 1: quiereBartender = true; break;
     * case 2: quiereBartender = false; default:
     * System.err.println("Numero incorrecto"); } reserva3 =
     * modificarReservaQuiereBartender(reservaM,reserva3.getFechaEvento(),
     * quiereBartender); break; case 5: System.out.println("Cambiar status");
     * System.out.println("1- True"); System.out.println("2- False"); opB = 0;
     * boolean status = false; opB = scanner.nextInt(); switch (opB){ case 1: status
     * = true; break; case 2: status = false; default:
     * System.err.println("Numero incorrecto"); } reserva3 =
     * modificarReservaStatus(reservaM,reserva3.getFechaEvento(),status); break;
     * default: System.out.println("Ingreso dato incorrecto. Reintente"); } }
     * 
     * }catch (FechaInvalidaException e){ System.err.println("Fecha invalida");
     * modificarReservas();
     * 
     * } catch (NullPointerException e) {
     * 
     * System.err.println("No existe"); modificarReservas();
     * 
     * } catch (InputMismatchException e) { System.err.println("Dato invalido");
     * modificarReservas();
     * 
     * } catch (Exception e) { System.err.println("Error"); modificarReservas(); } }
     */

    /*
     * public Reserva modificarReservaFecha(List<Reserva> reservas, String
     * fechaVieja, String fechaNueva) { boolean resp = false; int i = 0; Reserva
     * reserva = null; if (reservas != null) { while (!resp && i < reservas.size())
     * { if (reservas.get(i).getFechaEvento().equals(fechaVieja)) {
     * reservas.get(i).setFechaEvento(fechaNueva);
     * accesoReservas.guardarInformacion(reservas); reserva = reservas.get(i); resp
     * = true; } i++; } } return reserva;
     * 
     * }
     * 
     * public Reserva modificarReservaMenus(List<Reserva> reservas, String fecha,
     * List<Menu> menus) { boolean resp = false; int i = 0; Reserva reserva = null;
     * try { if (reservas != null) { while (!resp && i < reservas.size()) { if
     * (reservas.get(i).getFechaEvento().equals(fecha)) {
     * 
     * reservas.get(i).setMenus(menus); reserva = reservas.get(i);
     * accesoReservas.guardarInformacion(reservas); reservas.get(i).mostrar();
     * reserva = reservas.get(i); resp = true; } i++; }
     * 
     * } } catch (NullPointerException e) {
     * 
     * } catch (Exception e) {
     * 
     * } return reserva; }
     * 
     * public Reserva modificarReservaDescripcion(List<Reserva> reservas, String
     * fechaVieja, String descricion) { boolean resp = false; int i = 0; Reserva
     * reserva = null; try { if (reservas != null) { while (!resp && i <
     * reservas.size()) { if (reservas.get(i).getFechaEvento().equals(fechaVieja)) {
     * reservas.get(i).setDescripcion(descricion); reserva = reservas.get(i);
     * accesoReservas.guardarInformacion(reservas); resp = true; } i++; }
     * 
     * } } catch (NullPointerException e) {
     * 
     * } catch (Exception e) {
     * 
     * } return reserva; }
     * 
     * public Reserva modificarReservaQuiereBartender(List<Reserva> reservas, String
     * fecha, boolean quiereBartender) { boolean resp = false; int i = 0; Reserva
     * reserva = null; try { if (reservas != null) { while (!resp && i <
     * reservas.size()) { if (reservas.get(i).getFechaEvento().equals(fecha)) {
     * 
     * reservas.get(i).setQuiereBartender(quiereBartender);
     * accesoReservas.guardarInformacion(reservas); reserva = reservas.get(i); resp
     * = true; } i++; }
     * 
     * } } catch (NullPointerException e) {
     * 
     * } catch (Exception e) {
     * 
     * } return reserva; }
     * 
     * public Reserva modificarReservaStatus(List<Reserva> reservas, String fecha,
     * boolean quiereBartender) { boolean resp = false; int i = 0; Reserva reserva =
     * null; try { if (reservas != null) { while (!resp && i < reservas.size()) { if
     * (reservas.get(i).getFechaEvento().equals(fecha)) {
     * 
     * reservas.get(i).setQuiereBartender(quiereBartender);
     * accesoReservas.guardarInformacion(reservas); reserva = reservas.get(i); resp
     * = true; } i++; }
     * 
     * } } catch (NullPointerException e) {
     * 
     * } catch (Exception e) {
     * 
     * } return reserva; }
     */
    // endregion

    // region Buscar

    /*
     * public void buscarReservas() { List<Reserva> reservasCliente = new
     * ArrayList<>(); Reserva reserva = null; Scanner scanner = new
     * Scanner(System.in); int op = 0; boolean resp = true; try {
     * 
     * while (resp == true) {
     * 
     * System.out.println(""); System.out.println("1- Id");
     * System.out.println("2. Fecha"); System.out.println("3- Cliente");
     * System.out.println("0- Salir");
     * 
     * op = scanner.nextInt();
     * 
     * switch (op) {
     * 
     * case 0: resp = false; break; case 1: reserva = null;
     * System.out.println("ID"); String idReserva = scanner.next();
     * scanner.nextLine(); reserva = buscarReserva(idReserva); reserva.mostrar();
     * break; case 2: reserva = null; reserva = seleccionarfechaEvento(scanner);
     * reserva.mostrar(); break;
     * 
     * case 3: System.out.println("Cliente"); boolean dnivalido = false;
     * reservasCliente = null; while (!dnivalido) { String nombreUsuario =
     * Helpers.validaciones("Nombre usuario", Helpers.VALIDAR_NOMBRE_USUARIO,
     * "Error, comienza con numeros o letras y puede contener (._) minimo 8, maximo 20 caracteres"
     * ); Cliente clienteObj = accesoClientes.buscarCliente(nombreUsuario);
     * reservasCliente = buscarReservas(clienteObj); System.out.println("Aca");
     * listarReservas(reservasCliente); dnivalido = true; } break; default:
     * System.out.println("Ingreso un dato incorrecto. Reintente"); } }
     * 
     * } catch (DateTimeException e) { System.err.println("Fecha invalida");
     * buscarReservas(); } catch (NullPointerException e) {
     * System.err.println("No existen reservas "); buscarReservas();
     * 
     * } catch (InputMismatchException e) { System.err.println("Error");
     * buscarReservas();
     * 
     * } catch (Exception e) { System.err.println("Error"); buscarReservas();
     * 
     * }
     * 
     * }
     */

    /*
     * public Reserva buscarReserva(String id) { Reserva reserva = null; try {
     * 
     * reserva = accesoReservas.obtenerRegistro(id);
     * 
     * } catch (NoExisteReserva e) {
     * 
     * } catch (NullPointerException e) {
     * 
     * } catch (Exception e) {
     * 
     * }
     * 
     * return reserva; }
     * 
     * public Reserva buscarReserva(LocalDate fechaLD) throws NoExisteReserva {
     * Reserva reserva = null; try {
     * 
     * reserva = accesoReservas.obtenerRegistro(fechaLD);
     * 
     * }catch (NoExisteReserva e) {
     * System.err.println("No existe reserva con esa fecha"); }catch
     * (NullPointerException e ){
     * 
     * } catch (Exception e) {
     * 
     * } return reserva; }
     * 
     * public Reserva seleccionarfechaEvento(Scanner scanner) { reserva = null;
     * 
     * try { LocalDate fechaLD = validarfecha(); reserva = buscarReserva(fechaLD);
     * 
     * } catch (NoExisteReserva e) {
     * 
     * } catch (NullPointerException e) {
     * 
     * } catch (Exception e) {
     * 
     * }
     * 
     * return reserva;
     * 
     * }
     */

    /*
     * public List<Reserva> buscarReservas(Cliente cliente)throws NoExisteReserva {
     * List<Reserva> reservasCliente = null; try {
     * 
     * reservasCliente = accesoReservas.obtenerRegistro(cliente);
     * 
     * }catch (NoExisteReserva r){
     * 
     * } catch (NullPointerException e) {
     * 
     * } catch (Exception e) {
     * 
     * } return reservasCliente; }
     * 
     * public List<Reserva> buscarReservas(Cliente clienteObj,String username)
     * throws NoExisteReserva { boolean resp = false; List<Reserva> reservasCliente
     * = null; List<Reserva> reservas = null; int i = 0;
     * 
     * reservas = accesoReservas.obtenerRegistros();
     * 
     * if (!reservas.isEmpty()) {
     * 
     * for (int j = 0; j < reservas.size(); j++) {
     * if(reservas.get(j).getIdCliente().equals(clienteObj.getId())){
     * reservasCliente.add(reservas.get(j)); reservas.get(j).mostrar(); resp=true; }
     * } }
     * 
     * if (!resp) { throw new NoExisteReserva("No hay reservas"); }
     * 
     * 
     * return reservasCliente; }
     */

    // endregion

    // region Listar

    /*
     * public void listarReservas() { List<Reserva> reservasL = new ArrayList<>();
     * Scanner entradaEscanner = new Scanner(System.in); boolean resp = true;
     * 
     * while (resp) {
     * 
     * Vista.menuListarReservas();
     * 
     * reservasL = accesoReservas.obtenerRegistros(); int seleccion;
     * 
     * try { seleccion = entradaEscanner.nextInt();
     * 
     * switch (seleccion) { case 0: resp = false; break; case 1:
     * Vista.titulo(" Listar todas las reservas."); listarTodaslasReservas(); break;
     * case 2: Vista.titulo(" Listar reservas Activas."); listarReservasActivas();
     * break; case 3: Vista.titulo(" Listar Reservas No Activas");
     * listarReservasNoActivas(); break; case 4: boolean resp4 = false;
     * Vista.titulo("Listar reservas por cliente"); Cliente cliente = null; while
     * (!resp4) { String nombreUsuario = Helpers.validaciones("Nombre usuario",
     * Helpers.VALIDAR_NOMBRE_USUARIO,
     * "Error, comienza con numeros o letras y puede contener (._) minimo 8, maximo 20 caracteres"
     * ); cliente = accesoClientes.buscarCliente(nombreUsuario); List<Reserva>
     * reservasCliente = new ArrayList<>(); reservasCliente =
     * buscarReservas(cliente); listarReservas(reservasCliente); resp4 = true; }
     * break; default: System.out.println("Ingreso un dato Incorrecto. Reintente");
     * } } catch (ClienteNoExiste clienteNoExiste) {
     * System.err.println("No existe el username");
     * 
     * } catch (InputMismatchException e) { getMenuGestionReservas(); } catch
     * (Exception e) { getMenuGestionReservas(); }
     * 
     * } }
     */

    /*
     * public void listarTodaslasReservas() {
     * 
     * List<Reserva> reservas = null; boolean resp = false; int i = 0;
     * 
     * try {
     * 
     * reservas = accesoReservas.obtenerRegistros();
     * 
     * for (int j = 0; j < reservas.size(); j++) { reservas.get(j).mostrar(); resp =
     * true; }
     * 
     * if (!resp) { System.out.println("No hay reservas"); System.out.println(""); }
     * else countReservas(); System.out.println("Total: " + reservas.size());
     * 
     * } catch (NullPointerException e) {
     * 
     * } catch (Exception e) {
     * 
     * } }
     * 
     * public void listarReservasActivas() {
     * 
     * List<Reserva> reservas = null; boolean resp = false; int i = 0; int countA =
     * 0;
     * 
     * try {
     * 
     * reservas = accesoReservas.obtenerRegistros(); for (Reserva x : reservas) { if
     * ((x != null) && (x.isStatus())) { x.mostrar(); countA++; resp = true; } }
     * 
     * if (!resp) { System.out.println("No hay reservas Activas"); }
     * 
     * System.out.println("Total: " + countA);
     * 
     * } catch (NullPointerException e) {
     * 
     * } catch (Exception e) {
     * 
     * }
     * 
     * }
     */

    /*
     * public void listarReservasNoActivas() {
     * 
     * List<Reserva> reservas = null; boolean resp = false; int i = 0; int countD =
     * 0; try {
     * 
     * reservas = accesoReservas.obtenerRegistros(); for (Reserva x : reservas) { if
     * ((x != null) && (!x.isStatus())) { x.mostrar(); countD++; resp = true;
     * 
     * } } if (!resp) { System.out.println("No hay reservas No Activas."); }
     * System.out.println("Total: " + countD);
     * 
     * } catch (NullPointerException e) {
     * 
     * } catch (Exception e) { } }
     * 
     * public void listarReservas(List<Reserva> reservas) { boolean resp = false;
     * int count = 0; if (!reservas.isEmpty()) { for (Reserva x : reservas) { if (x
     * != null) { x.mostrar(); count++; resp = true; } } } if (!resp) {
     * System.out.println("No hay reservas"); System.out.println("Total : " +
     * count); System.out.println(""); } else {
     * 
     * System.out.println("Total : " + count); } }
     * 
     * public void countReservas() { List<Reserva> reservas = null; boolean resp =
     * false; int i = 0; int countA = 0; int countD = 0; try {
     * 
     * reservas = accesoReservas.obtenerRegistros(); for (Reserva x : reservas) { if
     * ((x != null) && (x.isStatus())) { countA++; } else countD++; }
     * System.out.println("Reservas Activas : " + countA);
     * System.out.println("Reservas Inactivas : " + countD);
     * 
     * } catch (NullPointerException e) {
     * 
     * } catch (Exception e) { } }
     */

    // endregion

    // region Ventas

    /*
     * private void getMenuGestionVentas() { boolean resp = true; int seleccion;
     * 
     * while (resp) { Vista.titulo("Gestion de ventas"); Vista.menuGestionVentas();
     * seleccion = Helpers.validarInt(); switch (seleccion) { case 0: resp = false;
     * break; case 1: System.out.println("ACA DAMOS DE ALTA UNA VENTA."); break;
     * case 2: System.out.println("ACA DAMOS DE BAJA UNA VENTA."); break; case 3:
     * System.out.println("ACA BUSCAMOS UNA VENTA."); break; default:
     * Vista.opcionIncorrecta(seleccion); break; } } }
     */

    // endregion

}
