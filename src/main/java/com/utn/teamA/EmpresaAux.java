package com.utn.teamA;

import java.util.ArrayList;
import java.util.List;

public class EmpresaAux {

    private MenuLista menus;
    private PlatoLista platos;
    private IngredienteLista ingredientes;

    public EmpresaAux() {
        this.menus = new MenuLista();
        this.platos = new PlatoLista();
        this.ingredientes = new IngredienteLista();
    }

    public void init(){
        this.menuPrincipal();

        System.out.println(
                Color.ANSI_BLUE +
                        "\n\n" +
                        " ----------------------------\n" +
                        "| \t\t B Y E   B Y E\t\t |\n" +
                        " ----------------------------" +
                        " \n\n" +
                        Color.ANSI_RESET);
    }

    public void menuPrincipal(){
        int opcion = 0;
        boolean continuar = true;

        do{
            System.out.println(
                    Color.ANSI_BLUE +
                            "\n\n" +
                            " ----------------------------------------\n" +
                            "| \t\t M E N U  P R I N C I P A L\t\t |\n" +
                            " ----------------------------------------" +
                            " \n\n" +
                            Color.ANSI_RESET);
            System.out.println(Color.ANSI_YELLOW + "\t Ingrese una opcion:" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + " Menus");
            System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + " Platos");
            System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + " Ingredientes");
            System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + " Salir");

            opcion = Helpers.validarInt();

            switch (opcion){
                case 0:
                    continuar = false;
                    break;
                case 1:
                    menus.menuMenu();
                    break;
                case 2:
                    platos.platoMenu();
                    break;
                case 3:
                    ingredientes.ingredienteMenu();
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


}
