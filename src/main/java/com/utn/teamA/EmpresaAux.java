package com.utn.teamA;

import java.util.ArrayList;
import java.util.List;

public class EmpresaAux {

    //TODO ver donde va la lista de ingredientes Map o List
    private List<Ingrediente> listaDeIngredites = new ArrayList<>();
    private List<Plato> listaDePlatos = new ArrayList<>();
    private List<Menu> listaDeMenus = new ArrayList<>();

    public void init(){

        //ingredienteMenu();
        //platoMenu();

        listaDeIngredites.add(new Ingrediente("tomate","tomate",50,"proveedor"));
        listaDeIngredites.add(new Ingrediente("papa","papa",50,"proveedor"));

        //Plato plato1 = new Plato("Ensalada",listaDeIngredites,"ensalada",TipoPlato.ENTRADA);
        //System.out.println(plato1);

        //Menu menu1 = new Menu();
        //menu1.crear();

        IngredientePersistencia ingredientePersistencia = new IngredientePersistencia();

        ingredientePersistencia.guardarInformacion(listaDeIngredites);

        listaDeIngredites = ingredientePersistencia.obtenerRegistros();

    }

    public void ingredienteMenu(){
        int opcion = 0;
        boolean continuar = true;

        do{
            System.out.println(
                Color.ANSI_BLUE +
                "\n\n" +
                " ------------------------------------------------\n" +
                "| \t\t M E N U    I N G R E D I E N T E \t\t |\n" +
                " ------------------------------------------------" +
                " \n\n" +
                Color.ANSI_RESET);
            System.out.println(Color.ANSI_YELLOW + "\t Ingrese una opcion:" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + " Nuevo Ingrediente");
            System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + " Editar Ingrediente");
            System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + " Eliminar Ingrediente");
            System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + " Listar Ingredientes");
            System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + " Volver");

            opcion = Helpers.validarInt();

            switch (opcion){
                case 0:
                    continuar = false;
                    break;
                case 1:
                    agregarIngredienteView();
                    break;
                case 2:
                    System.out.println(Color.ANSI_BLACK + "Seccion en construccion" + Color.ANSI_RESET);
                    break;
                case 3:
                    System.out.println(Color.ANSI_BLACK + "Seccion en construccion" + Color.ANSI_RESET);
                    break;
                case 4:
                    for ( Ingrediente ingrediente : listaDeIngredites ) {
                        System.out.println(ingrediente);
                    }
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


    //region agregar ingrediente
    public void agregarIngredienteView(){

        char unElementoMas = 's';

        while ( unElementoMas == 's' ){
            agregarIngrediente();

            System.out.print(
                Color.ANSI_YELLOW + " \n\n \t\t Desea agregar otro ingrediente? " +
                Color.ANSI_YELLOW + "[" +
                Color.ANSI_GREEN + " S " +
                Color.ANSI_YELLOW + "/" +
                Color.ANSI_RED + " N " +
                Color.ANSI_YELLOW + "]" + Color.ANSI_RESET);
            unElementoMas = Helpers.charAt0();


        }

    }

    public void agregarIngrediente(){

        Ingrediente nuevoIngrediente = new Ingrediente();

        nuevoIngrediente.crear();

        listaDeIngredites.add(nuevoIngrediente);
    }

    //endregion


    public void platoMenu(){
        int opcion = 0;
        boolean continuar = true;

        do{
            System.out.println(
                    Color.ANSI_BLUE +
                            "\n\n" +
                            " ------------------------------------\n" +
                            "| \t\t M E N U    P L A T O \t\t |\n" +
                            " ------------------------------------" +
                            " \n\n" +
                            Color.ANSI_RESET);
            System.out.println(Color.ANSI_YELLOW + "\t Ingrese una opcion:" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + " Nuevo Plato");
            System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + " Editar Plato");
            System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + " Eliminar Plato");
            System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + " Listar Platos");
            System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + " Volver");

            opcion = Helpers.validarInt();

            switch (opcion){
                case 0:
                    continuar = false;
                    break;
                case 1:
                    agregarPlatoView();
                    break;
                case 2:
                    System.out.println(Color.ANSI_BLACK + "Seccion en construccion" + Color.ANSI_RESET);
                    break;
                case 3:
                    System.out.println(Color.ANSI_BLACK + "Seccion en construccion" + Color.ANSI_RESET);
                    break;
                case 4:
                    for ( Plato plato : listaDePlatos ) {
                        System.out.println(plato);
                    }
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


    //region agregar plato
    public void agregarPlatoView(){

        char unElementoMas = 's';

        while ( unElementoMas == 's' ){
            agregarPlato();

            System.out.print(
                    Color.ANSI_YELLOW + " \n\n \t\t Desea agregar otro plato? " +
                            Color.ANSI_YELLOW + "[" +
                            Color.ANSI_GREEN + " S " +
                            Color.ANSI_YELLOW + "/" +
                            Color.ANSI_RED + " N " +
                            Color.ANSI_YELLOW + "]" + Color.ANSI_RESET);
            unElementoMas = Helpers.charAt0();


        }

    }

    public void agregarPlato(){

        Plato nuevoPlato = new Plato();

        nuevoPlato.crear();

        listaDePlatos.add(nuevoPlato);
    }

    //endregion


    public void menuMenu(){
        int opcion = 0;
        boolean continuar = true;

        do{
            System.out.println(
                    Color.ANSI_BLUE +
                            "\n\n" +
                            " -----------------------------\n" +
                            "| \t\t M E N U  \t\t |\n" +
                            " -----------------------------" +
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
                    System.out.println(Color.ANSI_BLACK + "Seccion en construccion" + Color.ANSI_RESET);
                    break;
                case 4:
                    for ( Menu menu : listaDeMenus ) {
                        System.out.println(menu);
                    }
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


    //region agregar plato
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

        listaDeMenus.add(nuevoMenu);
    }

    //endregion
}
