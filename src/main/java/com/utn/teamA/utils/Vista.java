package com.utn.teamA.utils;

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
        System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + "Gestion de Ventas");
        System.out.println(Color.ANSI_GREEN + " 5 " + Color.ANSI_RESET + "Configuracion");
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
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Informacion ersonal");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Salir");
        System.out.print(Color.ANSI_GREEN + " : " + Color.ANSI_RESET);
    }

    public static void informacionPersonal() {
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Ver informacion personal");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Modificar informacion");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Historial de compras");
        System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + "Reservas pendientes");
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
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Dar de alta una Reserva");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Dar de baja una Reserva");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Buscar una Reserva");
        System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + "Modificar una Reserva");
        System.out.println(Color.ANSI_GREEN + " 5 " + Color.ANSI_RESET + "Listar Reservas");
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
}
