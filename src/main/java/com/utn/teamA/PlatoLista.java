package com.utn.teamA;

import java.util.ArrayList;
import java.util.List;

public class PlatoLista {

    private List<Plato> listaDePlatos;
    private PlatoPersistencia platoPersistencia;

    public PlatoLista() {
        this.platoPersistencia = new PlatoPersistencia();
    }

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
                    this.eliminarPlato();
                    break;
                case 4:
                    this.mostrarIngredientesActivos();
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

       platoPersistencia.agregarRegistro(nuevoPlato);
    }

    public void eliminarPlato(){
        listaDePlatos = platoPersistencia.obtenerRegistros();
        int i = 0;

        System.out.println(Color.ANSI_YELLOW + "\t Ingrese el codigo del plato a eliminar" + Color.ANSI_RESET);

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
            Plato plato = listaDePlatos.get(codigo);
            //TODO preguntar si este es el plato a eliminar
            System.out.println(plato);
            platoPersistencia.borrarRegistro(plato);
        }

    }

    public  void mostrarIngredientesActivos(){
        listaDePlatos = platoPersistencia.obtenerRegistros();
        for ( Plato plato : listaDePlatos ) {
            if (plato.getEstado()){
                System.out.println(plato);
            }
        }
    }
}
