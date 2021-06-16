package com.utn.teamA.utils;

import com.utn.teamA.clases.Cliente;
import com.utn.teamA.clases.Empleado;
import com.utn.teamA.clases.Reserva;

public class Vista {

    // region TITULO PRINCIPAL

    // TODO ver posible mejora
    public static void titulo(String mensaje) {
        int cantidad = mensaje.length() + 16;
        System.out.println(Color.ANSI_BLUE);
        for (int i = 0; i < cantidad; i++) {
            if (i == 0)
                System.out.print(" ");
            else if (i == cantidad - 1)
                System.out.println("-");
            else
                System.out.print("-");
        }

        for (int i = 0; i < cantidad; i++) {
            if (i == 0)
                System.out.print("|");
            else if (i < 8)
                System.out.print(" ");
            else if (i == 8)
                System.out.print(mensaje);
            else if (i == cantidad - 1)
                System.out.println("|");
            else if (i > mensaje.length() + 6)
                System.out.print(" ");
        }

        for (int i = 0; i < cantidad; i++) {
            if (i == 0)
                System.out.print(" ");
            else if (i == cantidad - 1)
                System.out.println("-");
            else
                System.out.print("-");
        }
        System.out.println(Color.ANSI_RESET);
    }

    // endregion

    // region OPCIONES

    public static void ingreseDato(String mensaje){
        System.out.print(Color.ANSI_GREEN + mensaje + " : " + Color.ANSI_RESET);
    }

    public static void opcionIncorrecta(int opcion) {
        System.out.println(Color.ANSI_RED + "\n\t [[ " + opcion + " ]] NO ES UNA OPCION VALIDA \n" + Color.ANSI_RESET);
    }

    public static void opcionIncorrecta(String mensaje, String dato) {
        System.out.println(Color.ANSI_RED + "\n\t [[ " + dato + " ]] " + mensaje + "  \n" + Color.ANSI_RESET);
    }

    public static void opcionIncorrecta(String mensaje) {
        System.out.println(Color.ANSI_RED + "\n\t [[ " + mensaje + " ]] \n" + Color.ANSI_RESET);
    }

    public static void opcionCorrecta(String mensaje) {
        System.out.println(Color.ANSI_GREEN + "\n\t [[ " + mensaje + " ]] \n" + Color.ANSI_RESET);
    }

    // endregion

    // region MENUS

    // region PRINCIPAL

    public static void menuPrincipal() {
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Login");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Registro");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Salir");
        System.out.print(Color.ANSI_GREEN + " : " + Color.ANSI_RESET);
    }
    // endregion

    // region ADMINISTRADOR

    public static void seleccionMenuAdmin(){
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Ingrese al menu como administrador");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Ingrese al menu como cliente");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Salir");
        System.out.print(Color.ANSI_GREEN + " : " + Color.ANSI_RESET);


    }

    public static void menuPrincipalAdministrador() {
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Gestion de Personal");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Gestion de Reservas");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Gestion de Clientes");
        System.out.println(Color.ANSI_GREEN + " 6 " + Color.ANSI_RESET + "Gestion Menu");
        System.out.println(Color.ANSI_GREEN + " 7 " + Color.ANSI_RESET + "Gestion Plato");
        System.out.println(Color.ANSI_GREEN + " 8 " + Color.ANSI_RESET + "Gestion Ingrediente");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + " : " + Color.ANSI_RESET);
    }
    // endregion

    // region VENTAS

    public static void menuGestionVentas() {
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Dar de alta una venta");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Dar de baja una venta");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Buscar una venta");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + " : " + Color.ANSI_RESET);
    }

    // endregion

    // region STOCKS

    public static void menuGestionClientes() {
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Dar de alta un cliente");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Dar de baja un cliente");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Buscar un cliente");
        System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + "Listas clientes");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + " : " + Color.ANSI_RESET);
    }

    // endregion

    // region EMPLEADOS

    public static void vistaEleccionCrearEmpleado(){
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Empleado existente");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Crear nuevo empleado");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + " : " + Color.ANSI_RESET);
    }

    public static void menuGestionEmpleados() {
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Dar de alta un empleado");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Dar de baja un empleado");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Buscar un empleado");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + " : " + Color.ANSI_RESET);
    }

    // endregion

    // region CLIENTES

    public static void menuPrincipalUsuario() {
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Ver menus");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Hacer Reserva");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Informacion Personal");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Salir");
        System.out.print(Color.ANSI_GREEN + " : " + Color.ANSI_RESET);
    }

    public static void informacionPersonal() {
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Ver informacion personal");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Modificar informacion");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Historial de compras");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + " : " + Color.ANSI_RESET);
    }

    public static void modificarInformacionPersonal() {
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Modificar nombre");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Modificar apellido");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Modificar fecha nacimiento");
        System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + "Modificar telefono");
        System.out.println(Color.ANSI_GREEN + " 5 " + Color.ANSI_RESET + "Modificar direccion");
        System.out.println(Color.ANSI_GREEN + " 6 " + Color.ANSI_RESET + "Modificar DNI");
        System.out.println(Color.ANSI_GREEN + " 7 " + Color.ANSI_RESET + "Modificar email");
        System.out.println(Color.ANSI_GREEN + " 8 " + Color.ANSI_RESET + "Modificar password");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + " : " + Color.ANSI_RESET);
    }

    public static void menuGestionPersonal() {
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Dar de alta un empleado");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Dar de baja un empleado");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Buscar un empleado");
        System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + "Listar empleados");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + " : " + Color.ANSI_RESET);
    }

    public static void menuAdministrador(){
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Gestion de Personal");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Gestion de Reservas");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Gestion de Ventas");
        System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + "Gestion de Stock");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + "  " + Color.ANSI_RESET);
    }


    public static void menuPrincipalFoodMe(){
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Administrador");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Cliente");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + "  " + Color.ANSI_RESET);
    }

    public static void menuGestionReserva(){
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Dar de baja una Reserva");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Listar Reservas");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + "  " + Color.ANSI_RESET);
    }

    public static void menuDarAltaReservaIngreseCliente(){
        System.out.println(Color.ANSI_GREEN + "    1 " + Color.ANSI_RESET + "Buscar Cliente");
        System.out.println(Color.ANSI_GREEN+ "    2 " + Color.ANSI_RESET + "Dar Alta cliente");
        System.out.println(Color.ANSI_RED+ "    0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + "  " + Color.ANSI_RESET);
    }

    public static void darAltaReservaSeleccionarMenu(){
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Clasico");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Vegano");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Vegetariano");
        System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + "Diabetico");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + "  " + Color.ANSI_RESET);
    }

    public static void deseaSeguirCargandoDatos(){
        System.out.println(Color.ANSI_BLUE + " Desea seguir cargando los datos? " + Color.ANSI_GREEN+ "s/n");
        System.out.print(Color.ANSI_GREEN + "  " + Color.ANSI_RESET);

    }
    public static void deseaSeguirCargandoFechas(){
        System.out.println(Color.ANSI_RESET + " Desea seguir buscando fechas? " + Color.ANSI_GREEN+ "s/n");
        System.out.print(Color.ANSI_GREEN + "  " + Color.ANSI_RESET);
    }
    public static void finalizarReserva() {
        System.out.println(Color.ANSI_RESET + " Desea guardar la Reserva?' " + Color.ANSI_GREEN + "s/n");
        System.out.print(Color.ANSI_GREEN + "  " + Color.ANSI_RESET);
    }
    public static void sleccionarMenuAltaReserva(){
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Cantidad de personas");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Modificar ingredientes");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Eliminar ingrediente");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + "  " + Color.ANSI_RESET);
    }

    public static void darBajaReservas(){
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Id");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Fecha");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Cliente");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + "  " + Color.ANSI_RESET);
    }

// System.out.println(Color.ANSI_BLUE + " 1 " + Color.ANSI_RESET + "Buscar Cliente");

    public static void menuModificarReserva(){

        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Fecha evento");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Menus");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Descripcion");
        System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + "Bartenders");
        System.out.println(Color.ANSI_GREEN + " 5 " + Color.ANSI_RESET + "Status");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + "  " + Color.ANSI_RESET);
    }

    public static void menuListarReservas(){

        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Todas las reservas");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Activas");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "No Activas");
        System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + "Por Cliente");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + "  " + Color.ANSI_RESET);
    }

    // endregion

    // endregion


    // region vista modificada cliente

    public static void informacionPersonalUsuario(Cliente cliente){
        System.out.println("");
        System.out.println(Color.ANSI_GREEN + "ID : " + Color.ANSI_RESET + Color.ANSI_YELLOW + cliente.getId() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Nombre de usuario : " + Color.ANSI_RESET + Color.ANSI_YELLOW + cliente.getUsername() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Email : " + Color.ANSI_RESET + Color.ANSI_YELLOW + cliente.getEmail() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Fecha de Registro : " + Color.ANSI_RESET + Color.ANSI_YELLOW + cliente.getFechaRegistro() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Tipo de usuario : " + Color.ANSI_RESET + Color.ANSI_YELLOW + cliente.getTipoUsuario() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Nombre : " + Color.ANSI_RESET + Color.ANSI_YELLOW + ((cliente.getNombre() != null) ? cliente.getNombre() : "Sin datos") + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Apellido : " + Color.ANSI_RESET + Color.ANSI_YELLOW + ((cliente.getApellido() != null) ? cliente.getApellido() : "Sin datos") + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Fecha de nacimiento : " + Color.ANSI_RESET + Color.ANSI_YELLOW + ((cliente.getFechaNacimiento() != null) ? cliente.getFechaNacimiento() : "Sin datos") + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Telefono : " + Color.ANSI_RESET + Color.ANSI_YELLOW + ((cliente.getTelefono() != null) ? cliente.getTelefono() : "Sin datos") + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Direccion : " + Color.ANSI_RESET + Color.ANSI_YELLOW + ((cliente.getDireccion() != null) ? cliente.getDireccion() : "Sin datos") + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "DNI : " + Color.ANSI_RESET + Color.ANSI_YELLOW + ((cliente.getDni() != null) ? cliente.getDni() : "Sin datos") + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Estado de cuenta : " + Color.ANSI_RESET + Color.ANSI_YELLOW + ((cliente.getEstado()) ? "ACTIVO" : "INACTIVO") + Color.ANSI_RESET);
        System.out.println("");
    }

    public static void verReservaToString(Reserva reserva){
        System.out.println("");
        System.out.println(Color.ANSI_GREEN + "ID : " + Color.ANSI_RESET + Color.ANSI_YELLOW + reserva.getId() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Fecha reservacion : " + Color.ANSI_RESET + Color.ANSI_YELLOW + reserva.getFechaReserva() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Fecha de evento : " + Color.ANSI_RESET + Color.ANSI_YELLOW + reserva.getFechaEvento() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Horario de llegada : " + Color.ANSI_RESET + Color.ANSI_YELLOW + reserva.getHorarioLlegada() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Horario de inicio : " + Color.ANSI_RESET + Color.ANSI_YELLOW + reserva.getHorarioInicio() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Horario de finalizacion : " + Color.ANSI_RESET + Color.ANSI_YELLOW + reserva.getHorarioFinaliza() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Descripcion : " + Color.ANSI_RESET + Color.ANSI_YELLOW + reserva.getDescripcion() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Cantidad de personas : " + Color.ANSI_RESET + Color.ANSI_YELLOW + reserva.getCantidadPersonasTotal() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Bartender : " + Color.ANSI_RESET + Color.ANSI_YELLOW + (reserva.isQuiereBartender() ? "SI" : "NO") + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Estado : " + Color.ANSI_RESET + Color.ANSI_YELLOW + ((reserva.isStatus()) ? "Activa" : "Dada de baja") + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Precio final : " + Color.ANSI_RESET + Color.ANSI_YELLOW + reserva.getPrecioFinal() + Color.ANSI_RESET);
        System.out.println("");
    }

    public static void listarEmpleado(Empleado empleado){
        System.out.println("");
        System.out.println(Color.ANSI_GREEN + "ID : " + Color.ANSI_RESET + Color.ANSI_YELLOW + empleado.getId() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Nombre : " + Color.ANSI_RESET + Color.ANSI_YELLOW + empleado.getNombre() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Apellido : " + Color.ANSI_RESET + Color.ANSI_YELLOW + empleado.getApellido() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Fecha de nacimiento : " + Color.ANSI_RESET + Color.ANSI_YELLOW + empleado.getFechaNacimiento() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Puesto : " + Color.ANSI_RESET + Color.ANSI_YELLOW + empleado.getTipoEmpleado() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Telefono : " + Color.ANSI_RESET + Color.ANSI_YELLOW + empleado.getTelefono() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Direccion : " + Color.ANSI_RESET + Color.ANSI_YELLOW + empleado.getDireccion() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "DNI : " + Color.ANSI_RESET + Color.ANSI_YELLOW + empleado.getDni() + Color.ANSI_RESET);
        System.out.println(Color.ANSI_GREEN + "Estado : " + Color.ANSI_RESET + Color.ANSI_YELLOW + ((empleado.getEstado()) ? "ACTIVO" : "INACTIVO") + Color.ANSI_RESET);
        System.out.println("");
    }
}
