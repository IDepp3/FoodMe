package com.utn.teamA.utils;

public class Vista {

    
    // region metodos reutilizables

    // TODO ver posible mejora
    public static void titulo(String mensaje){
        int cantidad = mensaje.length() + 16;
        System.out.println(Color.ANSI_BLUE);
        for(int i = 0; i < cantidad; i++){
            if(i == 0)
                System.out.print(" ");
            else if(i == cantidad - 1)
                System.out.println("-");
            else
                System.out.print("-");
        }
        
        for(int i = 0; i < cantidad; i++){
            if(i == 0)
                System.out.print("|");
            else if(i < 8)
                System.out.print(" ");
            else if(i == 8)
                System.out.print(mensaje);
            else if(i == cantidad - 1)
                System.out.println("|");
            else if(i > mensaje.length() + 6)
                System.out.print(" ");
        }

        for(int i = 0; i < cantidad; i++){
            if(i == 0)
                System.out.print(" ");
            else if(i == cantidad - 1)
                System.out.println("-");
            else
                System.out.print("-");
        }
        System.out.println(Color.ANSI_RESET);
    }

    public static void opcionIncorrecta(int opcion){
        System.out.println(
                            Color.ANSI_RED +
                            "\n\t [[ " + opcion + " ]] NO ES UNA OPCION VALIDA \n" +
                            Color.ANSI_RESET
                    );
    }

    public static void opcionIncorrecta(String mensaje, String dato){
        System.out.println(
                            Color.ANSI_RED +
                            "\n\t [[ " + dato + " ]] " + mensaje + "  \n" +
                            Color.ANSI_RESET
                    );
    }

    public static void opcionCorrecta(String mensaje){
        System.out.println(
                            Color.ANSI_GREEN + 
                            "\n\t [[ " + mensaje + " ]] \n" +
                            Color.ANSI_RESET
        );
    }

    // endregion

    // vistas cliente

    public static void menuPrincipal(){
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Ver menus");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Hacer reserva");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Informacion personal");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Salir");
        System.out.print(Color.ANSI_GREEN + " : " + Color.ANSI_RESET);
    }

    public static void informacionPersonal(){
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Ver informacion personal");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Modificar informacion");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Historial de compras");
        System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + "Reservas pendientes");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + " : " + Color.ANSI_RESET);
    }

    public static void modificarInformacionPersonal(){
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Modificar nombre");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Modificar apellido");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Modificar fecha nacimiento");
        System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + "Modificar telefono");
        System.out.println(Color.ANSI_GREEN + " 5 " + Color.ANSI_RESET + "Modificar direccion");
        System.out.println(Color.ANSI_GREEN + " 6 " + Color.ANSI_RESET + "Modificar DNI");
        System.out.println(Color.ANSI_GREEN + " 7 " + Color.ANSI_RESET + "Modificar email");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + " : " + Color.ANSI_RESET);
    }

    public static void menuGestionPersonal(){
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Dar de alta un empleado");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Dar de baja un empleado");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Buscar un empleado");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Listar empleados");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + " : " + Color.ANSI_RESET);
    }
/*
    public static void menuAdministrador(){
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Gestion de Personal");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Gestion de Reservas");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Gestion de Ventas");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Gestion de Stock");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + "  " + Color.ANSI_RESET);
    }
    /*
 */
    public static void menuPrincipalFoodMe(){
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Administrador");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Cliente");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + "  " + Color.ANSI_RESET);
    }

    public static void menuGestionReserva(){
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Dar de alta una Reserva");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Dar de baja una Reserva");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Buscar una reserva");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Modificar una Reserva");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Listar Reservas");
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
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "CLASICO");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "VEGANO");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "VEGETARIANO");
        System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + "DIABETICO");
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

    public static void modificarReserva(){
        System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + "Fecha evento");
        System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + "Menus");
        System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + "Descripcion");
        System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + "Bartenders");
        System.out.println(Color.ANSI_GREEN + " 5 " + Color.ANSI_RESET + "Status");
        System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + "Volver");
        System.out.print(Color.ANSI_GREEN + "  " + Color.ANSI_RESET);
    }

    public void insertarhora(){

    }

    // endregion


}
