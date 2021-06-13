package com.utn.teamA;

import java.util.ArrayList;
import java.util.List;

public class MenuLista {


    private List<Menu> listaDeMenus;
    private MenuPersistencia menuPersistencia;

    public MenuLista() {
        menuPersistencia = new MenuPersistencia();
        this.listaDeMenus = menuPersistencia.obtenerRegistros();
    }

    public void menuMenu(){
        int opcion = 0;
        boolean continuar = true;

        do{
            System.out.println(
                    Color.ANSI_BLUE +
                            "\n\n" +
                            " -------------------------\n" +
                            "| \t\t M E N U  \t\t |\n" +
                            " -------------------------" +
                            " \n\n" +
                            Color.ANSI_RESET);
            System.out.println(Color.ANSI_YELLOW + "\t Ingrese una opcion:" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + " Nuevo Menu");
            System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + " Editar Menu");
            System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + " Eliminar Menu");
            System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + " Listar Menus");
            System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + " Volver");

            opcion = Helpers.validarInt();

            switch (opcion){
                case 0:
                    continuar = false;
                    break;
                case 1:
                    agregarMenuView();
                    break;
                case 2:
                    System.out.println(Color.ANSI_BLACK + "Seccion en construccion" + Color.ANSI_RESET);
                    break;
                case 3:
                    this.eliminarMenu();
                    break;
                case 4:
                    this.mostrarPlatosActivos();
                    break;
                default:
                    System.out.println(
                            Color.ANSI_RED +
                                    "\n\t [[ " + opcion + " ]] NO ES UNA OPCION VALIDA \n" +
                                    Color.ANSI_RESET
                    );
                    break;

            }

        } while( continuar );
    }


    //region agregar menu
    public void agregarMenuView(){

        char unElementoMas = 's';

        while ( unElementoMas == 's' ){
            agregarMenu();

            System.out.print(
                    Color.ANSI_YELLOW + " \n\n \t\t Desea agregar otro menu? " +
                            Color.ANSI_YELLOW + "[" +
                            Color.ANSI_GREEN + " S " +
                            Color.ANSI_YELLOW + "/" +
                            Color.ANSI_RED + " N " +
                            Color.ANSI_YELLOW + "]" + Color.ANSI_RESET);
            unElementoMas = Helpers.charAt0();


        }

    }

    public void agregarMenu(){

        Menu nuevoMenu = new Menu();

        nuevoMenu.crear();

        menuPersistencia.agregarRegistro(nuevoMenu);
    }

    //endregion

    public void eliminarMenu(){
        listaDeMenus = menuPersistencia.obtenerRegistros();
        int i = 0;

        System.out.println(Color.ANSI_YELLOW + "\t Ingrese el codigo del plato a eliminar" + Color.ANSI_RESET);

        for ( Menu menu : listaDeMenus ) {

            if( menu.getEstado() ){
                System.out.println( Color.ANSI_YELLOW + "[ " + i  + " ] " + Color.ANSI_RESET + menu.getNombre() );
            }
            i++;
        }


        int codigo = Helpers.validarInt();

        if (codigo < 0 || codigo > listaDeMenus.size() || !listaDeMenus.get(codigo).getEstado()){
            System.out.println("opcion invalida");
        }else {
            Menu menu = listaDeMenus.get(codigo);
            //TODO preguntar si este es el menu a eliminar
            System.out.println(menu);
            menuPersistencia.borrarRegistro(menu);
        }

    }

    public  void mostrarPlatosActivos(){
        listaDeMenus = menuPersistencia.obtenerRegistros();
        for ( Menu menu : listaDeMenus ) {
            if (menu.getEstado()){
                System.out.println(menu);
            }
        }
    }
}
