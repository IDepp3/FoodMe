package com.utn.teamA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpresaAux {

    //TODO ver donde va la lista de ingredientes Map o List
    private List<Ingrediente> listaDeIngredites = new ArrayList<>();

    public void init(){

        ingredienteMenu();

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
                    System.out.println("Listar");
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

        char otroIngrediente = 's';

        while ( otroIngrediente == 's' ){
            agregarIngrediente();

            System.out.print(
                Color.ANSI_YELLOW + " \n\n \t\t Desea agregar otro ingrediente? " +
                Color.ANSI_YELLOW + "[" +
                Color.ANSI_GREEN + " S " +
                Color.ANSI_YELLOW + "/" +
                Color.ANSI_RED + " N " +
                Color.ANSI_YELLOW + "]" + Color.ANSI_RESET);
            otroIngrediente = Helpers.charAt0();


        }

    }

    public void agregarIngrediente(){

        Ingrediente nuevoIngrediente = new Ingrediente();

        nuevoIngrediente.crear();

        listaDeIngredites.add(nuevoIngrediente);
    }

    //endregion
}
