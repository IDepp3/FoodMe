package com.utn.teamA.helpers;

public class Vista {

    
    // region metodos reutilizables

    // TODO ver posible mejora
    public static void cartel(String mensaje){
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
                            "\n\t [[ " + mensaje + " ]] " +
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

    // endregion


}
