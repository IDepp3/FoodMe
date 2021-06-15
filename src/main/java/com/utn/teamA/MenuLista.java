package com.utn.teamA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
                    this.agregarMenuView();
                    break;
                case 2:
                    this.editarPlato();
                    break;
                case 3:
                    this.eliminarMenu();
                    break;
                case 4:
                    this.mostrarMenusActivos();
                    Helpers.enterParaContinuar();
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

        System.out.println(
                Color.ANSI_BLUE +
                        "\n\n" +
                        " ----------------------------------------\n" +
                        "| \t\t N U E V O    M E N U \t\t |\n" +
                        " ----------------------------------------" +
                        " \n\n" +
                        Color.ANSI_RESET);

        int opcion = 0;
        boolean continuar = false;

        do{

            System.out.println(Color.ANSI_CYAN + "Ingrese tipo:" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + " Vegano");
            System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + " Vegetariano");
            System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + " Diabetico");
            System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + " Clasico");

            opcion = Helpers.validarInt();
            continuar = false;


            switch (opcion){
                case 1:
                    nuevoMenu.setTipo( TipoMenu.VEGANO );
                    break;
                case 2:
                    nuevoMenu.setTipo( TipoMenu.VEGETARIANO );
                    break;
                case 3:
                    nuevoMenu.setTipo( TipoMenu.DIABETICO );
                    break;
                case 4:
                    nuevoMenu.setTipo( TipoMenu.CLASICO );
                    break;
                default:
                    continuar = true;
                    System.out.println(
                            Color.ANSI_RED +
                                    "\n\t [[ " + opcion + " ]] NO ES UNA OPCION VALIDA \n" +
                                    Color.ANSI_RESET
                    );
                    break;
            }
        }while (continuar);

        System.out.println(Color.ANSI_CYAN + "Ingrese nombre:" + Color.ANSI_RESET);
        nuevoMenu.setNombre( Helpers.nextLine() );

        System.out.println(Color.ANSI_CYAN + "Ingrese Descripcion:" + Color.ANSI_RESET);
        nuevoMenu.setDescripcion( Helpers.nextLine() );

        System.out.println(Color.ANSI_CYAN + "Ingrese Precio:" + Color.ANSI_RESET);
        nuevoMenu.setPrecio( Helpers.validarDouble() );

        nuevoMenu.setPlatos( agregarPlatos() );

        System.out.println( nuevoMenu );

        menuPersistencia.agregarRegistro(nuevoMenu);
    }

    private List<String> agregarPlatos(){

        PlatoPersistencia platoPersistencia = new PlatoPersistencia();
        List<Plato> listaDePlatos;
        List<String> platos = new ArrayList<>();

        listaDePlatos = platoPersistencia.obtenerRegistros();

        char unElementoMas = 's';

        while ( unElementoMas == 's' ){

            System.out.println(Color.ANSI_YELLOW + "\t Ingrese el codigo del ingrediente a incorporar" + Color.ANSI_RESET);

            int i = 0;
            for ( Plato plato : listaDePlatos ) {

                if( plato.getEstado() ){
                    System.out.println( Color.ANSI_YELLOW + "[ " + i  + " ] " + Color.ANSI_RESET + plato.getNombre() );
                }
                i++;
            }

            int codigo = Helpers.validarInt();

            if (codigo < 0 || codigo > listaDePlatos.size() || !listaDePlatos.get(codigo).getEstado()){
                System.out.println("opcion invalida");
            }else {
                platos.add( listaDePlatos.get(codigo).getPlatoId() );
            }

            System.out.print(
                    Color.ANSI_YELLOW + " \n\n \t\t Desea agregar otro Plato? " +
                            Color.ANSI_YELLOW + "[" +
                            Color.ANSI_GREEN + " S " +
                            Color.ANSI_YELLOW + "/" +
                            Color.ANSI_RED + " N " +
                            Color.ANSI_YELLOW + "]" + Color.ANSI_RESET);
            unElementoMas = Helpers.charAt0();

        }

        return platos;
    }


    //endregion

    public void editarPlato(){
        listaDeMenus = menuPersistencia.obtenerRegistros();
        int i = 0;

        System.out.println(Color.ANSI_YELLOW + "\t Ingrese el codigo del menu a editar" + Color.ANSI_RESET);

        for ( Menu menu : listaDeMenus ) {

            if( menu.getEstado() ){
                System.out.println( Color.ANSI_YELLOW + "[ " + i  + " ] " + Color.ANSI_RESET + menu.getNombre() );
            }
            i++;
        }

        System.out.println("");
        int codigo = Helpers.validarInt();

        if (codigo < 0 || codigo > listaDeMenus.size() || !listaDeMenus.get(codigo).getEstado()){
            System.out.println("Opcion invalida");
        }else {
            Menu menu = listaDeMenus.get(codigo);

            menu = editarMenuVista(menu);

            if( menu.getId() != null ){
                System.out.println(menu);
                menuPersistencia.actualizarRegistro(menu);
            }

        }

    }


    public Menu editarMenuVista( Menu menu){
        int opcion = 0;
        boolean continuar = true;

        do{

            System.out.println(
                    Color.ANSI_BLUE +
                            "\n\n" +
                            " -------------------------------------------\n" +
                            "| \t\t E D I T A R    M E N U \t\t |\n" +
                            " -------------------------------------------" +
                            " \n\n" +
                            Color.ANSI_RESET);

            System.out.println(menu);

            System.out.println(Color.ANSI_YELLOW + "\t Ingrese una opcion:" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_GREEN + " 1  Guardar Cambios" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + " Editar Nombre");
            System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + " Editar Descripcion");
            System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + " Editar Tipo");
            System.out.println(Color.ANSI_GREEN + " 5 " + Color.ANSI_RESET + " Editar Precio");
            System.out.println(Color.ANSI_RED + " 0  Cancelar " + Color.ANSI_RESET );

            opcion = Helpers.validarInt();

            switch (opcion){
                case 0:
                    continuar = false;
                    menu.setId(null);
                    break;
                case 1:
                    continuar = false;
                    break;
                case 2:
                    System.out.print(Color.ANSI_CYAN + "Ingrese nombre: " + Color.ANSI_RESET);
                    System.out.println(Color.ANSI_YELLOW + "< " + menu.getNombre() + " >" + Color.ANSI_RESET);
                    menu.setNombre( Helpers.nextLine() );
                    break;
                case 3:
                    System.out.print(Color.ANSI_CYAN + "Ingrese Descripcion: " + Color.ANSI_RESET);
                    System.out.println(Color.ANSI_YELLOW + "< " + menu.getDescripcion() + " >" + Color.ANSI_RESET);
                    menu.setDescripcion( Helpers.nextLine() );
                    break;
                case 4:
                    menu = this.editarTipoDeMenu(menu);
                    break;
                case 5:
                    System.out.print(Color.ANSI_CYAN + "Ingrese precio: " + Color.ANSI_RESET);
                    System.out.println(Color.ANSI_YELLOW + "< " + menu.getPrecio() + " >" + Color.ANSI_RESET);
                    menu.setPrecio( Helpers.validarDouble() );
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

        return menu;
    }


    private Menu editarTipoDeMenu(Menu menu){
        int opcion = 0;
        boolean continuar = false;

        do{
            System.out.print(Color.ANSI_CYAN + "Ingrese tipo:" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_YELLOW + "< " + menu.getTipo() + " >" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + " Vegano");
            System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + " Vegetariano");
            System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + " Diabetico");
            System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + " Clasico");

            opcion = Helpers.validarInt();
            continuar = false;

            switch (opcion){
                case 1:
                    menu.setTipo( TipoMenu.VEGETARIANO );
                    break;
                case 2:
                    menu.setTipo( TipoMenu.VEGANO );
                    break;
                case 3:
                    menu.setTipo( TipoMenu.DIABETICO );
                    break;
                case 4:
                    menu.setTipo( TipoMenu.CLASICO );
                    break;
                default:
                    continuar = true;
                    System.out.println(
                            Color.ANSI_RED +
                                    "\n\t [[ " + opcion + " ]] NO ES UNA OPCION VALIDA \n" +
                                    Color.ANSI_RESET
                    );
                    break;
            }
        }while (continuar);

        return menu;
    }

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

    public  void mostrarMenusActivos(){
        listaDeMenus = menuPersistencia.obtenerRegistros();
        for ( Menu menu : listaDeMenus ) {
            if (menu.getEstado()){
                System.out.println(menu);
            }
        }
    }


}
